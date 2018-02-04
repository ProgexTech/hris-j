package com.progex.hris.holiday;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HolidayServiceImpl implements HolidayService {
	
	@Autowired
	private HolidayRepository holidayRepository;

	@Override
	public Set<Holiday> getAllHolidays() {
		Set<Holiday> holidays = new HashSet<>();
		holidayRepository.findAllHolidaysByOrderByCreatedDateAsc().forEach(holidays::add);
		return holidays;
	}
	
	@Override
	public Set<Holiday> getAllHolidaysByYear(int year) {
		Set<Holiday> holidays = new HashSet<>();
		holidayRepository.findAllHolidaysByYearOrderByCreatedDateAsc(year).forEach(holidays::add);
		return holidays;
	}
	
	@Override
	public Holiday addHoliday(Holiday holiday) {
		return holidayRepository.save(holiday);
	}
	
	@Override
	public void deleteHoliday(long id) {
		holidayRepository.delete(id);
	}
	
	@Override
	public Holiday updateHoliday(Holiday holiday) {
		return holidayRepository.save(holiday);
	}

	public Set<Integer> getAllHolidayYears() {
		Set<Integer> years = new HashSet<>();
		holidayRepository.findAll().forEach(holiday -> years.add(holiday.getYear()));
		return years;
	}
	
}
