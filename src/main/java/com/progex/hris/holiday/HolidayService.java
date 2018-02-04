package com.progex.hris.holiday;

import java.util.Set;

public interface HolidayService {
	
	public Set<Holiday> getAllHolidays();
	
	public Set<Holiday> getAllHolidaysByYear(int year);
	
	public Holiday addHoliday(Holiday holiday);
	
	public void deleteHoliday(long id);
	
	public Holiday updateHoliday(Holiday holiday);
	
	public Set<Integer> getAllHolidayYears();

}
