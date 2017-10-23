package br.com.zedrax.services.loader.piece;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.piece.PieceClass;
import br.com.zedrax.services.repository.piece.PieceClassRepository;

@Component("pieceClassLoader")
@Order(value = 1)
public class PieceClassLoader implements ApplicationRunner {

    @Value("${piece-class.pawn}")
    private String pawn;

    @Value("${piece-class.elite}")
    private String elite;

    @SuppressWarnings("unused")
    private final static Logger logger = Logger.getLogger(PieceClassLoader.class);

    @Autowired
    private PieceClassRepository repository;

    public void run(ApplicationArguments args) {

        List<PieceClass> listFromDb = repository.findAll();
        List<PieceClass> newList = new ArrayList<>();

        newList.add(new PieceClass(pawn));
        newList.add(new PieceClass(elite));

        newList.removeAll(listFromDb);

        repository.save(newList);
    }
}