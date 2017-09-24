package br.com.zedrax.services.loader.piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.piece.PieceClass;
import br.com.zedrax.services.model.piece.PieceType;
import br.com.zedrax.services.repository.piece.PieceClassRepository;
import br.com.zedrax.services.repository.piece.PieceTypeRepository;

@Component("pieceTypeLoader")
@Order(value = 2)
public class PieceTypeLoader implements ApplicationRunner {
	@Value("${piece_type.king}")
	private String king;

	@Value("${piece_type.queen}")
	private String queen;

	@Value("${piece_type.rook}")
	private String rook;

	@Value("${piece_type.bishop}")
	private String bishop;

	@Value("${piece_type.knight}")
	private String knight;

	@Value("${piece_type.warrior}")
	private String warrior;

	@Value("${piece_type.tank}")
	private String tank;

	@Value("${piece_type.archer}")
	private String archer;

	@Value("${piece_type.ninja}")
	private String ninja;

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(PieceTypeLoader.class);

	@Autowired
	private PieceTypeRepository pieceTypeRepository;

	@Autowired
	private PieceClassRepository pieceClassRepository;

	@Autowired
	private Environment environment;

	public void run(ApplicationArguments args) {
		List<PieceType> listFromDb = pieceTypeRepository.findAll();
		List<PieceType> newList = new ArrayList<>();

		String pawn = environment.getProperty("piece_class.pawn");
		String elite = environment.getProperty("piece_class.elite");

		Map<String, PieceClass> pieceTypeClasses = pieceClassRepository.findAll().stream()
				.collect(Collectors.toMap(PieceClass::getClazz, Function.identity()));

		newList.add(new PieceType(king, pieceTypeClasses.get(elite)));
		newList.add(new PieceType(queen, pieceTypeClasses.get(elite)));
		newList.add(new PieceType(rook, pieceTypeClasses.get(elite)));
		newList.add(new PieceType(bishop, pieceTypeClasses.get(elite)));
		newList.add(new PieceType(knight, pieceTypeClasses.get(elite)));
		newList.add(new PieceType(warrior, pieceTypeClasses.get(pawn)));
		newList.add(new PieceType(tank, pieceTypeClasses.get(pawn)));
		newList.add(new PieceType(archer, pieceTypeClasses.get(pawn)));
		newList.add(new PieceType(ninja, pieceTypeClasses.get(pawn)));

		newList.removeAll(listFromDb);

		pieceTypeRepository.save(newList);
	}
}