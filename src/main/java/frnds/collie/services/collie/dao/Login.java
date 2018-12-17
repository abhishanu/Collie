package frnds.collie.services.collie.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import frnds.collie.services.collie.utilities.AuditFields;

@Entity
@Table(name = "ri_login_details")
public class Login extends AuditFields<String> {
	@Id
	private String userId;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	private String pass;

	@Column(name = "LOGIN_TYPE_ID")
	private String loginTypeId;

	private String isActive;

	private String accessKey;

	@Column(name = "PASS_HISTORY", columnDefinition = "TEXT")
	private String passwordHistory;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLoginTypeId() {
		return loginTypeId;
	}

	public void setLoginTypeId(String loginTypeId) {
		this.loginTypeId = loginTypeId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getPasswordHistory() {
		return passwordHistory;
	}

	public void setPasswordHistory(String passwordHistory) {
		this.passwordHistory = passwordHistory;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
