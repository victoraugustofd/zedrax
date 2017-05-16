package br.com.zedrax.zedraxservices.model.settings;

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
 * The persistent class for the "settings_group" database table.
 * 
 */
@Entity
@Table( name = "\"settings_group\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"group\"" ) )
public class SettingsGroup implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_settings_group\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idSettingsGroup;
	
	@Column( name = "\"group\"", nullable = false )
	@Length( max = 45 )
	private String group;
	
	@OneToMany( mappedBy = "settingsGroup", targetEntity = SettingsAttributes.class)
	private List< SettingsAttributes > settingsAttributes;
	
	public SettingsGroup() {}
	
	public Long getIdSettingsGroup()
	{
		return idSettingsGroup;
	}
	
	public void setIdSettingsGroup( Long idSettingsGroup )
	{
		this.idSettingsGroup = idSettingsGroup;
	}
	
	public String getGroup()
	{
		return group;
	}
	
	public void setGroup( String group )
	{
		this.group = group;
	}
	
	public List< SettingsAttributes > getSettingsAttributes()
	{
		return settingsAttributes;
	}
	
	public void setSettingsAttributes( List< SettingsAttributes > settingsAttributes )
	{
		this.settingsAttributes = settingsAttributes;
	}
}