package br.com.zedrax.zedraxservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zedrax.zedraxservices.model.piece.PieceTypeClass;

public interface PieceTypeClassRepository extends JpaRepository< PieceTypeClass, Long >
{
	/*PieceTypeClass retrievePieceTypeClassById( Integer idPieceTypeClass );
	PieceTypeClass retrievePieceTypeClassByName( String pieceTypeClassName );*/
}