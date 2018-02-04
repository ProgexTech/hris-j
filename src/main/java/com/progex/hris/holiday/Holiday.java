package com.progex.hris.holiday;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Holiday")
public class Holiday {
	
	@Id
	private Date date;
	
	@NotNull
	private Date createdDate;
	
	@NotNull
	private int year;
	
	@NotNull
	private int month;
	
	public Holiday() {
		
	}

	public Holiday(Date date, Date createdDate, short year, short month) {
		super();
		this.date = date;
		this.createdDate = createdDate;
		this.year = year;
		this.month = month;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
}
