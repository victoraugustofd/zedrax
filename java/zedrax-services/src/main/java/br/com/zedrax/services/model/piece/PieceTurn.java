package br.com.zedrax.services.model.piece;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import br.com.zedrax.services.model.time.Turn;

/**
 * The persistent class for the "piece_turn" database table.
 * 
 */
@Entity
@Table( name = "\"piece_turn\"" )
public class PieceTurn implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_turn\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceTurn;
	
	@Column( name = "\"atk_cost\"", nullable = false )
	private Integer atkCost;
	
	@Column( name = "\"basic_atk\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal basicAtk;
	
	@Column( name = "\"basic_def\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal basicDef;
	
	@Column( name = "\"current_column\"", nullable = false )
	private Byte currentColumn;
	
	@Column( name = "\"current_row\"", nullable = false )
	private Byte currentRow;
	
	@Column( name = "\"hp\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal hp;
	
	@Column( name = "\"level\"", nullable = false )
	private Integer level;
	
	@Column( name = "\"mov_cost\"", nullable = false )
	private Integer movCost;
	
	@Column( name = "\"skill_def\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal skillDef;
	
	@Column( name = "\"xp\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal xp;
	
	@ManyToOne( targetEntity = Piece.class )
	@JoinColumn( name = "\"id_piece\"", nullable = false )
	private Piece piece;
	
	@ManyToOne( targetEntity = PieceTurnStatus.class )
	@JoinColumn( name = "\"id_piece_turn_status\"", nullable = false )
	private PieceTurnStatus pieceTurnStatus;
	
	@ManyToOne( targetEntity = Turn.class )
	@JoinColumn( name = "\"id_turn\"", nullable = false )
	private Turn turn;
	
	public PieceTurn() {}
	
	public Long getIdPieceTurn()
	{
		return idPieceTurn;
	}
	
	public void setIdPieceTurn( Long idPieceTurn )
	{
		this.idPieceTurn = idPieceTurn;
	}
	
	public Integer getAtkCost()
	{
		return atkCost;
	}
	
	public void setAtkCost( Integer atkCost )
	{
		this.atkCost = atkCost;
	}
	
	public BigDecimal getBasicAtk()
	{
		return basicAtk;
	}
	
	public void setBasicAtk( BigDecimal basicAtk )
	{
		this.basicAtk = basicAtk;
	}
	
	public BigDecimal getBasicDef()
	{
		return basicDef;
	}
	
	public void setBasicDef( BigDecimal basicDef )
	{
		this.basicDef = basicDef;
	}
	
	public Byte getCurrentColumn()
	{
		return currentColumn;
	}
	
	public void setCurrentColumn( Byte currentColumn )
	{
		this.currentColumn = currentColumn;
	}
	
	public Byte getCurrentRow()
	{
		return currentRow;
	}
	
	public void setCurrentRow( Byte currentRow )
	{
		this.currentRow = currentRow;
	}
	
	public BigDecimal getHp()
	{
		return hp;
	}
	
	public void setHp( BigDecimal hp )
	{
		this.hp = hp;
	}
	
	public Integer getLevel()
	{
		return level;
	}
	
	public void setLevel( Integer level )
	{
		this.level = level;
	}
	
	public Integer getMovCost()
	{
		return movCost;
	}
	
	public void setMovCost( Integer movCost )
	{
		this.movCost = movCost;
	}
	
	public BigDecimal getSkillDef()
	{
		return skillDef;
	}
	
	public void setSkillDef( BigDecimal skillDef )
	{
		this.skillDef = skillDef;
	}
	
	public BigDecimal getXp()
	{
		return xp;
	}
	
	public void setXp( BigDecimal xp )
	{
		this.xp = xp;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setPiece( Piece piece )
	{
		this.piece = piece;
	}
	
	public PieceTurnStatus getPieceTurnStatus()
	{
		return pieceTurnStatus;
	}
	
	public void setPieceTurnStatus( PieceTurnStatus pieceTurnStatus )
	{
		this.pieceTurnStatus = pieceTurnStatus;
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