package br.com.zedrax.services.service.impl.piece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.zedrax.services.model.piece.Piece;
import br.com.zedrax.services.model.piece.PieceType;
import br.com.zedrax.services.repository.piece.PieceRepository;
import br.com.zedrax.services.repository.piece.PieceTypeRepository;
import br.com.zedrax.services.service.interfaces.piece.IPieceService;

@Service("pieceService")
public class PieceService implements IPieceService {

    @Autowired
    private PieceRepository pieceRepository;

    @Autowired
    private PieceTypeRepository typeRepository;

    @Override
    public List<Piece> retrieveInitialData() {
        return pieceRepository.findAll();
    }

    @Override
    public List<PieceType> retrievePieceTypeList() {

        return typeRepository.findAll();
    }
}