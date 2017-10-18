package br.com.zedrax.services.service.impl.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.modelmapper.ModelMapper;
import org.python.core.PyList;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.ai.AiData;
import br.com.zedrax.services.model.support.ActionType;
import br.com.zedrax.services.repository.support.ActionTypeRepository;
import br.com.zedrax.services.service.interfaces.ai.IAiService;
import br.com.zedrax.services.vo.support.ActionTypeVo;
import br.com.zedrax.services.vo.support.ActionVo;
import br.com.zedrax.services.vo.support.RangeVo;

@Service("aiService")
public class AiService implements IAiService {
	
	private static Integer INDEX = 0;
	
	private static final String PIECE_DATA_SEPARATOR = ";";
	private static final String DATA_SEPARATOR = ",";
	
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
	
	private static final Integer WEIGHT_KILLED 		= -2;
	private static final Integer WEIGHT_ATTACKED 	= -1;
	private static final Integer WEIGHT_NEUTRAL 	= 0;
	private static final Integer WEIGHT_MOVE 		= 1;
	private static final Integer WEIGHT_RUN_AWAY 	= 2;
	private static final Integer WEIGHT_ATTACK 		= 2;
	private static final Integer WEIGHT_KILL_PAWN 	= 3;
	private static final Integer WEIGHT_KILL_ELITE 	= 4;
	private static final Integer WEIGHT_KILL_KING 	= 5;
	
	@Autowired
	private ActionTypeRepository actionTypeRepository;
	
	@Autowired
	private PythonInterpreter pythonInterpreter;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;
	
	private String[][] board;

	@Override
	public String[][] process(String unrealData) {
		
		List<AiData> aiData = convertUnrealDataToJavaData(unrealData);
		String[][] matrixInput = convertJavaDataToPythonMatrix(aiData);
		
//		return processWithPython(matrixInput);
		return processWithJava(matrixInput);
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
		
		Map<String, ActionTypeVo> actionTypes = actionTypeRepository
												.findAll()
												.stream()
												.map(actionTypeEntity -> convertEntityToVo(actionTypeEntity))
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
		
		String[][] pythonMatrix = aiData
									.stream()
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
	
	private ActionTypeVo convertEntityToVo(ActionType actionTypeEntity) {
		
		return modelMapper.map(actionTypeEntity, ActionTypeVo.class);
	}

	@Override
	public String[][] processWithJava(String[][] matrix) {
		
		fillBoard();
		
		Integer remainingMana = Integer.parseInt(environment.getProperty("game.turn.initial-mana"));
		Boolean hasValidActions = true;
		
		String[][] allies = Arrays.asList(matrix)
								.stream()
								.filter(piece -> piece[INDEX_IS_ALLY] == "1")
								.toArray(String[][]::new);
		
		String[][] enemies = Arrays.asList(matrix)
								.stream()
								.filter(piece -> piece[INDEX_IS_ALLY] == "0")
								.toArray(String[][]::new);
		
		Map<String, String> invalidPositions = Arrays.asList(matrix)
												.stream()
												.map(piece -> piece[INDEX_X_POSITION] + piece[INDEX_Y_POSITION])
												.collect(Collectors.toMap(Function.identity(), Function.identity()));
		
		while(remainingMana > 0 && hasValidActions) {
			
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[][] processWithPython(String[][] matrix) {
		
		pythonInterpreter.execfile(getClass().getClassLoader().getResourceAsStream("ai/first_test.py"));
		pythonInterpreter.set("matrix_input", matrix);
		
		PyList matrixOutput = (PyList) pythonInterpreter.eval("Zedrax_Ai.process_ai(matrix_input)");
		
		return (String[][]) matrixOutput.stream().toArray(String[][]::new);
	}
	
	private void fillBoard() {
		
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
	}
}