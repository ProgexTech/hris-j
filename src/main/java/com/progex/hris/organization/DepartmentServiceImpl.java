package com.progex.hris.organization;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department getDepartment(short id) {
		return departmentRepository.findOne(id);
	}
	
	public Set<Department> getAllDepartments(){
		Set<Department> departments = new HashSet<Department>(); 
		departmentRepository.findAll().forEach(departments::add);
		return departments;
	}
	
	public void delete(short id) {
		departmentRepository.delete(id);
	}
}
