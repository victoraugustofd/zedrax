package br.com.zedrax.services.model.settings;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.services.model.account.AccountSettings;

/**
 * The persistent class for the "settings_attributes" database table.
 * 
 */
@Entity
@Table( name = "\"settings_attributes\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"attribute\"" ) )
public class SettingsAttributes implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_settings_attributes\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idSettingsAttributes;
	
	@Column( name = "\"attribute\"", nullable = false )
	@Length( max = 45 )
	private String attribute;
	
	@Column( name = "\"default_value\"", nullable = false )
	@Length( max = 45 )
	private String defaultValue;
	
	@ManyToOne( targetEntity = SettingsGroup.class )
	@JoinColumn( name = "\"id_settings_group\"", nullable = false )
	private SettingsGroup settingsGroup;
	
	@OneToMany( mappedBy = "settingsAttributes", targetEntity = AccountSettings.class )
	private List< AccountSettings > accountSettings;
	
	public SettingsAttributes() {}
	
	public SettingsAttributes( String attribute, String defaultValue, SettingsGroup settingsGroup )
	{
		setAttribute( attribute );
		setDefaultValue( defaultValue );
		setSettingsGroup( settingsGroup );
	}
	
	public Long getIdSettingsAttributes()
	{
		return idSettingsAttributes;
	}
	
	public void setIdSettingsAttributes( Long idSettingsAttributes )
	{
		this.idSettingsAttributes = idSettingsAttributes;
	}
	
	public String getAttribute()
	{
		return attribute;
	}
	
	public void setAttribute( String attribute )
	{
		this.attribute = attribute;
	}
	
	public String getDefaultValue()
	{
		return defaultValue;
	}
	
	public void setDefaultValue( String defaultValue )
	{
		this.defaultValue = defaultValue;
	}
	
	public SettingsGroup getSettingsGroup()
	{
		return settingsGroup;
	}
	
	public void setSettingsGroup( SettingsGroup settingsGroup )
	{
		this.settingsGroup = settingsGroup;
	}
	
	public List< AccountSettings > getAccountSettings()
	{
		return accountSettings;
	}
	
	public void setAccountSettings( List< AccountSettings > accountSettings )
	{
		this.accountSettings = accountSettings;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		boolean equals = false;
		
		if ( obj != this )
		{
			if ( obj instanceof SettingsAttributes )
			{
				SettingsAttributes settingsAttributes = ( SettingsAttributes ) obj;
				
				if ( Objects.equals( attribute, settingsAttributes.getAttribute() ) )
					equals = true;
			}
		}
		
		return equals;
	}
}