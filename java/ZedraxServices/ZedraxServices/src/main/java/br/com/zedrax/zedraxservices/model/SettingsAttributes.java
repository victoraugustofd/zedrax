package br.com.zedrax.zedraxservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "settings_attributes" database table.
 * 
 */
@Entity
@Table(name="\"settings_attributes\"")
@NamedQuery(name="SettingsAttributes.findAll", query="SELECT s FROM SettingsAttributes s")
public class SettingsAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"id_settings_attributes\"", insertable=false, updatable=false)
	private Integer idSettingsAttributes;

	@Column(name="\"id_settings_group\"")
	private Integer idSettingsGroup;

	@Column(name="\"settings_attribute_name\"")
	private String settingsAttributeName;

	//bi-directional many-to-one association to AccountSettings
	@ManyToOne
	@JoinColumns({
		})
	private AccountSettings accountSettings;

	//bi-directional many-to-one association to SettingsGroup
	@OneToMany(mappedBy="settingsAttributes")
	private List<SettingsGroup> settingsGroups;

	public SettingsAttributes() {
	}

	public Integer getIdSettingsAttributes() {
		return this.idSettingsAttributes;
	}

	public void setIdSettingsAttributes(Integer idSettingsAttributes) {
		this.idSettingsAttributes = idSettingsAttributes;
	}

	public Integer getIdSettingsGroup() {
		return this.idSettingsGroup;
	}

	public void setIdSettingsGroup(Integer idSettingsGroup) {
		this.idSettingsGroup = idSettingsGroup;
	}

	public String getSettingsAttributeName() {
		return this.settingsAttributeName;
	}

	public void setSettingsAttributeName(String settingsAttributeName) {
		this.settingsAttributeName = settingsAttributeName;
	}

	public AccountSettings getAccountSettings() {
		return this.accountSettings;
	}

	public void setAccountSettings(AccountSettings accountSettings) {
		this.accountSettings = accountSettings;
	}

	public List<SettingsGroup> getSettingsGroups() {
		return this.settingsGroups;
	}

	public void setSettingsGroups(List<SettingsGroup> settingsGroups) {
		this.settingsGroups = settingsGroups;
	}

	public SettingsGroup addSettingsGroup(SettingsGroup settingsGroup) {
		getSettingsGroups().add(settingsGroup);
		settingsGroup.setSettingsAttributes(this);

		return settingsGroup;
	}

	public SettingsGroup removeSettingsGroup(SettingsGroup settingsGroup) {
		getSettingsGroups().remove(settingsGroup);
		settingsGroup.setSettingsAttributes(null);

		return settingsGroup;
	}

}