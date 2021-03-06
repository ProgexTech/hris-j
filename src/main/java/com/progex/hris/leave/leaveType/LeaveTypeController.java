package com.progex.hris.leave.leaveType;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LeaveTypeController {
	
	@Autowired
	private LeaveTypeService leaveTypeService;
	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);
	
	@PostMapping("/leaveTypes")
	public ResponseEntity<LeaveType> addPermission(@RequestBody LeaveType leaveType) {
		if (logger.isInfoEnabled())
			logger.info("LeaveType to save " + leaveType);
		return new ResponseEntity<LeaveType>(leaveTypeService.addLeaveType(leaveType), HttpStatus.OK);
	}

	@RequestMapping("/leaveTypes")
	public ResponseEntity<List<LeaveType>> getAllLeaveTypes() {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveTypeController::getAllLeaveTypes() called");
		}
		List<LeaveType> leaveTypeList = leaveTypeService.getAllLeaveTypes();
		if (leaveTypeList.isEmpty()) {
			if (logger.isInfoEnabled()) {
				logger.info("LeaveTypeController::getAllLeaveTypes() empty result returned");
			}
			
			return new ResponseEntity<List<LeaveType>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled()) {
			logger.info("LeaveTypeController::getAllLeaveTypes() non-empty result returned");
		}
		
		return new ResponseEntity<List<LeaveType>>(leaveTypeList, HttpStatus.OK);
	}
	
	@RequestMapping("/leaveTypes/{code}")
	public ResponseEntity<LeaveType> getLeaveType(@PathVariable String code) {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveTypeController::getLeaveType() called");
		}
		LeaveType leaveType = leaveTypeService.getLeaveType(code);
		if (leaveType == null) {
			if (logger.isInfoEnabled()) {
				logger.info("LeaveTypeController::getLeaveType() null result returned");
			}
			
			return new ResponseEntity<LeaveType>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled()) {
			logger.info("LeaveTypeController::getLeaveType() non-null result returned");
		}
		
		return new ResponseEntity<LeaveType>(leaveType, HttpStatus.OK);
	}
}
