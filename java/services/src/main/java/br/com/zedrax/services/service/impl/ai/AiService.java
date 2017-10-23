package br.com.zedrax.services.service.impl.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.python.core.PyList;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.ai.AiAction;
import br.com.zedrax.services.model.ai.AiActionUnreal;
import br.com.zedrax.services.model.ai.AiData;
import br.com.zedrax.services.model.piece.Piece;
import br.com.zedrax.services.model.support.ActionType;
import br.com.zedrax.services.repository.piece.PieceRepository;
import br.com.zedrax.services.repository.support.ActionTypeRepository;
import br.com.zedrax.services.service.interfaces.ai.IAiService;
import br.com.zedrax.services.vo.piece.PieceClassVo;
import br.com.zedrax.services.vo.piece.PieceTypeVo;
import br.com.zedrax.services.vo.piece.PieceVo;
import br.com.zedrax.services.vo.support.ActionTypeVo;
import br.com.zedrax.services.vo.support.ActionVo;
import br.com.zedrax.services.vo.support.RangeVo;

@Service("aiService")
public class AiService implements IAiService {
	
	private static Integer INDEX = 0;
	
	private static final String PIECE_DATA_SEPARATOR = ";";
	private static final String DATA_SEPARATOR = ",";
	
	private static final Integer ID_MOVE   = 0;
	private static final Integer ID_ATTACK = 1;
	
	private static final Integer INDEX_IS_ALLY 				= INDEX++;
	private static final Integer INDEX_PIECE_TYPE 			= INDEX++;
	private static final Integer INDEX_Y_POSITION 			= INDEX++;
	private static final Integer INDEX_X_POSITION 			= INDEX++;
	private static final Integer INDEX_LEVEL 				= INDEX++;
	private static final Integer INDEX_HP 					= INDEX++;
	private static final Integer INDEX_HP_MAX 				= INDEX++;
	private static final Integer INDEX_ATK 					= INDEX++;
	private static final Integer INDEX_DEF 					= INDEX++;
	private static final Integer INDEX_MOVE_MANA_COST 		= INDEX++;
	private static final Integer INDEX_MOVE_X 				= INDEX++;
	private static final Integer INDEX_MOVE_Y 				= INDEX++;
	private static final Integer INDEX_MOVE_TOP 			= INDEX++;
	private static final Integer INDEX_MOVE_BOTTOM 			= INDEX++;
	private static final Integer INDEX_MOVE_LEFT 			= INDEX++;
	private static final Integer INDEX_MOVE_RIGHT 			= INDEX++;
	private static final Integer INDEX_MOVE_TOP_LEFT 		= INDEX++;
	private static final Integer INDEX_MOVE_TOP_RIGHT 		= INDEX++;
	private static final Integer INDEX_MOVE_BOTTOM_LEFT 	= INDEX++;
	private static final Integer INDEX_MOVE_BOTTOM_RIGHT 	= INDEX++;
	private static final Integer INDEX_MOVE_L 				= INDEX++;
	private static final Integer INDEX_ATTACK_MANA_COST 	= INDEX++;
	private static final Integer INDEX_ATTACK_X 			= INDEX++;
	private static final Integer INDEX_ATTACK_Y 			= INDEX++;
	private static final Integer INDEX_ATTACK_TOP 			= INDEX++;
	private static final Integer INDEX_ATTACK_BOTTOM 		= INDEX++;
	private static final Integer INDEX_ATTACK_LEFT 			= INDEX++;
	private static final Integer INDEX_ATTACK_RIGHT 		= INDEX++;
	private static final Integer INDEX_ATTACK_TOP_LEFT 		= INDEX++;
	private static final Integer INDEX_ATTACK_TOP_RIGHT 	= INDEX++;
	private static final Integer INDEX_ATTACK_BOTTOM_LEFT 	= INDEX++;
	private static final Integer INDEX_ATTACK_BOTTOM_RIGHT 	= INDEX++;
	private static final Integer INDEX_ATTACK_L 			= INDEX++;
	
