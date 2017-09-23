package br.com.zedrax.services.model.skill;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.services.model.piece.PieceSkill;

/**
 * The persistent class for the "skill_level" database table.
 * 
 */
@Entity
@Table( name = "\"skill_level\"" )
public class SkillLevel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_skill_level\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idSkillLevel;
	
	@Column( name = "\"level\"", nullable = false )
	@Length( max = 45 )
	private String level;
	
	@OneToMany( mappedBy = "skillLevel", targetEntity = PieceSkill.class )
	private List< PieceSkill > pieceSkills;
	
	public SkillLevel() {}
	
	public Long getIdSkillLevel()
	{
		return idSkillLevel;
	}
	
	public void setIdSkillLevel( Long idSkillLevel )
	{
		this.idSkillLevel = idSkillLevel;
	}
	
	public String getLevel()
	{
		return level;
	}
	
	public void setLevel( String level )
	{
		this.level = level;
	}
	
	public List< PieceSkill > getPieceSkills()
	{
		return pieceSkills;
	}
	
	public void setPieceSkills( List< PieceSkill > pieceSkills )
	{
		this.pieceSkills = pieceSkills;
	}
}