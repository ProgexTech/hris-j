package com.progex.hris.dto;

import java.util.Date;

public class UserDepartmentDTO {

	private Long userId;
	
	private Short departmentId;
	
	private Date assignedDate;

	private Date unAssignedDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Short departmentId) {
		this.departmentId = departmentId;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getUnAssignedDate() {
		return unAssignedDate;
	}

	public void setUnAssignedDate(Date unAssignedDate) {
		this.unAssignedDate = unAssignedDate;
	}

	@Override
	public String toString() {
		return "UserDepartmentDTO [userId=" + userId + ", departmentId=" + departmentId + ", assignedDate="
				+ assignedDate + ", unAssignedDate=" + unAssignedDate + "]";
	}
}
