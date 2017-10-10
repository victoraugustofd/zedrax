package br.com.zedrax.services.repository.piece;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.piece.Piece;

@Repository("pieceRepository")
public interface PieceRepository extends JpaRepository<Piece, Long> {

}