package com.progex.hris.holiday;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {
	
	public Iterable<Holiday> findAllHolidaysByOrderByCreatedDateAsc();
	
	public Iterable<Holiday> findAllHolidaysByYearOrderByCreatedDateAsc(int year);

}
