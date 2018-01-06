package com.progex.hris.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Designation")
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	private String title;
	private Date fromDate;
	private Date toDate;
	private boolean fullTime;
	private String description;
	
	@ManyToMany(mappedBy = "designation")
	private Set<User> user;
	
	public Designation() {
		
	}

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

	@JsonIgnore
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", title=" + title + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", fullTime=" + fullTime + ", description=" + description + ", user=" + user + "]";
	}

	
}
