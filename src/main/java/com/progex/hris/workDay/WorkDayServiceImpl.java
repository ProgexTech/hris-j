package com.progex.hris.workDay;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkDayServiceImpl implements WorkDayService {
	
	@Autowired
	private WorkDayRepository workDayRepository;

	@Override
	public Set<WorkDay> getAllWorkDays() {
		Set<WorkDay> workDays = new HashSet<WorkDay>();
		workDayRepository.findAll().forEach(workDays::add);
		return workDays;
	}

	@Override
	public WorkDay addWorkDay(WorkDay workDay) {
		return workDayRepository.save(workDay);
	}

	@Override
	public void deleteWorkDay(long id) {
		workDayRepository.delete(id);
	}

	@Override
	public WorkDay updateWorkDay(WorkDay workDay) {
		return workDayRepository.save(workDay);
	}

}
