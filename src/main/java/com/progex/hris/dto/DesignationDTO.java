package com.progex.hris.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class DesignationDTO {

	@Id
	private Short id;
	
	@NotNull
	private String title;
	
	@NotNull
	private Date appointedDate;
	
	private boolean fullTime;
	
	private String description;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getAppointedDate() {
		return appointedDate;
	}

	public void setAppointedDate(Date appointedDate) {
		this.appointedDate = appointedDate;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
