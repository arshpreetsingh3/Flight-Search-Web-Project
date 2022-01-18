package com.nagarro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.FlightDao;

@Service
public class AirportCodeLoaderService {

	@Autowired
	private FlightDao flightdao;

	@SuppressWarnings("unchecked")
	public List<String> getFromAirportCodes() {
		List<String> fromAirportCodes;

		fromAirportCodes = flightdao.getDepartureLocations();

		return fromAirportCodes;
	}


	@SuppressWarnings("unchecked")
	public List<String> getToAirportCodes() {
		List<String> toAirportCodes;

		toAirportCodes = flightdao.getArrivalLocations();

		return toAirportCodes;
	}
}
