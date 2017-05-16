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

import br.com.zedrax.zedraxservices.model.piece.PieceSkill;

/**
 * The persistent class for the "skill_type" database table.
 * 
 */
@Entity
@Table( name = "\"skill_type\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"type\"" ) )
public class SkillType implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_skill_type\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idSkillType;
	
	@Column( name = "\"type\"", nullable = false )
	@Length( max = 45 )
	private String type;
	
	@OneToMany( mappedBy = "skillType", targetEntity = PieceSkill.class )
	private List< PieceSkill > pieceSkills;
	
	public SkillType() {}
	
	public Long getIdSkillType()
	{
		return idSkillType;
	}
	
	public void setIdSkillType( Long idSkillType )
	{
		this.idSkillType = idSkillType;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType( String type )
	{
		this.type = type;
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