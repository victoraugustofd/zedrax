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

import br.com.zedrax.zedraxservices.model.skill.SkillEffectType;

/**
 * The persistent class for the "piece_skill_effect_type" database table.
 * 
 */
@Entity
@Table( name = "\"piece_skill_effect_type\"" )
public class PieceSkillEffectType implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_skill_effect_type\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceSkillEffectType;
	
	@ManyToOne( targetEntity = PieceSkill.class )
	@JoinColumn( name = "\"id_piece_skill\"", nullable = false )
	private PieceSkill pieceSkill;
	
	@ManyToOne( targetEntity = SkillEffectType.class )
	@JoinColumn( name = "\"id_skill_effect_type\"", nullable = false )
	private SkillEffectType skillEffectType;
	
	public PieceSkillEffectType() {}
	
	public Long getIdPieceSkillEffectType()
	{
		return idPieceSkillEffectType;
	}
	
	public void setIdPieceSkillEffectType( Long idPieceSkillEffectType )
	{
		this.idPieceSkillEffectType = idPieceSkillEffectType;
	}
	
	public PieceSkill getPieceSkill()
	{
		return pieceSkill;
	}
	
	public void setPieceSkill( PieceSkill pieceSkill )
	{
		this.pieceSkill = pieceSkill;
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