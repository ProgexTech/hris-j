package com.progex.hris.organization;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progex.hris.user.Designation;

@RestController
@RequestMapping("/api")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	private static final Logger logger = LoggerFactory.getLogger(DesignationController.class);

	/**
	 * Saves the given designation
	 * 
	 * @param designation
	 * @return saved designation
	 */
	@PostMapping("/designations")
	public ResponseEntity<Designation> addDesignation(@RequestBody Designation designation) {
		if (logger.isInfoEnabled())
			logger.info("Designation to be saved = " + designation);

		return new ResponseEntity<Designation>(designationService.addDesignation(designation), HttpStatus.OK);
	}

	/**
	 * Returns all the designations
	 * 
	 * @return
	 */
	@GetMapping("/designations")
	public ResponseEntity<Set<Designation>> getAllDesignations() {
		return new ResponseEntity<Set<Designation>>(designationService.getAllDesignations(), HttpStatus.OK);
	}

	/**
	 * Removes the designation with the given id
	 * 
	 * @param id
	 */
	@DeleteMapping("/designations/{id}")
	public void removeDesignation(@PathVariable Short id) {
		designationService.delete(id);
	}
}
