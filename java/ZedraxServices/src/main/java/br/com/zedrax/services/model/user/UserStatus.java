package br.com.zedrax.services.model.user;

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

/**
 * The persistent class for the "user_status" database table.
 * 
 */
@Entity
@Table( name = "\"user_status\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"status\"" ) )
public class UserStatus implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_user_status\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idUserStatus;
	
	@Column( name = "\"status\"", nullable = false )
	@Length( max = 45 )
	private String status;
	
	@OneToMany( mappedBy = "userStatus", targetEntity = User.class )
	private List< User > user;
	
	public UserStatus() {}
	
	public Long getIdUserStatus()
	{
		return idUserStatus;
	}
	
	public void setIdUserStatus( Long idUserStatus )
	{
		this.idUserStatus = idUserStatus;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus( String status )
	{
		this.status = status;
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