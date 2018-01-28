package com.progex.hris.organization;

import java.util.Set;

import com.progex.hris.user.Designation;

public interface DesignationService {
	
	public Designation addDesignation(Designation designation);

	public Designation getDesignation(short id);

	public Set<Designation> getAllDesignations();

	public void delete(short id);
}
