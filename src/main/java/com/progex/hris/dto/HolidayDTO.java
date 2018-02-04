package com.progex.hris.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class HolidayDTO {
	
	@Id
	private long id;
	
	@NotNull
	private Date date;
	
	public HolidayDTO() {
		
	}

	public HolidayDTO(long id, Date date) {
		super();
		this.id = id;
		this.date = date;
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
	
}
