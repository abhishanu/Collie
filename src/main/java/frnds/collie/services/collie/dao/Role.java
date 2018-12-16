package frnds.collie.services.collie.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import frnds.collie.services.collie.enums.RoleName;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;

	@Enumerated(EnumType.STRING)
	@Column(name = "role_name")
	private RoleName name;

	private String roleDesc;

	public Role() {

	}

	public Role(RoleName name) {
		this.name = name;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	public Integer getId() {
		return roleId;
	}

	public void setId(Integer id) {
		this.roleId = id;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}