package com.progex.hris.workDay;

import java.util.Set;

public interface WorkDayCategoryService {
	
	public Set<WorkDayCategory> getAllWorkDayCategories();
	
	public WorkDayCategory addWorkDayCategory(WorkDayCategory workDayCategory);
	
	public void deleteWorkDayCategory(String name);
	
	public WorkDayCategory updateWorkDayCategory(WorkDayCategory workDayCategory);

}