	private static final Integer WEIGHT_KILLED_ON_NEXT_ACTION 		= -2;
	private static final Integer WEIGHT_ATTACKED_ON_NEXT_ACTION 	= -1;
	private static final Integer WEIGHT_NEUTRAL 					=  0;
	private static final Integer WEIGHT_MOVE 						=  1;
	private static final Integer WEIGHT_RUN_AWAY 					=  2;
	private static final Integer WEIGHT_ATTACK 						=  2;
	private static final Integer WEIGHT_HALF_KILL 					=  3;
	private static final Integer WEIGHT_ALMOST_KILL 				=  4;
	private static final Integer WEIGHT_KILL_PAWN 					=  5;
	private static final Integer WEIGHT_KILL_ELITE 					=  6;
	private static final Integer WEIGHT_KILL_KING 					=  7;
	
	private static final Integer WEIGHT_PAWN	= 1;
	private static final Integer WEIGHT_ELITE	= 2;
	
	@Autowired
	private ActionTypeRepository actionTypeRepository;
	
	@Autowired
	private PieceRepository pieceRepository;
	
	@Autowired
	private PythonInterpreter pythonInterpreter;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;

	@Override
	public List<AiActionUnreal> process(String unrealData) {
		
		List<AiData> aiData = convertUnrealDataToJavaData(unrealData);
		List<AiAction> aiActions = processWithJava(aiData);
		
		return aiActions.stream()
						.map(aiAction -> new AiActionUnreal(aiAction.getIdPiece(),
															aiAction.getIdAction(),
															aiAction.getxPositionFrom(),
															aiAction.getyPositionFrom(),
															aiAction.getxPositionTo(),
															aiAction.getyPositionTo()))
						.collect(Collectors.toList());
		
		/*return aiActions.stream()
						.map(aiAction -> new String[] {
								String.valueOf(aiAction.getIdPiece()),
								String.valueOf(aiAction.getIdAction()),
								String.valueOf(aiAction.getxPositionFrom()),
								String.valueOf(aiAction.getyPositionFrom()),
								String.valueOf(aiAction.getxPositionTo()),
								String.valueOf(aiAction.getyPositionTo())
							})
						.toArray(String[][]::new);*/
		
		/*String[][] matrixInput = convertJavaDataToPythonMatrix(aiData);
		return processWithPython(matrixInput);*/
	}

