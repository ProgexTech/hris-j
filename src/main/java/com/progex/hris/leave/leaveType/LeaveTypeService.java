package com.progex.hris.leave.leaveType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveTypeService {
	
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;

	public List<LeaveType> getAllLeaveTypes() {
		List<LeaveType> leaveTypeList = new ArrayList<>();
		leaveTypeRepository.findAll().forEach(leaveTypeList::add);
		return leaveTypeList;
	}
	
	public LeaveType getLeaveType(String code) {
		return leaveTypeRepository.findOne(code);
	}
	
	public void addLeaveType(LeaveType leaveType) {
		leaveTypeRepository.save(leaveType);
	}
	
}
