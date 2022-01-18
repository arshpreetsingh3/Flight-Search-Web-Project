package com.nagarro.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.constant.Constants;
import com.nagarro.dao.FlightDao;
import com.nagarro.dto.FlightStructure;

public class FlightSearchService {
	@Autowired
	private FlightDao flightdao;

	public List<FlightStructure> getSearchResult(String to, String from, String date, String flightClass) throws ParseException {
		List<FlightStructure> searchResult;

		SimpleDateFormat format = Constants.getDateFormatter();
		Date flightdate = format.parse(date);

		searchResult = flightdao.getFlights(to, from, flightdate, flightClass);

		return searchResult;
	}

}
