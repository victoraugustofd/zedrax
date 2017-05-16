package br.com.zedrax.zedraxservices.model.account;

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
 * The persistent class for the "piece_turn_status" database table.
 * 
 */
@Entity
@Table( name = "\"account_status\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"status\"" ) )
public class AccountStatus implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_account_status\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idAccountStatus;
	
	@Column( name = "\"status\"", nullable = false )
	@Length( max = 50 )
	private String status;
	
	@OneToMany( mappedBy = "accountStatus", targetEntity = Account.class )
	private List< Account > accounts;
	
	public AccountStatus() {}
	
	public Long getIdAccountStatus()
	{
		return idAccountStatus;
	}
	
	public void setIdAccountStatus( Long idAccountStatus )
	{
		this.idAccountStatus = idAccountStatus;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus( String status )
	{
		this.status = status;
	}
	
	public List< Account > getAccounts()
	{
		return accounts;
	}
	
	public void setAccounts( List< Account > accounts )
	{
		this.accounts = accounts;
	}
}