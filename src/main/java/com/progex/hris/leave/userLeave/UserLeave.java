package com.progex.hris.leave.userLeave;

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

import com.progex.hris.leave.leaveStatus.LeaveStatus;
import com.progex.hris.leave.leaveType.LeaveType;
import com.progex.hris.user.User;

@Entity
@Table(name = "UserLeave")
public class UserLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@NotNull
	private User user;
	
	@ManyToOne
	@NotNull
	private LeaveType leaveType;
	
	@ManyToOne
	@NotNull
	private LeaveStatus leaveStatus;
	
	@NotNull
	private int durationInHours;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	UserLeave() {
		
	}	
		
	public UserLeave(long id, User user, LeaveType leaveType, LeaveStatus leaveStatus, int durationInHours,
			Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.user = user;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.durationInHours = durationInHours;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public LeaveType getLeaveType() {
		return leaveType;
	}
	
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	public int getDurationInHours() {
		return durationInHours;
	}
	
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
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

	@Override
	public String toString() {
		return "UserLeave [id=" + id + ", user=" + user + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus
				+ ", durationInHours=" + durationInHours + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
}