	@Override
	public List<AiData> convertUnrealDataToJavaData(String unrealData) {
		
		List<AiData> aiData = new ArrayList<>();
		AiData data;
		ActionVo move;
		ActionVo attack;
		RangeVo moveRange;
		RangeVo attackRange;
		String[] pieceDataArray = unrealData.split(PIECE_DATA_SEPARATOR);
		String[] dataOfEachPiece;
		String moveLabel = environment.getProperty("action.type.move");
		String attackLabel = environment.getProperty("action.type.attack");
		
		Map<String, ActionTypeVo> actionTypes = actionTypeRepository.findAll()
																	.stream()
																	.map(actionTypeEntity -> convertActionTypeEntityToVo(actionTypeEntity))
																	.collect(Collectors.toMap(ActionTypeVo::getType, Function.identity()));
		
		for (String pieceData : pieceDataArray) {
			
			dataOfEachPiece = pieceData.split(DATA_SEPARATOR);
			
			data = new AiData();
			move = new ActionVo();
			attack = new ActionVo();
			moveRange = new RangeVo();
			attackRange = new RangeVo();
			
			data.setAlly(Boolean.parseBoolean(dataOfEachPiece[INDEX_IS_ALLY]));
			data.setPieceType(Integer.parseInt(dataOfEachPiece[INDEX_PIECE_TYPE]));
			data.setxPosition(Integer.parseInt(dataOfEachPiece[INDEX_X_POSITION]));
			data.setyPosition(Integer.parseInt(dataOfEachPiece[INDEX_Y_POSITION]));
			data.setLevel(Integer.parseInt(dataOfEachPiece[INDEX_LEVEL]));
			data.setHp(Double.parseDouble(dataOfEachPiece[INDEX_HP]));
			data.setHpMax(Double.parseDouble(dataOfEachPiece[INDEX_HP_MAX]));
			data.setAtk(Double.parseDouble(dataOfEachPiece[INDEX_ATK]));
			data.setDef(Double.parseDouble(dataOfEachPiece[INDEX_DEF]));
			
			move.setActionType(actionTypes.get(moveLabel));
			move.setManaCost(Integer.parseInt(dataOfEachPiece[INDEX_MOVE_MANA_COST]));
			
			moveRange.setX(Integer.parseInt(dataOfEachPiece[INDEX_MOVE_X]));
			moveRange.setY(Integer.parseInt(dataOfEachPiece[INDEX_MOVE_Y]));
			moveRange.setTop(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_TOP]));
			moveRange.setBottom(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_BOTTOM]));
			moveRange.setLeft(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_LEFT]));
			moveRange.setRight(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_RIGHT]));
			moveRange.setTopLeft(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_TOP_LEFT]));
			moveRange.setTopRight(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_TOP_RIGHT]));
			moveRange.setBottomLeft(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_BOTTOM_LEFT]));
			moveRange.setBottomRight(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_BOTTOM_RIGHT]));
			moveRange.setL(Boolean.parseBoolean(dataOfEachPiece[INDEX_MOVE_L]));
			
			move.setRange(moveRange);
			
			attack.setActionType(actionTypes.get(attackLabel));
			attack.setManaCost(Integer.parseInt(dataOfEachPiece[INDEX_ATTACK_MANA_COST]));
			
			attackRange.setX(Integer.parseInt(dataOfEachPiece[INDEX_ATTACK_X]));
			attackRange.setY(Integer.parseInt(dataOfEachPiece[INDEX_ATTACK_Y]));
			attackRange.setTop(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_TOP]));
			attackRange.setBottom(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_BOTTOM]));
			attackRange.setLeft(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_LEFT]));
			attackRange.setRight(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_RIGHT]));
			attackRange.setTopLeft(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_TOP_LEFT]));
			attackRange.setTopRight(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_TOP_RIGHT]));
			attackRange.setBottomLeft(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_BOTTOM_LEFT]));
			attackRange.setBottomRight(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_BOTTOM_RIGHT]));
			attackRange.setL(Boolean.parseBoolean(dataOfEachPiece[INDEX_ATTACK_L]));
			
			attack.setRange(attackRange);
			
			data.setMove(move);
			data.setAttack(attack);
			
			aiData.add(data);
		}
		
		return aiData;
	}

	@Override
	public String[][] convertJavaDataToPythonMatrix(List<AiData> aiData) {
		
		String[][] pythonMatrix = aiData.stream()
										.map(data -> new String[] {
												data.isAlly() ? "1" : "0",
												String.valueOf(data.getPieceType()),
												String.valueOf(data.getxPosition()),
												String.valueOf(data.getyPosition()),
												String.valueOf(data.getLevel()),
												String.valueOf(data.getHp()),
												String.valueOf(data.getHpMax()),
												String.valueOf(data.getAtk()),
												String.valueOf(data.getDef()),
												String.valueOf(data.getMove().getManaCost()),
												String.valueOf(data.getMove().getRange().getX()),
												String.valueOf(data.getMove().getRange().getY()),
												data.getMove().getRange().isTop() 			? "1" : "0",
												data.getMove().getRange().isBottom() 		? "1" : "0",
												data.getMove().getRange().isLeft() 			? "1" : "0",
												data.getMove().getRange().isRight() 		? "1" : "0",
												data.getMove().getRange().isTopLeft() 		? "1" : "0",
												data.getMove().getRange().isTopRight() 		? "1" : "0",
												data.getMove().getRange().isBottomLeft() 	? "1" : "0",
												data.getMove().getRange().isBottomRight()	? "1" : "0",
												data.getMove().getRange().isL() 			? "1" : "0",
												String.valueOf(data.getAttack().getManaCost()),
												String.valueOf(data.getAttack().getRange().getX()),
												String.valueOf(data.getAttack().getRange().getY()),
												data.getAttack().getRange().isTop() 		? "1" : "0",
												data.getAttack().getRange().isBottom()		? "1" : "0",
												data.getAttack().getRange().isLeft() 		? "1" : "0",
												data.getAttack().getRange().isRight() 		? "1" : "0",
												data.getAttack().getRange().isTopLeft() 	? "1" : "0",
												data.getAttack().getRange().isTopRight() 	? "1" : "0",
												data.getAttack().getRange().isBottomLeft() 	? "1" : "0",
												data.getAttack().getRange().isBottomRight()	? "1" : "0",
												data.getAttack().getRange().isL() 			? "1" : "0",
											})
										.toArray(String[][]::new);
		
		return pythonMatrix;
	}
	
	@Override
	public List<AiAction> processWithJava(List<AiData> aiData) {
		
		List<AiAction> aiActions = new ArrayList<>();
		
		Integer remainingMana = Integer.parseInt(environment.getProperty("game.turn.initial-mana"));
		
		List<AiData> allies = separateAlliesFromMatrix(aiData);
		List<AiData> enemies = separateEnemiesFromMatrix(aiData);
		
		Integer enemyWeight;
		Integer allyWeight;
		
		PieceVo enemyPiece;
		PieceTypeVo enemyType;
		PieceClassVo enemyClass;
		AiData ally;
		PieceVo allyPiece;
		PieceTypeVo allyType;
		PieceClassVo allyClass;
		
		List<String> positionsToMove;
		List<String> positionsToAttack;
		
		Map<Long, PieceVo> idVersusNamePiece = pieceRepository.findAll()
															  .stream()
															  .map(pieceEntity -> convertPieceEntityToVo(pieceEntity))
															  .collect(Collectors.toMap(PieceVo::getIdPiece, Function.identity()));
		
		for(AiData enemy : enemies) {
			
			AiAction aiAction;
			
			enemyPiece  = idVersusNamePiece.get((long) enemy.getPieceType());
			enemyType   = enemyPiece.getPieceType();
			enemyClass  = enemyType.getPieceClass();
			enemyWeight = environment.getProperty("piece-class.pawn").equals(enemyClass.getClazz()) ? WEIGHT_PAWN : WEIGHT_ELITE;
			
			positionsToMove   = positionsToMove(enemy, aiData);
			positionsToAttack = positionsToAttack(enemy, allies);
			
			if(!positionsToAttack.isEmpty() || !positionsToMove.isEmpty()) {
				
				for (String positionToMove : positionsToMove) {
					
					aiAction = new AiAction();
					
					aiAction.setIdPiece(enemy.getPieceType());
					aiAction.setIdAction(ID_MOVE);
					aiAction.setxPositionFrom(enemy.getxPosition());
					aiAction.setyPositionFrom(enemy.getyPosition());
					
					aiAction.setxPositionTo(Integer.parseInt(positionToMove.substring(0, 1)));
					aiAction.setyPositionTo(Integer.parseInt(positionToMove.substring(1, 2)));
					
					
					
					aiAction.setManaCost(enemy.getMove().getManaCost());
					
					aiActions.add(aiAction);
				}
				
				for (String positionToAttack : positionsToAttack) {
					
					aiAction = new AiAction();
					
					aiAction.setIdPiece(enemy.getPieceType());
					aiAction.setIdAction(ID_ATTACK);
					aiAction.setxPositionFrom(enemy.getxPosition());
					aiAction.setyPositionFrom(enemy.getyPosition());
					
					ally = allies.stream()
								 .filter(allyPieceAux -> (String.valueOf(allyPieceAux.getxPosition()) + String.valueOf(allyPieceAux.getyPosition())).equals(positionToAttack))
								 .findFirst()
								 .get();
					
					allyPiece = idVersusNamePiece.get((long) ally.getPieceType());
					allyType = allyPiece.getPieceType();
					allyClass = allyType.getPieceClass();
					allyWeight = environment.getProperty("piece-class.pawn").equals(allyClass.getClazz()) ? WEIGHT_PAWN : WEIGHT_ELITE;
					
					aiAction.setxPositionTo(ally.getxPosition());
					aiAction.setyPositionTo(ally.getyPosition());
					
					
					
					aiAction.setManaCost(enemy.getAttack().getManaCost());
					
					aiActions.add(aiAction);
				}
			}
		}
		
		while(remainingMana > 0) {
			
			for(AiAction aiAction : aiActions) {
				
				
			}
		}
		
		return aiActions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[][] processWithPython(String[][] matrix) {
		
		pythonInterpreter.execfile(getClass().getClassLoader().getResourceAsStream("ai/first_test.py"));
		pythonInterpreter.set("matrix_input", matrix);
		
		PyList matrixOutput = (PyList) pythonInterpreter.eval("Zedrax_Ai.process_ai(matrix_input)");
		
		return (String[][]) matrixOutput.stream()
										.toArray(String[][]::new);
	}
	
	private List<AiData> separateAlliesFromMatrix(List<AiData> aiData) {
		
		return separatePieces(aiData, true);
	}
	
	private List<AiData> separateEnemiesFromMatrix(List<AiData> aiData) {
		
		return separatePieces(aiData, false);
	}
	
	private List<AiData> separatePieces(List<AiData> aiData, Boolean isAlly) {
		
		return aiData.stream()
					 .filter(piece -> isAlly == piece.isAlly())
					 .collect(Collectors.toList());
	}
	
	private List<String> positionsToMove(AiData piece, List<AiData> aiData) {
		
		List<String> positions;
		List<String> invalidPositionsToMove = aiData.stream()
													.map(pieceAux -> String.valueOf(pieceAux.getxPosition()) + String.valueOf(pieceAux.getyPosition()))
													.collect(Collectors.toList());
		
		positions = positionsToDoSomething(piece, true);
		positions.removeAll(invalidPositionsToMove);
		
		return positions;
	}
	
	private List<String> positionsToAttack(AiData piece, List<AiData> enemiesOfPiece) {
		
		List<String> positions;
		List<String> enemiesOfPiecePositions = enemiesOfPiece.stream()
															 .map(enemyOfPiece -> String.valueOf(enemyOfPiece.getxPosition()) + String.valueOf(enemyOfPiece.getyPosition()))
															 .collect(Collectors.toList());
		
		positions = positionsToDoSomething(piece, false);
		positions.retainAll(enemiesOfPiecePositions);
		
		return positions;
	}
	
	private List<String> positionsToDoSomething(AiData piece, Boolean isMove) {
		
		List<String> positions = new ArrayList<>();
		
		Integer xPosition = piece.getxPosition();
		Integer yPosition = piece.getyPosition();
		
		ActionVo action = isMove ? piece.getMove() : piece.getAttack();
		RangeVo range = action.getRange();
		Boolean l = range.isL();
		
		if(!l) {
			positions.addAll(calculatePositionsForNonLActions(xPosition, yPosition, range));
		} else {
			positions.addAll(calculatePositionsForLActions(xPosition, yPosition, range));
		}
		
		return positions;
	}
	
	// Calcula posicoes validas para acoes de pecas que nao tem caracteristicas de acao em L
	private List<String> calculatePositionsForNonLActions(Integer xPosition, Integer yPosition, RangeVo range) {
		
		List<String> positions = new ArrayList<>();
		Integer xRange = range.getX();
		Integer yRange = range.getY();
		Integer xResult;
		Integer yResult;
		Integer x = 1;
		Integer y = 1;
		
		while(x <= xRange || y <= yRange) {
			
			if(range.isTop()) {
				
				xResult = xPosition;
				yResult = yPosition + y;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isBottom()) {
				
				xResult = xPosition;
				yResult = yPosition - y;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isLeft()) {
				
				xResult = xPosition - x;
				yResult = yPosition;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isRight()) {
				
				xResult = xPosition + x;
				yResult = yPosition;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isTopLeft()) {
				
				xResult = xPosition - x;
				yResult = yPosition + y;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isTopRight()) {
				
				xResult = xPosition + x;
				yResult = yPosition + y;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isBottomLeft()) {
				
				xResult = xPosition - x;
				yResult = yPosition - y;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			if(range.isBottomRight()) {
				
				xResult = xPosition + x;
				yResult = yPosition - y;
				
				if(validatePosition(xResult, yResult)) {
					positions.add(position(xResult, yResult));
				}
			}
			
			if(x < xRange) {
				x++;
			}
			
			if(y < yRange) {
				y++;
			}
		}
		
		return positions;
	}
	
	// Calcula posicoes validas para acoes de pecas que tem caracteristicas de acao em L
	private List<String> calculatePositionsForLActions(Integer xPosition, Integer yPosition, RangeVo range) {
		
		List<String> positions = new ArrayList<>();
		Integer xResult;
		Integer yResult;
		Integer x;
		Integer y;
		
		/*
		 *  Para acoes em L, ha sempre 8 possibilidades
		 *  Considerando uma peca na posicao (x, y), as acoes em L possiveis sao:
		 *  1. x + 1, y + 2 (acao na vertical)
		 *  2. x + 2, y + 1 (acao na horizontal)
		 *  3. x + 2, y - 1 (acao na horizontal)
		 *  4. x + 1, y - 2 (acao na vertical)
		 *  5. x - 1, y - 2 (acao na vertical)
		 *  6. x - 2, y - 1 (acao na horizontal)
		 *  7. x - 2, y + 1 (acao na horizontal)
		 *  8. x - 1, y + 2 (acao na vertical)
		 */
		
		x = 1;
		y = 2;
		
		/*
		 *  Loop de duas iteracoes para trocar o valor de x e y e processar tanto as acoes
		 *  na horizontal, quanto na vertical
		 */
		
		for(int i = 0; i < 2; i++) {
			
			xResult = xPosition + x;
			yResult = yPosition + y;
			
			if(validatePosition(xResult, yResult)) {
				positions.add(position(xResult, yResult));
			}
			
			xResult = xPosition + x;
			yResult = yPosition - y;
			
			if(validatePosition(xResult, yResult)) {
				positions.add(position(xResult, yResult));
			}
			
			xResult = xPosition - x;
			yResult = yPosition - y;
			
			if(validatePosition(xResult, yResult)) {
				positions.add(position(xResult, yResult));
			}
			
			xResult = xPosition - x;
			yResult = yPosition + y;
			
			if(validatePosition(xResult, yResult)) {
				positions.add(position(xResult, yResult));
			}
			
			x = 2;
			y = 1; 
		}
		
		return positions;
	}
	
	private String position(Integer x, Integer y) {
		
		return String.valueOf(x) + String.valueOf(y);
	}
	
	private boolean validatePosition(Integer x, Integer y) {
		
		return ((x >= 0 && x <= 10) && (y >= 0 && y <= 10));
	}
	
	private ActionTypeVo convertActionTypeEntityToVo(ActionType actionTypeEntity) {
		
		return modelMapper.map(actionTypeEntity, ActionTypeVo.class);
	}
	
	private PieceVo convertPieceEntityToVo(Piece pieceEntity) {
		
		return modelMapper.map(pieceEntity, PieceVo.class);
	}
	
	/*private void fillBoard() {
		
		if(null == this.board) {
			
			Integer width = Integer.parseInt(environment.getProperty("game.board.width"));
			Integer height = Integer.parseInt(environment.getProperty("game.board.height"));
			
			String[][] board = IntStream.range(0, width)
										.mapToObj(x -> IntStream.range(0, height)
												.mapToObj(y -> String.format("%d%d", x, y))
												.toArray(String[]::new))
										.toArray(String[][]::new);
			
			this.board = board;
		}
	}*/
}