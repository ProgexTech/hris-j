package com.progex.hris.organization;

import java.util.Set;

public interface DepartmentService {

	public Department addDepartment(Department department);
	
	public Department getDepartment(short id);
	
	public Set<Department> getAllDepartments();
	
	public void delete(short id);
	
}
