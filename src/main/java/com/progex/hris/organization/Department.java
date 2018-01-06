package com.progex.hris.organization;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.progex.hris.user.UserDepartment;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;

	private String departmentName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private Set<UserDepartment> userDepartment;

	public Department() {
		super();
	}

	public Department(short id, String departmentName, Set<UserDepartment> userDepartment) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.userDepartment = userDepartment;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String deparmentName) {
		this.departmentName = deparmentName;
	}

	public Set<UserDepartment> getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(Set<UserDepartment> userDepartment) {
		this.userDepartment = userDepartment;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", userDepartment=" + userDepartment
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + id;
		result = prime * result + ((userDepartment == null) ? 0 : userDepartment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (id != other.id)
			return false;
		if (userDepartment == null) {
			if (other.userDepartment != null)
				return false;
		} else if (!userDepartment.equals(other.userDepartment))
			return false;
		return true;
	}

}
