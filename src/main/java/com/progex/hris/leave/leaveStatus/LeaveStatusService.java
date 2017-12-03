package com.progex.hris.leave.leaveStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveStatusService {
	
	@Autowired
	private LeaveStatusRepository leaveStatusRepository;
	
	public List<LeaveStatus> getAllLeaveStatus() {
		List<LeaveStatus> leaveStatusList = new ArrayList<>();
		leaveStatusRepository.findAll().forEach(leaveStatusList::add);
		return leaveStatusList;
	}
	
	public LeaveStatus getLeaveStatus(String code) {
		return leaveStatusRepository.findOne(code);
	}
	
	public void addLeaveStatus(LeaveStatus leaveStatus) {
		leaveStatusRepository.save(leaveStatus);
	}
}
