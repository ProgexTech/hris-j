package com.progex.hris.user;

import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String nic;
	private String address;
	private String email;
	private Date dob;
	private Boolean active;

	@ManyToOne
	private Role role;

	@ElementCollection
	@CollectionTable(name = "Designation")
	private List<Designation> designations;

	@ElementCollection
	@CollectionTable(name = "Contact")
	private List<ContactNumber> contacts;

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
			String address, String email, Date dob, Boolean active, Role role, List<Designation> designations,
			List<ContactNumber> contacts) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.address = address;
		this.email = email;
		this.dob = dob;
		this.active = active;
		this.role = role;
		this.designations = designations;
		this.contacts = contacts;
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

	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
	}

	public List<Designation> getDesignations() {
		return designations;
	}

	public List<ContactNumber> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactNumber> contacts) {
		this.contacts = contacts;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nic=" + nic + ", address=" + address + ", email=" + email + ", dob="
				+ dob + ", active=" + active + ", role=" + role + ", designations=" + designations + ", contacts="
				+ contacts + "]";
	}

}
