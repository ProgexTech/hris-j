package com.progex.hris.workDay;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WorkDayCategory")
public class WorkDayCategory {
	
	@Id
	private String name;
	
	public WorkDayCategory() {
		
	}
	
	public WorkDayCategory(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
