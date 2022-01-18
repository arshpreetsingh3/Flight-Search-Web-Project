package com.nagarro.dao;

import java.util.Date;
import java.util.List;

import com.nagarro.dto.FlightFile;
import com.nagarro.dto.FlightStructure;

public interface FlightDao {


	public List<FlightStructure> getFlights(String arrivalLocation, String departLocation, Date flightDate, String flightClass);
	
	public List getArrivalLocations();
	
	public List getDepartureLocations();

	public void addFlight(FlightStructure newFlight);
}
