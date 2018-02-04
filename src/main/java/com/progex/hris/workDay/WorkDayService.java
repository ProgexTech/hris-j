package com.progex.hris.workDay;

import java.util.Set;

public interface WorkDayService {
	
	public Set<WorkDay> getAllWorkDays();
	
	public WorkDay addWorkDay(WorkDay workDay);
	
	public void deleteWorkDay(long id);
	
	public WorkDay updateWorkDay(WorkDay workDay);

}
