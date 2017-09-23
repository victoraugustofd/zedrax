package br.com.zedrax.services.model.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zedrax.services.model.piece.Piece;
import br.com.zedrax.services.model.time.TurnAction;

/**
 * The persistent class for the "affected_pieces" database table.
 * 
 */
@Entity
@Table( name = "\"affected_pieces\"" )
public class AffectedPieces implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_affected_pieces\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idAffectedPieces;
	
	@ManyToOne( targetEntity = Piece.class )
	@JoinColumn( name = "\"id_piece\"", nullable = false )
	private Piece piece;
	
	@ManyToOne( targetEntity = TurnAction.class )
	@JoinColumn( name = "\"id_turn_action\"", nullable = false )
	private TurnAction turnAction;
	
	public AffectedPieces()	{}
	
	public Long getIdAffectedPieces()
	{
		return idAffectedPieces;
	}
	
	public void setIdAffectedPieces( Long idAffectedPieces )
	{
		this.idAffectedPieces = idAffectedPieces;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setPiece( Piece piece )
	{
		this.piece = piece;
	}
	
	public TurnAction getTurnAction()
	{
		return turnAction;
	}
	
	public void setTurnAction( TurnAction turnAction )
	{
		this.turnAction = turnAction;
	}
}