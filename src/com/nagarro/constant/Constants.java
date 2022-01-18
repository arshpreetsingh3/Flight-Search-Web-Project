package com.nagarro.constant;

import java.text.SimpleDateFormat;

public class Constants {
	public static final String DATEFORMAT = "yyyy-MM-dd";
	public static final String FOLDERPATH = "D:\\FlightSearchWeb\\CSVfiles";

	public static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat(DATEFORMAT);
	}

}
