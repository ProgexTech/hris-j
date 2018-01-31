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
	
	public LeaveStatus addLeaveStatus(LeaveStatus leaveStatus) {
		return leaveStatusRepository.save(leaveStatus);
	}
	
	public LeaveStatus updateLeaveStatus(String code, LeaveStatus leaveStatus) {
		return leaveStatusRepository.save(leaveStatus);
	}
	
	public LeaveStatus patchLeaveStatus(String code, LeaveStatus leaveStatus) {
		LeaveStatus existingLeaveStatus = leaveStatusRepository.findOne(code);
		if (leaveStatus.getCode() != null) {
			existingLeaveStatus.setCode(leaveStatus.getCode());
		}
		if (leaveStatus.getName() != null) {
			existingLeaveStatus.setCode(leaveStatus.getName());
		}
		if (leaveStatus.getDescription() != null) {
			existingLeaveStatus.setCode(leaveStatus.getDescription());
		}
		return leaveStatusRepository.save(existingLeaveStatus);
	}
	
}
