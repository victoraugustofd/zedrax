package br.com.zedrax.services.model.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.services.model.settings.SettingsAttributes;

/**
 * The persistent class for the "account_settings" database table.
 * 
 */
@Entity
@Table( name = "\"account_settings\"" )
public class AccountSettings implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_account_settings\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idAccountSettings;
	
	@Column( name = "\"attribute_value\"", nullable = false )
	@Length( max = 45 )
	private String attributeValue;
	
	@ManyToOne( targetEntity = Account.class )
	@JoinColumn( name = "\"id_account\"", nullable = false )
	private Account account;
	
	@ManyToOne( targetEntity = SettingsAttributes.class )
	@JoinColumn( name = "\"id_settings_attributes\"", nullable = false )
	private SettingsAttributes settingsAttributes;
	
	public AccountSettings() {}
	
	public AccountSettings( Account account, SettingsAttributes settingsAttribute, String attributeValue )
	{
		setAccount( account );
		setSettingsAttributes( settingsAttribute );
		setAttributeValue( attributeValue );
	}
	
	public Long getIdAccountSettings()
	{
		return idAccountSettings;
	}
	
	public void setIdAccountSettings( Long idAccountSettings )
	{
		this.idAccountSettings = idAccountSettings;
	}
	
	public String getAttributeValue()
	{
		return attributeValue;
	}
	
	public void setAttributeValue( String attributeValue )
	{
		this.attributeValue = attributeValue;
	}
	
	public Account getAccount()
	{
		return account;
	}
	
	public void setAccount( Account account )
	{
		this.account = account;
	}
	
	public SettingsAttributes getSettingsAttributes()
	{
		return settingsAttributes;
	}
	
	public void setSettingsAttributes( SettingsAttributes settingsAttributes )
	{
		this.settingsAttributes = settingsAttributes;
	}
}