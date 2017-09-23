package br.com.zedrax.services.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the "user_login" database table.
 * 
 */
@Entity
@Table( name = "\"user_login\"" )
public class UserLogin implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_user_login\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idUserLogin;
	
	@Temporal( TemporalType.DATE )
	@Column( name = "\"dt_login\"", nullable = false )
	private Date dtLogin;
	
	@Temporal( TemporalType.DATE )
	@Column( name = "\"dt_logout\"", nullable = false )
	private Date dtLogout;
	
	@ManyToOne( targetEntity = User.class )
	@JoinColumn( name = "\"id_user\"", nullable = false )
	private User user;
	
	public UserLogin() {}
	
	public Date getDtLogin()
	{
		return this.dtLogin;
	}
	
	public void setDtLogin( Date dtLogin )
	{
		this.dtLogin = dtLogin;
	}
	
	public Date getDtLogout()
	{
		return this.dtLogout;
	}
	
	public void setDtLogout( Date dtLogout )
	{
		this.dtLogout = dtLogout;
	}
	
	public Long getIdUserLogin()
	{
		return this.idUserLogin;
	}
	
	public void setIdUserLogin( Long idUserLogin )
	{
		this.idUserLogin = idUserLogin;
	}
	
	public User getUser()
	{
		return this.user;
	}
	
	public void setUser( User user )
	{
		this.user = user;
	}
}