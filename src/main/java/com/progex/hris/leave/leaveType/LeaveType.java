package com.progex.hris.leave.leaveType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LeaveType")
public class LeaveType {
	
	@Id
	private String code;
	private String name;
	private String description;
	
	public LeaveType() {
		
	}
	
	public LeaveType(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
