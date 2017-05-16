package br.com.zedrax.zedraxservices.model.empire;

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
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.game.GameEmpire;
import br.com.zedrax.zedraxservices.model.user.User;

/**
 * The persistent class for the "empire" database table.
 * 
 */
@Entity
@Table( name = "\"empire\"" )
public class Empire implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_empire\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idEmpire;
	
	@Column( name = "\"name\"", nullable = false )
	@Length( max = 45 )
	private String name;
	
	@ManyToOne( targetEntity = User.class )
	@JoinColumn( name = "\"id_user\"", nullable = false )
	private User user;
	
	@ManyToOne( targetEntity = EmpireStatus.class )
	@JoinColumn( name = "\"id_empire_status\"", nullable = false )
	private EmpireStatus empireStatus;
	
	@OneToMany( mappedBy = "empire", targetEntity = EmpirePieces.class )
	private List< EmpirePieces > empirePieces;
	
	@OneToMany( mappedBy = "empire", targetEntity = GameEmpire.class )
	private List< GameEmpire > gameEmpires;
	
	public Empire() {}
	
	public Long getIdEmpire()
	{
		return idEmpire;
	}
	
	public void setIdEmpire( Long idEmpire )
	{
		this.idEmpire = idEmpire;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser( User user )
	{
		this.user = user;
	}
	
	public EmpireStatus getEmpireStatus()
	{
		return empireStatus;
	}
	
	public void setEmpireStatus( EmpireStatus empireStatus )
	{
		this.empireStatus = empireStatus;
	}
	
	public List< EmpirePieces > getEmpirePieces()
	{
		return empirePieces;
	}
	
	public void setEmpirePieces( List< EmpirePieces > empirePieces )
	{
		this.empirePieces = empirePieces;
	}
	
	public List< GameEmpire > getGameEmpires()
	{
		return gameEmpires;
	}
	
	public void setGameEmpires( List< GameEmpire > gameEmpires )
	{
		this.gameEmpires = gameEmpires;
	}
}