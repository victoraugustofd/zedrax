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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.skill.SkillEffectType;
import br.com.zedrax.zedraxservices.model.skill.SkillLevel;
import br.com.zedrax.zedraxservices.model.skill.SkillType;

/**
 * The persistent class for the "piece_skill" database table.
 * 
 */
@Entity
@Table( name = "\"piece_skill\"" )
public class PieceSkill implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_skill\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceSkill;
	
	@Column( name = "\"description\"", nullable = false )
	@Length( max = 150 )
	private String description;
	
	@Column( name = "\"name\"", nullable = false )
	@Length( max = 100 )
	private String name;
	
	@ManyToOne( targetEntity = Piece.class )
	@JoinColumn( name = "\"id_piece\"", nullable = false )
	private Piece piece;
	
	@ManyToOne( targetEntity = SkillEffectType.class )
	@JoinColumn( name = "\"id_skill_effect_type\"", nullable = false )
	private SkillEffectType skillEffectType;
	
	@ManyToOne( targetEntity = SkillLevel.class )
	@JoinColumn( name = "\"id_skill_level\"", nullable = false )
	private SkillLevel skillLevel;
	
	@ManyToOne( targetEntity = SkillType.class )
	@JoinColumn( name = "\"id_skill_type\"", nullable = false )
	private SkillType skillType;
	
	@OneToMany( mappedBy = "pieceSkill", targetEntity = PieceRange.class )
	private List< PieceRange > pieceRanges;
	
	@OneToOne( mappedBy = "pieceSkill", targetEntity = PieceTurnSkill.class )
	private PieceTurnSkill pieceTurnSkill;
	
	public PieceSkill() {}
	
	public Long getIdPieceSkill()
	{
		return idPieceSkill;
	}
	
	public void setIdPieceSkill( Long idPieceSkill )
	{
		this.idPieceSkill = idPieceSkill;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription( String description )
	{
		this.description = description;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setPiece( Piece piece )
	{
		this.piece = piece;
	}
	
	public SkillEffectType getSkillEffectType()
	{
		return skillEffectType;
	}
	
	public void setSkillEffectType( SkillEffectType skillEffectType )
	{
		this.skillEffectType = skillEffectType;
	}
	
	public SkillLevel getSkillLevel()
	{
		return skillLevel;
	}
	
	public void setSkillLevel( SkillLevel skillLevel )
	{
		this.skillLevel = skillLevel;
	}
	
	public SkillType getSkillType()
	{
		return skillType;
	}
	
	public void setSkillType( SkillType skillType )
	{
		this.skillType = skillType;
	}
	
	public List< PieceRange > getPieceRanges()
	{
		return pieceRanges;
	}
	
	public void setPieceRanges( List< PieceRange > pieceRanges )
	{
		this.pieceRanges = pieceRanges;
	}
	
	public PieceTurnSkill getPieceTurnSkill()
	{
		return pieceTurnSkill;
	}
	
	public void setPieceTurnSkill( PieceTurnSkill pieceTurnSkill )
	{
		this.pieceTurnSkill = pieceTurnSkill;
	}
}