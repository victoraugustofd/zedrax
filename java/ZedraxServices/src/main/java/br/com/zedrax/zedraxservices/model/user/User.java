package br.com.zedrax.zedraxservices.model.user;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.account.Account;
import br.com.zedrax.zedraxservices.model.empire.Empire;

/**
 * The persistent class for the "user" database table.
 * 
 */
@Entity
@Table( name = "\"user\"" )
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_user\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idUser;
	
	@Column( name = "\"is_cpu\"", nullable = false )
	private Boolean isCpu;
	
	@Column( name = "\"name\"", nullable = false )
	@Length( max = 100 )
	private String name;
	
	@Column( name = "\"xp\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal xp;
	
	@OneToOne
	@JoinColumn( name = "\"id_account\"", nullable = false )
	private Account account;
	
	@ManyToOne( targetEntity = UserLevel.class )
	@JoinColumn( name = "\"id_user_level\"", nullable = false )
	private UserLevel userLevel;
	
	@ManyToOne( targetEntity = UserStatus.class )
	@JoinColumn( name = "\"id_user_status\"", nullable = false )
	private UserStatus userStatus;
	
	@OneToMany( mappedBy = "user", targetEntity = UserLogin.class )
	private List< UserLogin > userLogins;
	
	@OneToMany( mappedBy = "user", targetEntity = Empire.class )
	private List< Empire > empires;
	
	public User() {}
	
	public Long getIdUser()
	{
		return this.idUser;
	}
	
	public void setIdUser( Long idUser )
	{
		this.idUser = idUser;
	}
	
	public Boolean getIsCpu()
	{
		return this.isCpu;
	}
	
	public void setIsCpu( Boolean isCpu )
	{
		this.isCpu = isCpu;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public BigDecimal getXp()
	{
		return this.xp;
	}
	
	public void setXp( BigDecimal xp )
	{
		this.xp = xp;
	}
	
	public List< Empire > getEmpires()
	{
		return this.empires;
	}
	
	public void setEmpires( List< Empire > empires )
	{
		this.empires = empires;
	}
	
	public Empire addEmpire( Empire empire )
	{
		getEmpires().add( empire );
		empire.setUser( this );
		
		return empire;
	}
	
	public Empire removeEmpire( Empire empire )
	{
		getEmpires().remove( empire );
		empire.setUser( null );
		
		return empire;
	}
	
	public Account getAccount()
	{
		return this.account;
	}
	
	public void setAccount( Account account )
	{
		this.account = account;
	}
	
	public UserLevel getUserLevel()
	{
		return this.userLevel;
	}
	
	public void setUserLevel( UserLevel userLevel )
	{
		this.userLevel = userLevel;
	}
	
	public UserStatus getUserStatus()
	{
		return this.userStatus;
	}
	
	public void setUserStatus( UserStatus userStatus )
	{
		this.userStatus = userStatus;
	}
	
	public List< UserLogin > getUserLogins()
	{
		return this.userLogins;
	}
	
	public void setUserLogins( List< UserLogin > userLogins )
	{
		this.userLogins = userLogins;
	}
	
	public UserLogin addUserLogin( UserLogin userLogin )
	{
		getUserLogins().add( userLogin );
		userLogin.setUser( this );
		
		return userLogin;
	}
	
	public UserLogin removeUserLogin( UserLogin userLogin )
	{
		getUserLogins().remove( userLogin );
		userLogin.setUser( null );
		
		return userLogin;
	}
}