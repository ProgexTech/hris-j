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
public class WorkDayCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(WorkDayCategoryController.class);
	
	@Autowired
	private WorkDayCategoryService workDayCategoryService;
	
	@GetMapping("/workDayCategories")
	public ResponseEntity<Set<WorkDayCategory>> getAllWorkDayCategories() {
		Set<WorkDayCategory> workDayCategorySet = workDayCategoryService.getAllWorkDayCategories();
		if (workDayCategorySet.isEmpty()) {
			return new ResponseEntity<Set<WorkDayCategory>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the WorkDayCategory´s");
		
		return new ResponseEntity<Set<WorkDayCategory>>(workDayCategorySet, HttpStatus.OK);
	}
	
	@PostMapping("/workDayCategories")
	public ResponseEntity<WorkDayCategory> addWorkDayCategory(@RequestBody WorkDayCategory workDayCategory) {
		if (logger.isInfoEnabled())
			logger.info("WorkDayCategory to save " + workDayCategory);
		
		WorkDayCategory returnedWorkDayCategory = workDayCategoryService.addWorkDayCategory(workDayCategory);
		
		return new ResponseEntity<WorkDayCategory>(returnedWorkDayCategory, HttpStatus.CREATED);
	}
	
}
