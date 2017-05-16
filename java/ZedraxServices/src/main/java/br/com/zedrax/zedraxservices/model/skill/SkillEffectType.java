package br.com.zedrax.zedraxservices.model.skill;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.piece.PieceSkillEffectType;

/**
 * The persistent class for the "skill_effect_type" database table.
 * 
 */
@Entity
@Table( name = "\"skill_effect_type\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"effect_type\"" ) )
public class SkillEffectType implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_skill_effect_type\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idSkillEffectType;
	
	@Column( name = "\"effect_type\"", nullable = false )
	@Length( max = 100 )
	private String effectType;
	
	@OneToMany( mappedBy = "skillEffectType", targetEntity = PieceSkillEffectType.class )
	private List< PieceSkillEffectType > pieceSkillEffectTypes;
	
	@OneToMany( mappedBy = "skillEffectType", targetEntity = SkillEffectTypeLevel.class )
	private List< SkillEffectTypeLevel > skillEffectTypeLevels;
	
	public SkillEffectType() {}
	
	public Long getIdSkillEffectType()
	{
		return idSkillEffectType;
	}
	
	public void setIdSkillEffectType( Long idSkillEffectType )
	{
		this.idSkillEffectType = idSkillEffectType;
	}
	
	public String getEffectType()
	{
		return effectType;
	}
	
	public void setEffectType( String effectType )
	{
		this.effectType = effectType;
	}
	
	public List< PieceSkillEffectType > getPieceSkillEffectTypes()
	{
		return pieceSkillEffectTypes;
	}
	
	public void setPieceSkillEffectTypes( List< PieceSkillEffectType > pieceSkillEffectTypes )
	{
		this.pieceSkillEffectTypes = pieceSkillEffectTypes;
	}
	
	public List< SkillEffectTypeLevel > getSkillEffectTypeLevels()
	{
		return skillEffectTypeLevels;
	}
	
	public void setSkillEffectTypeLevels( List< SkillEffectTypeLevel > skillEffectTypeLevels )
	{
		this.skillEffectTypeLevels = skillEffectTypeLevels;
	}
}