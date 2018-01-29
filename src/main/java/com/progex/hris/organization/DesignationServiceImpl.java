package com.progex.hris.organization;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesignationServiceImpl implements DesignationService{

	@Autowired
	DesignationRepository designationRepo;
	
	@Override
	public Designation addDesignation(Designation designation) {
		return designationRepo.save(designation);
	}

	@Override
	public Designation getDesignation(short id) {
		return designationRepo.findOne(id);
	}

	@Override
	public Set<Designation> getAllDesignations() {
		Set<Designation> designations = new HashSet<>();
		designationRepo.findAll().forEach(designations::add);
		return designations;
	}

	@Override
	public void delete(short id) {
		designationRepo.delete(id);
	}

}
