package com.nagarro.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.nagarro.constant.Constants;
import com.nagarro.dao.FlightDao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dto.FlightStructure;
import com.nagarro.dto.FlightFile;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class FlightLoaderService {

	@Autowired
	FlightFileDao flightFileDao;

	@Autowired
	FlightDao flightDao;

	private File folder = new File(Constants.FOLDERPATH);
	private File[] folderFiles;
	private List<FlightFile> dbFiles;
	private FileReader fileReader;
	private CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
	private CSVReader csvReader;

	@Scheduled(fixedRate = 7000, initialDelay = 5000)
	public void loadFlights() throws IOException, ParseException {

		dbFiles = flightFileDao.getAllFlightFiles();
		folderFiles = folder.listFiles();

		checkNewFlights();

	}

	private void checkNewFlights() throws IOException, ParseException {

		for (File folderFile : folderFiles) {

			FlightFile folderflightFile = new FlightFile();
			folderflightFile.setFileName(folderFile.getName());

			if (!dbFiles.contains(folderflightFile)) {
				readFlightsFromFile(folderflightFile, folderFile);
			} else {
				checkForNewEntriesInFile(folderflightFile, folderFile);
			}
		}
	}

	private void readFlightsFromFile(FlightFile folderflightFile, File folderFile) {
		try {

			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			List<String[]> allFlightData = csvReader.readAll();
			int noOfEntries = allFlightData.size() - 1;

			for (int rowNumber = 1; rowNumber < allFlightData.size(); rowNumber++) {
				FlightStructure newFlight = createFlightObject(allFlightData.get(rowNumber));
				flightDao.addFlight(newFlight);
			}

			folderflightFile.setNoRows(noOfEntries);
			flightFileDao.addFlightFile(folderflightFile);

		} catch (FileNotFoundException fileNotFoundException) {

		} catch (IOException ioException) {

		} catch (Exception exception) {
		}

	}

	private void checkForNewEntriesInFile(FlightFile folderflightFile, File folderFile) throws IOException, ParseException {
			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			List<String[]> allFlightData = csvReader.readAll();
			int noOfEntries = allFlightData.size() - 1;

			FlightFile dbFlightFile = (FlightFile) flightFileDao.getFlightFile(folderflightFile.getFileName());
			int noOfEntriesDB = dbFlightFile.getNoRows();

			if (noOfEntriesDB != noOfEntries) {

				for (int rowNumber = 1 + noOfEntriesDB; rowNumber < allFlightData.size(); rowNumber++) {
					FlightStructure newFlight = createFlightObject(allFlightData.get(rowNumber));
					flightDao.addFlight(newFlight);
				}

				folderflightFile.setNoRows(noOfEntries);
				flightFileDao.updateFlightFile(folderflightFile);
			}
	}

	private FlightStructure createFlightObject(String[] flightData) throws ParseException {
		FlightStructure flight = new FlightStructure();
		flight.setFlightNumber(flightData[0]);
		flight.setDepartLocation(flightData[1]);
		flight.setArrivalLocation(flightData[2]);
		flight.setFlightDate(flightData[3]);
		flight.setFlightTime(Integer.parseInt(flightData[4]));
		flight.setFlightDuration(Double.parseDouble(flightData[5]));
		flight.setFare(Integer.parseInt(flightData[6]));
		flight.setSeatAvailablility(flightData[7].charAt(0));
		flight.setFlightClass(flightData[8]);
		return flight;
	}
}
