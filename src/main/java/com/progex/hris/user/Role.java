package com.progex.hris.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {

	enum Type {
		ADMIN,
		MANAGER,
		USER
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(unique=true)
	private Type type;
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}


	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", type=" + type + "]";
	}

	public void setType(Type type) {
		this.type = type;
	}
}
