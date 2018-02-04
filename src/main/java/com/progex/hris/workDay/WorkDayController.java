package com.progex.hris.workDay;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WorkDayController {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkDayController.class);
	
	@Autowired
	private WorkDayService workDayService;
	
	@GetMapping("/workDays")
	public ResponseEntity<Set<WorkDay>> geAllWorkDays() {
		Set<WorkDay> workDays = workDayService.getAllWorkDays();
		if (workDays.isEmpty()) {
			return new ResponseEntity<Set<WorkDay>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the WorkDayCategory´s");
		
		return new ResponseEntity<Set<WorkDay>>(workDays, HttpStatus.OK);
	}
	
	@PostMapping("/workDays")
	public ResponseEntity<WorkDay> addWorkDay(@RequestBody WorkDay workDay) {
		if (logger.isInfoEnabled())
			logger.info("WorkDayCategory to save " + workDay);
		
		WorkDay returnedWorkDay = workDayService.addWorkDay(workDay);
		
		return new ResponseEntity<WorkDay>(returnedWorkDay, HttpStatus.CREATED);
	}

}
