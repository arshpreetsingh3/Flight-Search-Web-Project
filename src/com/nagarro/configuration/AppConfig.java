package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightDao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dao.LoginDao;
import com.nagarro.daoImpl.DaoImpl;
import com.nagarro.daoImpl.FlightDaoImpl;
import com.nagarro.daoImpl.FlightFilesDaoImpl;
import com.nagarro.daoImpl.LoginDaoImpl;
import com.nagarro.services.AirportCodeLoaderService;
import com.nagarro.services.FareComparatorService;
import com.nagarro.services.FlightLoaderService;
import com.nagarro.services.FlightSearchService;
import com.nagarro.services.OutputPreferenceService;
import com.nagarro.services.LoginService;;

@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public Dao getDao() {
		return new DaoImpl();
	}

	@Bean
	public LoginDao getUserDao() {
		return new LoginDaoImpl();
	}

	@Bean
	public FlightDao getFlightDao() {
		return new FlightDaoImpl();
	}

	@Bean
	public FlightFileDao getFlightFileDao() {
		return new FlightFilesDaoImpl();
	}

	@Bean
	public FlightLoaderService getFlightLoader() {
		return new FlightLoaderService();
	}

	@Bean
	public FlightSearchService getFlightSearch() {
		return new FlightSearchService();
	}

	@Bean
	public AirportCodeLoaderService getAirportCodeLoader() {
		return new AirportCodeLoaderService();
	}

	@Bean
	public OutputPreferenceService getOutputPreferance() {
		return new OutputPreferenceService();
	}

	@Bean
	public FareComparatorService getFlightComparator() {
		return new FareComparatorService();
	}

	@Bean
	public LoginService getUserService() {
		return new LoginService();
	}

}