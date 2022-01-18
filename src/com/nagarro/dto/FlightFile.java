package com.nagarro.dto;

import javax.persistence.*;

@Entity
@Table(name = "FlightFiles")
public class FlightFile {

	@Id
	private String fileName;
	private int noRows;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getNoRows() {
		return noRows;
	}

	public void setNoRows(int noRows) {
		this.noRows = noRows;
	}

	@Override
	public boolean equals(Object obj) {
		FlightFile flightFile = (FlightFile) obj;
		return this.getFileName().equals(flightFile.getFileName());
	}
}
