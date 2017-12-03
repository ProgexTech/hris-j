package com.progex.hris.leave.leaveStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LeaveStatusController {

	@Autowired
	private LeaveStatusService leaveStatusService;

	@RequestMapping("/leaveStatus")
	public List<LeaveStatus> getAllLeaveTypes() {
		return leaveStatusService.getAllLeaveStatus();
	}
	
	@RequestMapping("/leaveStatus/{code}")
	public LeaveStatus getLeaveType(@PathVariable String code) {
		return leaveStatusService.getLeaveStatus(code);
	}
}
