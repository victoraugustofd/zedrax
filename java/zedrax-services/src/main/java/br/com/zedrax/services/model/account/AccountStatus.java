package br.com.zedrax.services.model.account;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
	private Long id;
	
	@Column( name = "\"status\"", nullable = false )
	@Length( max = 50 )
	private String status;
	
	@OneToMany( mappedBy = "accountStatus", targetEntity = Account.class )
	private List< Account > accounts;
	
	public AccountStatus() {}
	
	public AccountStatus( String status )
	{
		setStatus( status );
	}

	public Long getId()
	{
		return id;
	}
	
	public void setId( Long id )
	{
		this.id = id;
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
	
	@Override
	public boolean equals( Object obj )
	{
		boolean equals = false;
		
		if ( obj != this )
		{
			if ( obj instanceof AccountStatus )
			{
				AccountStatus accountStatus = ( AccountStatus ) obj;
				
				if ( Objects.equals( status, accountStatus.getStatus() ) )
					equals = true;
			}
		}
		
		return equals;
	}
}