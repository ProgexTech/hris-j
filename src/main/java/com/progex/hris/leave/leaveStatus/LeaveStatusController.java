package com.progex.hris.leave.leaveStatus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LeaveStatusController {

	@Autowired
	private LeaveStatusService leaveStatusService;
	private static final Logger logger = LoggerFactory.getLogger(LeaveStatusController.class);

	@RequestMapping("/leaveStatus")
	public ResponseEntity<List<LeaveStatus>> getAllLeaveStatus() {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveStatusController::getAllLeaveStatus() called");
		}
		
		List<LeaveStatus> leaveStatusList = leaveStatusService.getAllLeaveStatus();
		if (leaveStatusList.isEmpty()) {
			if (logger.isInfoEnabled()) {
				logger.info("LeaveStatusController::getAllLeaveStatus() empty result returned");
			}
			
			return new ResponseEntity<List<LeaveStatus>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled()) {
			logger.info("LeaveStatusController::getAllLeaveStatus() non-empty result returned");
		}
		
		return new ResponseEntity<List<LeaveStatus>>(leaveStatusList, HttpStatus.OK);
	}
	
	@RequestMapping("/leaveStatus/{code}")
	public ResponseEntity<LeaveStatus> getLeaveStatus(@PathVariable String code) {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveStatusController::getLeaveStatus() called");
		}
		
		LeaveStatus leaveStatus = leaveStatusService.getLeaveStatus(code);
		if (leaveStatus == null) {
			if (logger.isInfoEnabled()) {
				logger.info("LeaveStatusController::getLeaveStatus() null result returned");
			}
			
			return new ResponseEntity<LeaveStatus>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled()) {
			logger.info("LeaveStatusController::getLeaveStatus() non-null result returned");
		}
		
		return new ResponseEntity<LeaveStatus>(leaveStatus, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/leaveStatus")
	public ResponseEntity<LeaveStatus> addLeaveStatus(@RequestBody LeaveStatus leaveStatus) {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveStatusController::addLeaveStatus() called");
		}
		
		LeaveStatus existingLeaveStatus = leaveStatusService.getLeaveStatus(leaveStatus.getCode());
		if (existingLeaveStatus != null) {
			if (logger.isErrorEnabled()) {
				logger.error("LeaveStatusController::addLeaveStatus() " + leaveStatus.getCode() + " already exists");
			}
			return new ResponseEntity<LeaveStatus>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<LeaveStatus>(leaveStatusService.addLeaveStatus(leaveStatus), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/leaveStatus/{code}")
	public ResponseEntity<LeaveStatus> updateLeaveStatus(@RequestBody LeaveStatus leaveStatus, @PathVariable String code) {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveStatusController::updateLeaveStatus() called");
		}
		LeaveStatus existingLeaveStatus = leaveStatusService.getLeaveStatus(leaveStatus.getCode());
		if (existingLeaveStatus == null) {
			if (logger.isErrorEnabled()) {
				logger.error("LeaveStatusController::updateLeaveStatus() " + leaveStatus.getCode() + " update failed");
			}
			return new ResponseEntity<LeaveStatus>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<LeaveStatus>(existingLeaveStatus, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/leaveStatus/{code}")
	public ResponseEntity<LeaveStatus> patchLeaveStatus(@RequestBody LeaveStatus leaveStatus, @PathVariable String code) {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveStatusController::patchLeaveStatus() called");
		}
		LeaveStatus existingLeaveStatus = leaveStatusService.getLeaveStatus(leaveStatus.getCode());
		if (existingLeaveStatus == null) {
			if (logger.isErrorEnabled()) {
				logger.error("LeaveStatusController::patchLeaveStatus() " + leaveStatus.getCode() + " patch failed");
			}
			return new ResponseEntity<LeaveStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<LeaveStatus>(existingLeaveStatus, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/leaveStatus/{code}")
	public ResponseEntity<LeaveStatus> deleteLeaveStatus(@PathVariable String code) {
		if (logger.isDebugEnabled()) {
			logger.debug("LeaveStatusController::deleteLeaveStatus() called");
		}
		return new ResponseEntity<LeaveStatus>(HttpStatus.BAD_REQUEST); // Delete not supported
	}
	
}
