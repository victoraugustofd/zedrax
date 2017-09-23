package br.com.zedrax.services.model.piece;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.services.model.time.Turn;

/**
 * The persistent class for the "piece_turn_skill" database table.
 * 
 */
@Entity
@Table( name = "\"piece_turn_skill\"" )
public class PieceTurnSkill implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_turn_skill\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceTurnSkill;
	
	@Column( name = "\"cost\"", nullable = false )
	private Integer cost;
	
	@Column( name = "\"duration\"", nullable = false )
	@Length( max = 5 )
	private Integer duration;
	
	@ManyToOne( targetEntity = Piece.class )
	@JoinColumn( name = "\"id_piece\"", nullable = false )
	private Piece piece;
	
	@ManyToOne( targetEntity = PieceSkill.class )
	@JoinColumn( name = "\"id_piece_skill\"", nullable = false )
	private PieceSkill pieceSkill;
	
	@ManyToOne( targetEntity = Turn.class )
	@JoinColumn( name = "\"id_turn\"", nullable = false )
	private Turn turn;
	
	public PieceTurnSkill() {}
	
	public Long getIdPieceTurnSkill()
	{
		return idPieceTurnSkill;
	}
	
	public void setIdPieceTurnSkill( Long idPieceTurnSkill )
	{
		this.idPieceTurnSkill = idPieceTurnSkill;
	}
	
	public Integer getCost()
	{
		return cost;
	}
	
	public void setCost( Integer cost )
	{
		this.cost = cost;
	}
	
	public Integer getDuration()
	{
		return duration;
	}
	
	public void setDuration( Integer duration )
	{
		this.duration = duration;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setPiece( Piece piece )
	{
		this.piece = piece;
	}
	
	public PieceSkill getPieceSkill()
	{
		return pieceSkill;
	}
	
	public void setPieceSkill( PieceSkill pieceSkill )
	{
		this.pieceSkill = pieceSkill;
	}
	
	public Turn getTurn()
	{
		return turn;
	}
	
	public void setTurn( Turn turn )
	{
		this.turn = turn;
	}
}