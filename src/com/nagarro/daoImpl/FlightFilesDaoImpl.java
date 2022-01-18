package com.nagarro.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dto.FlightFile;

public class FlightFilesDaoImpl implements FlightFileDao {

	@Autowired
	Dao dao;

	public List<FlightFile> getAllFlightFiles() {
		dao.begin();

		Criteria criteria = dao.getSession().createCriteria(FlightFile.class);
		List<FlightFile> flightFiles = (List<FlightFile>) criteria.list();

		dao.commit();
		dao.close();

		return flightFiles;
	}

	public FlightFile getFlightFile(String fileName) {

		dao.begin();

		FlightFile flightFile = (FlightFile) dao.getSession().get(FlightFile.class, fileName);

		dao.commit();
		dao.close();

		return flightFile;
	}

	public void updateFlightFile(FlightFile flightFile) {

		dao.begin();

		dao.getSession().update(flightFile);

		dao.commit();
		dao.close();

	}

	public void addFlightFile(FlightFile newFlightFile) {

		dao.begin();

		dao.getSession().save(newFlightFile);

		dao.commit();
		dao.close();

	}

}