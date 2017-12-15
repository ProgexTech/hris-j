package com.progex.hris.user.authorization;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;

	@NotNull
	@Column(unique = true)
	private String type;

	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name = "role_permission")
	private Set<Permission> permission;

	public Role() {

	}

	public Role(String type) {
		super();
		this.type = type;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermissions(Set<Permission> permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", type=" + type + ", permission=" + permission + "]";
	}

}
