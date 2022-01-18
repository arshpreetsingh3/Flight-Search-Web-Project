package com.nagarro.services;

import java.util.Comparator;

import com.nagarro.dto.FlightStructure;

public class FareComparatorService {

	public Comparator<FlightStructure> getFlightComparatorbyFare() {

		return (flight1, flight2) -> {
			return Double.compare(flight1.getFare(), flight2.getFare());
		};

	}

	public Comparator<FlightStructure> getFlightComparatorbyFareDuration() {

		return (flight1, flight2) -> {
			int s1 = Double.compare(flight1.getFare(), flight2.getFare());
			if (s1 == 0) {
				int s2 = Double.compare(flight1.getFlightDuration(), flight2.getFlightDuration());
				return s2;
			}
			return s1;
		};

	}
}
