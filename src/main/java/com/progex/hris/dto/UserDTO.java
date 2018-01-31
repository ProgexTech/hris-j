package com.progex.hris.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import com.progex.hris.user.ContactNumber;

public class UserDTO {

	@Id
	private long id;

	@NotNull
	private String userName;

	@NotNull
	private String password;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private String nic;

	@NotNull
	private String address;

	private String email;

	@NotNull
	private Date dob;

	@NotNull
	private Boolean active;

	@NotNull
	private Set<ContactNumber> contacts;

	private Long supervisorId;

	private Short roleId;

	@NotNull
	private Short designationId;
	
	@NotNull
	private Short departmentId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<ContactNumber> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactNumber> contacts) {
		this.contacts = contacts;
	}

	public Long getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public Short getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Short designationId) {
		this.designationId = designationId;
	}

	public Short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Short departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nic=" + nic + ", address=" + address + ", email=" + email + ", dob="
				+ dob + ", active=" + active + ", contacts=" + contacts + ", supervisorId=" + supervisorId + ", roleId="
				+ roleId + ", designationId=" + designationId + ", departmentId=" + departmentId + "]";
	}	
}
