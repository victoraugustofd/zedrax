package br.com.zedrax.services.model.account;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import br.com.zedrax.services.model.user.User;

/**
 * The persistent class for the "account" database table.
 * 
 */
@Entity
@Table( name = "\"account\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"email\"" ) )
public class Account implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_account\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idAccount;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "\"dt_register\"",
			 nullable = false,
			 insertable = false,
			 updatable = false,
			 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Calendar dtRegister;
	
	@Column( name = "\"email\"", nullable = false )
	@Length( max = 150 )
	@Email
	private String email;
	
	@Column( name = "\"email_info_flag\"", nullable = false )
	private Boolean emailInfoFlag;
	
	@Column( name = "\"name\"", nullable = false )
	@Length( max = 100 )
	private String name;
	
	@Column( name = "\"password\"", nullable = false )
	@Length( max = 150 )
	private String password;
	
	@ManyToOne( targetEntity = AccountStatus.class )
	@JoinColumn( name = "\"id_account_status\"", nullable = false )
	@ColumnDefault( value = "1" )
	private AccountStatus accountStatus;
	
	@OneToMany( mappedBy = "account", targetEntity = AccountSettings.class )
	private List< AccountSettings > accountSettings;
	
	@OneToOne( mappedBy = "account", targetEntity = User.class )
	private User user;
	
	public Account() {}
	
	public Account( String email, Boolean emailInfoFlag, String name, String password, AccountStatus accountStatus )
	{
		setEmail( email );
		setEmailInfoFlag( emailInfoFlag );
		setName( name );
		setPassword( password );
		setAccountStatus( accountStatus );
	}

	public Long getIdAccount()
	{
		return idAccount;
	}
	
	public void setIdAccount( Long idAccount )
	{
		this.idAccount = idAccount;
	}
	
	public Calendar getDtRegister()
	{
		return dtRegister;
	}
	
	public void setDtRegister( Calendar dtRegister )
	{
		this.dtRegister = dtRegister;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail( String email )
	{
		this.email = email;
	}
	
	public Boolean getEmailInfoFlag()
	{
		return emailInfoFlag;
	}
	
	public void setEmailInfoFlag( Boolean emailInfoFlag )
	{
		this.emailInfoFlag = emailInfoFlag;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword( String password )
	{
		this.password = password;
	}
	
	public AccountStatus getAccountStatus()
	{
		return accountStatus;
	}
	
	public void setAccountStatus( AccountStatus accountStatus )
	{
		this.accountStatus = accountStatus;
	}
	
	public List< AccountSettings > getAccountSettings()
	{
		return accountSettings;
	}
	
	public void setAccountSettings( List< AccountSettings > accountSettings )
	{
		this.accountSettings = accountSettings;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser( User user )
	{
		this.user = user;
	}
}