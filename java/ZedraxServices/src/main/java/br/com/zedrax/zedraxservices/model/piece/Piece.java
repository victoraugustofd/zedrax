package br.com.zedrax.zedraxservices.model.piece;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.empire.EmpirePieces;
import br.com.zedrax.zedraxservices.model.support.AffectedPieces;

/**
 * The persistent class for the "piece" database table.
 * 
 */
@Entity
@Table( name = "\"piece\"" )
public class Piece implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPiece;
	
	@Column( name = "\"name\"", nullable = false )
	@Length( max = 45 )
	private String name;
	
	@ManyToOne( targetEntity = PieceType.class )
	@JoinColumn( name = "\"id_piece_type\"", nullable = false )
	private PieceType pieceType;
	
	@OneToMany( mappedBy = "piece", targetEntity = AffectedPieces.class )
	private List< AffectedPieces > affectedPieces;
	
	@OneToMany( mappedBy = "piece", targetEntity = EmpirePieces.class )
	private List< EmpirePieces > empirePieces;
	
	@OneToMany( mappedBy = "piece", targetEntity = PieceTurn.class )
	private List< PieceTurn > pieceTurns;
	
	@OneToMany( mappedBy = "piece", targetEntity = PieceLevel.class )
	private List< PieceLevel > pieceLevels;
	
	public Piece() {}
	
	public Long getIdPiece()
	{
		return this.idPiece;
	}
	
	public void setIdPiece( Long idPiece )
	{
		this.idPiece = idPiece;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public List< EmpirePieces > getEmpirePiece()
	{
		return this.empirePieces;
	}
	
	public void setEmpirePieces( List< EmpirePieces > empirePieces )
	{
		this.empirePieces = empirePieces;
	}
	
	public PieceType getPieceType()
	{
		return this.pieceType;
	}
	
	public void setPieceType( PieceType pieceType )
	{
		this.pieceType = pieceType;
	}
	
	public List< AffectedPieces > getAffectedPieces()
	{
		return affectedPieces;
	}
	
	public void setAffectedPieces( List< AffectedPieces > affectedPieces )
	{
		this.affectedPieces = affectedPieces;
	}
	
	public List< PieceTurn > getPieceTurns()
	{
		return pieceTurns;
	}
	
	public void setPieceTurns( List< PieceTurn > pieceTurns )
	{
		this.pieceTurns = pieceTurns;
	}
	
	public List< PieceLevel > getPieceLevels()
	{
		return pieceLevels;
	}
	
	public void setPieceLevels( List< PieceLevel > pieceLevels )
	{
		this.pieceLevels = pieceLevels;
	}
	
	public List< EmpirePieces > getEmpirePieces()
	{
		return empirePieces;
	}
}