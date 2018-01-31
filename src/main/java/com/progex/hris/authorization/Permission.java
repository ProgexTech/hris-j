package com.progex.hris.authorization;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Permission")
public class Permission {

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getPermString() {
		return permString;
	}

	public void setPermString(String permString) {
		this.permString = permString;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permString=" + permString + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;

	@NotNull
	@Column(unique=true)
	private String permString;
}
