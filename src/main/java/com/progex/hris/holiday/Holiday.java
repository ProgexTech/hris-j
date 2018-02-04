package com.progex.hris.holiday;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Holiday")
public class Holiday {
	
	@Id@
	GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private Date date;
	
	@NotNull
	private Date createdDate;
	
	@NotNull
	private int year;
	
	@NotNull
	private int month;
	
	public Holiday() {
		
	}

	public Holiday(long id, Date date, Date createdDate, short year, short month) {
		super();
		this.id = id;
		this.date = date;
		this.createdDate = createdDate;
		this.year = year;
		this.month = month;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
