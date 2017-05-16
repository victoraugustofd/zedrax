package br.com.zedrax.zedraxservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.zedraxservices.model.piece.PieceType;

@Repository
public interface PieceTypeRepository extends JpaRepository< PieceType, Long >
{
	
}