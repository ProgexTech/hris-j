package com.progex.hris.organization;

import java.util.Set;

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

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * Adds given department
	 * 
	 * @param department
	 * @return {@link ResponseEntity<@link{Department}>}
	 */
	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(departmentService.addDepartment(department), HttpStatus.OK);
	}

	/**
	 * 
	 * @return Returns all the departments. An empty Set will be returned if no
	 *         department is available
	 */
	@GetMapping("/departments")
	public ResponseEntity<Set<Department>> getAll() {
		return new ResponseEntity<Set<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
	}
	
	/**
	 * Remove the department with the given id
	 * @param id
	 */
	@DeleteMapping("/departments/{id}")
	public void delete(@PathVariable Short id) {
		departmentService.delete(id);
	}
}
