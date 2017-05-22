package br.com.zedrax.services.model.skill;

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

import br.com.zedrax.services.model.piece.PieceSkillLevel;

/**
 * The persistent class for the "skill_effect_type_level" database table.
 * 
 */
@Entity
@Table( name = "\"skill_effect_type_level\"" )
public class SkillEffectTypeLevel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_skill_effect_type_level\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idSkillEffectTypeLevel;
	
	@Column( name = "\"point\"", nullable = false )
	@Length( max = 5 )
	private Integer point;
	
	@ManyToOne( targetEntity = PieceSkillLevel.class )
	@JoinColumn( name = "\"id_piece_skill_level\"", nullable = false )
	private PieceSkillLevel pieceSkillLevel;
	
	@ManyToOne( targetEntity = PieceSkillLevel.class )
	@JoinColumn( name = "\"id_skill_effect_type\"", nullable = false )
	private SkillEffectType skillEffectType;
	
	public SkillEffectTypeLevel() {}
	
	public Long getIdSkillEffectTypeLevel()
	{
		return idSkillEffectTypeLevel;
	}
	
	public void setIdSkillEffectTypeLevel( Long idSkillEffectTypeLevel )
	{
		this.idSkillEffectTypeLevel = idSkillEffectTypeLevel;
	}
	
	public Integer getPoint()
	{
		return point;
	}
	
	public void setPoint( Integer point )
	{
		this.point = point;
	}
	
	public PieceSkillLevel getPieceSkillLevel()
	{
		return pieceSkillLevel;
	}
	
	public void setPieceSkillLevel( PieceSkillLevel pieceSkillLevel )
	{
		this.pieceSkillLevel = pieceSkillLevel;
	}
	
	public SkillEffectType getSkillEffectType()
	{
		return skillEffectType;
	}
	
	public void setSkillEffectType( SkillEffectType skillEffectType )
	{
		this.skillEffectType = skillEffectType;
	}
}