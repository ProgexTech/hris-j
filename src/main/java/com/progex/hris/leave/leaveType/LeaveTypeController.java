package com.progex.hris.leave.leaveType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LeaveTypeController {
	
	@Autowired
	private LeaveTypeService leaveService;

	@RequestMapping("/leaveTypes")
	public List<LeaveType> getAllLeaveTypes() {
		return leaveService.getAllLeaveTypes();
	}
	
	@RequestMapping("/leaveTypes/{code}")
	public LeaveType getLeaveType(@PathVariable String code) {
		return leaveService.getLeaveType(code);
	}
}
