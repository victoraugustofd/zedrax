package br.com.zedrax.services.service.interfaces.piece;

import java.util.List;

import br.com.zedrax.services.model.piece.Piece;
import br.com.zedrax.services.model.piece.PieceType;

public interface IPieceService {
	List<Piece> retrieveInitialData();
	List<PieceType> retrievePieceTypeList();
}