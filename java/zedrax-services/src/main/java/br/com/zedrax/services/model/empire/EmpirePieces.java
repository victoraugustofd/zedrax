package br.com.zedrax.services.model.empire;

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

/**
 * The persistent class for the "empire_pieces" database table.
 * 
 */
@Entity
@Table( name = "\"empire_pieces\"" )
public class EmpirePieces implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_empire_pieces\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idEmpirePieces;
	
	@ManyToOne( targetEntity = Empire.class )
	@JoinColumn( name = "\"id_empire\"", nullable = false )
	private Empire empire;
	
	@ManyToOne( targetEntity = Piece.class )
	@JoinColumn( name = "\"id_piece\"", nullable = false )
	private Piece piece;
	
	public EmpirePieces() {}
	
	public Long getIdEmpirePieces()
	{
		return this.idEmpirePieces;
	}
	
	public void setIdEmpirePieces( Long idEmpirePieces )
	{
		this.idEmpirePieces = idEmpirePieces;
	}
	
	public Empire getEmpire()
	{
		return this.empire;
	}
	
	public void setEmpire( Empire empire )
	{
		this.empire = empire;
	}
	
	public Piece getPiece()
	{
		return piece;
	}

	public void setPiece( Piece piece )
	{
		this.piece = piece;
	}
}