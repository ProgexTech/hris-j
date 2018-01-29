package com.progex.hris.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.progex.hris.authorization.Role;

@Entity
@Table(name="user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Role role;

	public UserRole(Short id, User user, Role role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	public UserRole() {
		super();
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
}
