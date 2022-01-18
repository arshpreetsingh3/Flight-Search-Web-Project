package com.nagarro.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import com.nagarro.constant.Constants;

import java.text.ParseException;

@Entity
@Table(name = "flights")
public class FlightStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String flightNumber;
	private String departLocation;
	private String arrivalLocation;
	private Date flightDate;
	private int flightTime;
	private double flightDuration;
	private double fare;
	private char seatAvailablility;
	private String flightClass;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartLocation() {
		return departLocation;
	}

	public void setDepartLocation(String departLocation) {
		this.departLocation = departLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) throws ParseException {
		SimpleDateFormat format = Constants.getDateFormatter();
		Date date = format.parse(flightDate);
		this.flightDate = date;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public char getSeatAvailablility() {
		return seatAvailablility;
	}

	public void setSeatAvailablility(char seatAvailablility) {
		this.seatAvailablility = seatAvailablility;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		flightId = this.flightId;
	}

}
