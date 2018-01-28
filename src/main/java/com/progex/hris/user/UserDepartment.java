package com.progex.hris.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.progex.hris.organization.Department;

@Entity
@Table(name="user_department",
uniqueConstraints=
@UniqueConstraint(columnNames={"user_id", "department_id"}))
public class UserDepartment{
	
	@EmbeddedId
	private UserDepartmentId userDepartmentId;
		
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date assignedDate;
	
	@Temporal(TemporalType.DATE)
	private Date unAssignedDate;
	
	@ManyToOne
	@MapsId("user_id")
	private User user;
	
	@ManyToOne
	@MapsId("department_id")
	private Department department;
	
	public UserDepartment(UserDepartmentId userDepartmentId, Date assignedDate, Date unAssignedDate, User user,
			Department department) {
		super();
		this.userDepartmentId = userDepartmentId;
		this.assignedDate = assignedDate;
		this.unAssignedDate = unAssignedDate;
		this.user = user;
		this.department = department;
	}

	public UserDepartment() {
		super();
	}

	public UserDepartmentId getUserDepartmentId() {
		return userDepartmentId;
	}

	public void setUserDepartmentId(UserDepartmentId id) {
		this.userDepartmentId = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date joinedDate) {
		this.assignedDate = joinedDate;
	}

	public Date getUnAssignedDate() {
		return unAssignedDate;
	}

	public void setUnAssignedDate(Date unAssignedDate) {
		this.unAssignedDate = unAssignedDate;
	}

	@Override
	public String toString() {
		return "UserDepartment [userDepartmentId=" + userDepartmentId + ", assignedDate=" + assignedDate
				+ ", unAssignedDate=" + unAssignedDate +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedDate == null) ? 0 : assignedDate.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((unAssignedDate == null) ? 0 : unAssignedDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userDepartmentId == null) ? 0 : userDepartmentId.hashCode());
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
		UserDepartment other = (UserDepartment) obj;
		if (assignedDate == null) {
			if (other.assignedDate != null)
				return false;
		} else if (!assignedDate.equals(other.assignedDate))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (unAssignedDate == null) {
			if (other.unAssignedDate != null)
				return false;
		} else if (!unAssignedDate.equals(other.unAssignedDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userDepartmentId == null) {
			if (other.userDepartmentId != null)
				return false;
		} else if (!userDepartmentId.equals(other.userDepartmentId))
			return false;
		return true;
	}

}
