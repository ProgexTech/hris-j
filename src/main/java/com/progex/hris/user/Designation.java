package com.progex.hris.user;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Access(AccessType.FIELD)
@Table(name = "Designation")
public class Designation {

	private String title;
	private Date fromDate;
	private Date toDate;
	private boolean fullTime;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public boolean getFullTime() {
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

	@Override
	public String toString() {
		return "Designation [title=" + title + ", fromDate=" + fromDate + ", toDate=" + toDate + ", fullTime="
				+ fullTime + ", description=" + description + "]";
	}

}
