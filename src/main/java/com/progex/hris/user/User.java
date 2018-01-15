package com.progex.hris.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String userName;

	@NotNull
	private String password;

	@NotNull
	private String firstName;

	private String lastName;

	private String nic;

	private String address;

	private String email;

	private Long supervisorId;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dob;

	@NotNull
	private Boolean active;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_designation_history")
	private Set<Designation> designation;

	@NotNull
	@ElementCollection
	@CollectionTable(name = "Contact")
	private Set<ContactNumber> contacts;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "user")
	private Set<UserDepartment> userDepartment;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pWord) {
		this.password = pWord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDesignation(Set<Designation> designation) {
		this.designation = designation;
	}

	public Set<Designation> getDesignation() {
		return designation;
	}

	public Set<ContactNumber> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactNumber> contacts) {
		this.contacts = contacts;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	public Set<UserDepartment> getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(Set<UserDepartment> department) {
		this.userDepartment = department;
	}
}
