package org.tum.gis.interSensorService.dataSourceConnection.csv;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.tum.gis.interSensorService.observation.Observation;
import org.tum.gis.interSensorService.util.CustomDateUtil;
import org.tum.gis.interSensorService.util.ObservationValueUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CsvObservation  {
	
	//private int timeseriesId;
	
	
	private String timeBegin;
	private String timeEnd;
	
	//value should be treated as string, corrected for null or corrupted entries, then converted into double for observation class
	
	private String csvValue;
	
	private String venue;

	public CsvObservation() {
		
	}
	
	public CsvObservation(String timeBegin, String timeEnd, String csvValue, String venue) {
		super();
		this.timeBegin = timeBegin;
		this.timeEnd = timeEnd;
		this.csvValue = csvValue;
		this.venue = venue;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	

	public String getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(String timeBegin) {
		this.timeBegin = timeBegin;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getCsvValue() {
		if (csvValue.isEmpty()|| csvValue.equals(null) || csvValue.equals("tbc")) {
			csvValue = "5.0";
		}
		return csvValue;
	}

	public void setCsvValue(String csvValue) {
		this.csvValue = csvValue;
	}
	
	
	//private double value;


	
	

}
