package br.com.zedrax.services.model.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the "user_level" database table.
 * 
 */
@Entity
@Table( name = "\"user_level\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"level\"" ) )
public class UserLevel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_user_level\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idUserLevel;
	
	@Column( name = "\"level\"", nullable = false )
	@Length( max = 45 )
	private String level;
	
	@Column( name = "\"xp_for_next_level\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal xpForNextLevel;
	
	@OneToMany( mappedBy = "userLevel", targetEntity = User.class )
	private List< User > user;
	
	public UserLevel() {}
	
	public Long getIdUserLevel()
	{
		return idUserLevel;
	}
	
	public void setIdUserLevel( Long idUserLevel )
	{
		this.idUserLevel = idUserLevel;
	}
	
	public String getLevel()
	{
		return level;
	}
	
	public void setLevel( String level )
	{
		this.level = level;
	}
	
	public BigDecimal getXpForNextLevel()
	{
		return xpForNextLevel;
	}
	
	public void setXpForNextLevel( BigDecimal xpForNextLevel )
	{
		this.xpForNextLevel = xpForNextLevel;
	}
	
	public List< User > getUser()
	{
		return user;
	}
	
	public void setUser( List< User > user )
	{
		this.user = user;
	}
}