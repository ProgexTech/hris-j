package com.progex.hris.user;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Embeddable @Access(AccessType.FIELD)
@Table (name="Contact")
public class ContactNumber {

	@Enumerated(value=EnumType.STRING)
	private PhoneType type;
	private String number;
	
	public ContactNumber() {
		
	}
	
	public ContactNumber(PhoneType type, String number) {
		super();
		this.type = type;
		this.number = number;
	}
	
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "ContactNumber [type=" + type + ", number=" + number + "]";
	}
	
}
