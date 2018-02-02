package com.progex.hris.workDay;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkDayCategoryServiceImpl implements WorkDayCategoryService {
	
	@Autowired
	private WorkDayCategoryRepository workDayCategoryRepository;

	@Override
	public WorkDayCategory addWorkDayCategory(WorkDayCategory workDayCategory) {
		return workDayCategoryRepository.save(workDayCategory);
	}

	@Override
	public void deleteWorkDayCategory(String name) {
		workDayCategoryRepository.delete(name);
	}

	@Override
	public WorkDayCategory updateWorkDayCategory(WorkDayCategory workDayCategory) {
		return workDayCategoryRepository.save(workDayCategory);
	}

	@Override
	public Set<WorkDayCategory> getAllWorkDayCategories() {
		Set<WorkDayCategory> workDayCategorySet = new HashSet<WorkDayCategory>();
		workDayCategoryRepository.findAll().forEach(workDayCategorySet::add);
		return workDayCategorySet;
	}

}
