package br.com.zedrax.zedraxservices.model.piece;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zedrax.zedraxservices.model.support.RangeType;

/**
 * The persistent class for the "piece_range" database table.
 * 
 */
@Entity
@Table( name = "\"piece_range\"" )
public class PieceRange implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_range\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceRange;
	
	@Column( name = "\"range_x\"", nullable = false )
	private Byte rangeX;
	
	@Column( name = "\"range_y\"", nullable = false )
	private Byte rangeY;
	
	@ManyToOne( targetEntity = PieceSkill.class )
	@JoinColumn( name = "\"id_piece_skill\"", nullable = false )
	private PieceSkill pieceSkill;
	
	@ManyToOne( targetEntity = RangeType.class )
	@JoinColumn( name = "\"id_range_type\"", nullable = false )
	private RangeType rangeType;
	
	@ManyToOne( targetEntity = Piece.class )
	@JoinColumn( name = "\"id_piece\"", nullable = false )
	private Piece piece;
	
	public PieceRange() {}
	
	public Long getIdPieceRange()
	{
		return idPieceRange;
	}
	
	public void setIdPieceRange( Long idPieceRange )
	{
		this.idPieceRange = idPieceRange;
	}
	
	public Byte getRangeX()
	{
		return rangeX;
	}
	
	public void setRangeX( Byte rangeX )
	{
		this.rangeX = rangeX;
	}
	
	public Byte getRangeY()
	{
		return rangeY;
	}
	
	public void setRangeY( Byte rangeY )
	{
		this.rangeY = rangeY;
	}
	
	public PieceSkill getPieceSkill()
	{
		return pieceSkill;
	}
	
	public void setPieceSkill( PieceSkill pieceSkill )
	{
		this.pieceSkill = pieceSkill;
	}
	
	public RangeType getRangeType()
	{
		return rangeType;
	}
	
	public void setRangeType( RangeType rangeType )
	{
		this.rangeType = rangeType;
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