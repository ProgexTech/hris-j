package com.progex.hris.user.authorization;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Permission")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;
	
	@NotNull
	private String permString;
	
	@ManyToMany(mappedBy="permission")
	private Set<Role> role;
	
	public Permission() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getPermString() {
		return permString;
	}

	public void setPermString(String permString) {
		this.permString = permString;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permString=" + permString + ", role=" + role + "]";
	}

}
