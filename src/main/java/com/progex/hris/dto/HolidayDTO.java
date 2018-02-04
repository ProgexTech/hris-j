package com.progex.hris.dto;

import java.util.Date;

import javax.persistence.Id;

public class HolidayDTO {
	
	@Id
	private Date date;
	
	public HolidayDTO() {
		
	}

	public HolidayDTO(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
