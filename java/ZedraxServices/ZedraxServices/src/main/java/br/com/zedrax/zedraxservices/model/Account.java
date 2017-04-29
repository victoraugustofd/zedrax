package br.com.zedrax.zedraxservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "account" database table.
 * 
 */
@Entity
@Table(name="\"account\"")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="\"dt_register\"")
	private Date dtRegister;

	@Column(name="\"email\"")
	private String email;

	@Column(name="\"email_info_flag\"")
	private Boolean emailInfoFlag;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"id_account\"", insertable=false, updatable=false)
	private Integer idAccount;

	@Column(name="\"name\"")
	private String name;

	@Column(name="\"password\"")
	private String password;

	//bi-directional many-to-one association to AccountSettings
	@OneToMany(mappedBy="account")
	private List<AccountSettings> accountSettings;

	public Account() {
	}

	public Date getDtRegister() {
		return this.dtRegister;
	}

	public void setDtRegister(Date dtRegister) {
		this.dtRegister = dtRegister;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailInfoFlag() {
		return this.emailInfoFlag;
	}

	public void setEmailInfoFlag(Boolean emailInfoFlag) {
		this.emailInfoFlag = emailInfoFlag;
	}

	public Integer getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountSettings> getAccountSettings() {
		return this.accountSettings;
	}

	public void setAccountSettings(List<AccountSettings> accountSettings) {
		this.accountSettings = accountSettings;
	}

	public AccountSettings addAccountSetting(AccountSettings accountSetting) {
		getAccountSettings().add(accountSetting);
		accountSetting.setAccount(this);

		return accountSetting;
	}

	public AccountSettings removeAccountSetting(AccountSettings accountSetting) {
		getAccountSettings().remove(accountSetting);
		accountSetting.setAccount(null);

		return accountSetting;
	}

}