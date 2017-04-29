package br.com.zedrax.zedraxservices.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the "account_settings" database table.
 * 
 */
@Entity
@Table(name="\"account_settings\"")
@NamedQuery(name="AccountSettings.findAll", query="SELECT a FROM AccountSettings a")
public class AccountSettings implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"attribute_value\"")
	private String attributeValue;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"id_account_settings\"", insertable=false, updatable=false)
	private Integer idAccountSettings;

	@Column(name="\"id_settings_attributes\"")
	private Integer idSettingsAttributes;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	//bi-directional many-to-one association to SettingsAttributes
	@OneToMany(mappedBy="accountSettings")
	private List<SettingsAttributes> settingsAttributes;

	public AccountSettings() {
	}

	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Integer getIdAccountSettings() {
		return this.idAccountSettings;
	}

	public void setIdAccountSettings(Integer idAccountSettings) {
		this.idAccountSettings = idAccountSettings;
	}

	public Integer getIdSettingsAttributes() {
		return this.idSettingsAttributes;
	}

	public void setIdSettingsAttributes(Integer idSettingsAttributes) {
		this.idSettingsAttributes = idSettingsAttributes;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<SettingsAttributes> getSettingsAttributes() {
		return this.settingsAttributes;
	}

	public void setSettingsAttributes(List<SettingsAttributes> settingsAttributes) {
		this.settingsAttributes = settingsAttributes;
	}

	public SettingsAttributes addSettingsAttribute(SettingsAttributes settingsAttribute) {
		getSettingsAttributes().add(settingsAttribute);
		settingsAttribute.setAccountSettings(this);

		return settingsAttribute;
	}

	public SettingsAttributes removeSettingsAttribute(SettingsAttributes settingsAttribute) {
		getSettingsAttributes().remove(settingsAttribute);
		settingsAttribute.setAccountSettings(null);

		return settingsAttribute;
	}

}