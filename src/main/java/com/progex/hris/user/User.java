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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.progex.hris.user.authorization.Role;

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

	@ManyToOne
	private Role role;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_designation_history")
	private Set<Designation> designation;

	@NotNull
	@ElementCollection
	@CollectionTable(name = "Contact")
	private Set<ContactNumber> contacts;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "user")
	private Set<UserDepartment> userDepartment;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

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

	public User(long id, String userName, String password, String firstName, String lastName, String nic,
			String address, String email, Long supervisorId, Date dob, Boolean active, Role role,
			Set<Designation> designation, Set<ContactNumber> contacts, Set<UserDepartment> userDepartment) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.address = address;
		this.email = email;
		this.supervisorId = supervisorId;
		this.dob = dob;
		this.active = active;
		this.role = role;
		this.designation = designation;
		this.contacts = contacts;
		this.userDepartment = userDepartment;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nic=" + nic + ", address=" + address + ", email=" + email
				+ ", supervisorId=" + supervisorId + ", dob=" + dob + ", active=" + active + ", role=" + role
				+ ", designation=" + designation + ", contacts=" + contacts + ", userDepartment=" + userDepartment
				+ "]";
	}

}
