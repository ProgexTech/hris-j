package com.progex.hris.workDay;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WorkDay")
public class WorkDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String code;
	
	private String description;
	
	@NotNull
	@ManyToOne
	private WorkDayCategory workDayCategory;

	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	WorkDay() {
		
	}

	public WorkDay(long id, String code, String description, WorkDayCategory workDayCategory, Date startTime, Date endTime) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.workDayCategory = workDayCategory;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkDayCategory getWorkDayCategory() {
		return workDayCategory;
	}

	public void setWorkDayCategory(WorkDayCategory workDayCategory) {
		this.workDayCategory = workDayCategory;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
