package br.com.zedrax.services.repository.piece;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.piece.PieceType;

@Repository( "pieceTypeRepository" )
public interface PieceTypeRepository extends JpaRepository< PieceType, Long >
{
	
}