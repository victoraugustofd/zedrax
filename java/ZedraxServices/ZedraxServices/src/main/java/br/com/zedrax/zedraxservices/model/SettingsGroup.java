package br.com.zedrax.zedraxservices.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "settings_group" database table.
 * 
 */
@Entity
@Table(name="\"settings_group\"")
@NamedQuery(name="SettingsGroup.findAll", query="SELECT s FROM SettingsGroup s")
public class SettingsGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"id_settings_group\"", insertable=false, updatable=false)
	private Integer idSettingsGroup;

	@Column(name="\"settings_group_name\"")
	private String settingsGroupName;

	//bi-directional many-to-one association to SettingsAttributes
	@ManyToOne
	@JoinColumns({
		})
	private SettingsAttributes settingsAttributes;

	public SettingsGroup() {
	}

	public Integer getIdSettingsGroup() {
		return this.idSettingsGroup;
	}

	public void setIdSettingsGroup(Integer idSettingsGroup) {
		this.idSettingsGroup = idSettingsGroup;
	}

	public String getSettingsGroupName() {
		return this.settingsGroupName;
	}

	public void setSettingsGroupName(String settingsGroupName) {
		this.settingsGroupName = settingsGroupName;
	}

	public SettingsAttributes getSettingsAttributes() {
		return this.settingsAttributes;
	}

	public void setSettingsAttributes(SettingsAttributes settingsAttributes) {
		this.settingsAttributes = settingsAttributes;
	}

}