package com.progex.hris.holiday;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progex.hris.dto.HolidayDTO;
import com.progex.hris.workDay.WorkDayController;

@RestController
@RequestMapping("/api")
public class HolidayController {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkDayController.class);
	
	@Autowired
	private HolidayService holidayService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/holidays")
	public ResponseEntity<Set<HolidayDTO>> getAllHolidays() {
		Set<Holiday> holidays = holidayService.getAllHolidays();
		if (holidays.isEmpty()) {
			return new ResponseEntity<Set<HolidayDTO>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the getAllHolidays");
		
		Type targetListType = new TypeToken<Set<HolidayDTO>>() {}.getType();
		Set<HolidayDTO> dtos = new HashSet<>();
		dtos = modelMapper.map(holidays, targetListType);
		return new ResponseEntity<Set<HolidayDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/holidays/byYear/{year}")
	public ResponseEntity<Set<HolidayDTO>> getAllHolidaysByYear(@PathVariable int year) {
		Set<Holiday> holidays = holidayService.getAllHolidaysByYear(year);
		if (holidays.isEmpty()) {
			return new ResponseEntity<Set<HolidayDTO>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the getAllHolidaysByYear: " + year);
		
		Type targetListType = new TypeToken<Set<HolidayDTO>>() {}.getType();
		Set<HolidayDTO> dtos = new HashSet<>();
		dtos = modelMapper.map(holidays, targetListType);
		return new ResponseEntity<Set<HolidayDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/holidays/years")
	public ResponseEntity<Set<Integer>> getAllHolidayYears() {
		Set<Integer> years = holidayService.getAllHolidayYears();
		if (years.isEmpty()) {
			return new ResponseEntity<Set<Integer>>(HttpStatus.NO_CONTENT);
		}
		if (logger.isInfoEnabled())
			logger.info("Returning all the getAllHolidayYears");
		
		return new ResponseEntity<Set<Integer>>(years, HttpStatus.OK);
	}
	
	@PostMapping("/holidays")
	public ResponseEntity<HolidayDTO> addHoliday(@RequestBody HolidayDTO dto) {		
		if (logger.isInfoEnabled())
			logger.info("HolidayDTO to save " + dto);
		
		Date date = dto.getDate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		Holiday holiday = modelMapper.map(dto, Holiday.class);
		holiday.setYear(calendar.get(Calendar.YEAR));
		holiday.setMonth(calendar.get(Calendar.MONTH) + 1);
		holiday.setCreatedDate(new Date());
		
		Holiday returnedHoliday = holidayService.addHoliday(holiday);
		HolidayDTO returnDto = modelMapper.map(returnedHoliday, HolidayDTO.class);
		
		return new ResponseEntity<HolidayDTO>(returnDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("holidays/{id}")
	public void deleteHoliday(@PathVariable long id) {
		if (logger.isInfoEnabled())
			logger.info("Removing Holiday = " + id);
		
		holidayService.deleteHoliday(id);
	}
	
}
