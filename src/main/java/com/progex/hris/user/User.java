package com.progex.hris.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Role role;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String nic;
	private String address;
	private String email;
	private Date dob;
	
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
	
	public User(long id, String name){
		super();
		this.firstName = name;
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", nic=" + nic + ", address=" + address
				+ ", email=" + email + ", dob=" + dob + "]";
	}

}
