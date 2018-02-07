package org.tum.gis.minisos.observation;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.expression.ParseException;
import org.tum.gis.minisos.util.CustomDateUtil;

public class Observation {

	private int timeseriesId;
	private String time;
	private String timestamp;
	private double value;
	
	private Date dateEval;
	private DateTime date;
	
	public Observation() {
		
	}
	
	public Observation(int timeseriesId, String time, double value) {
		super();
		this.timeseriesId = timeseriesId;
		this.time = time;
		this.value = value;
	}
	
	public int getTimeseriesId() {
		return timeseriesId;
	}
	
	public void setTimeseriesId(int timeseriesId) {		
		this.timeseriesId = timeseriesId;
	}	
	
	public String getTime() throws java.text.ParseException {			
		
		try {
			dateEval = CustomDateUtil.DateTimePatternEval(time) ;
			
			try {
				date = CustomDateUtil.DateTimeCreator(dateEval);
			} catch (ParseException e) {
				System.err.println("Could not parse date: " + dateEval);
			}
		} catch (ParseException e) {
			System.err.println("Could not parse date: " + time);
		}
				
		this.timestamp = CustomDateUtil.IsoFormatter(date);	
		
		return timestamp;
	}
	
	public void setTime(String time) {		
		this.time = time;
	}
	
	public double getValue() {
				return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	
}
