package com.progex.hris.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Designation")
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	
	private String title;
	
	private String description;
			
	public Designation() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
}
