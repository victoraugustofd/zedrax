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

/**
 * The persistent class for the "piece_skill_level" database table.
 * 
 */
@Entity
@Table( name = "\"piece_skill_level\"" )
public class PieceSkillLevel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_skill_level\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceSkillLevel;
	
	@Column( name = "\"cost\"", nullable = false )
	private Integer cost;
	
	@Column( name = "\"duration\"", nullable = false )
	@Length( max = 5 )
	private Integer duration;
	
	@ManyToOne( targetEntity = PieceLevel.class )
	@JoinColumn( name = "\"id_piece_level\"", nullable = false )
	private PieceLevel pieceLevel;
	
	public PieceSkillLevel() {}
	
	public Long getIdPieceSkillLevel()
	{
		return idPieceSkillLevel;
	}
	
	public void setIdPieceSkillLevel( Long idPieceSkillLevel )
	{
		this.idPieceSkillLevel = idPieceSkillLevel;
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
	
	public PieceLevel getPieceLevel()
	{
		return pieceLevel;
	}
	
	public void setPieceLevel( PieceLevel pieceLevel )
	{
		this.pieceLevel = pieceLevel;
	}
}