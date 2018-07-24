package org.tum.gis.minisos.observation;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.expression.ParseException;
import org.tum.gis.minisos.util.CustomDateUtil;

public class Observation {

	//private int timeseriesId;
	private String time;
	private String timestamp;
	private double value;
	
	private String strValue;
	
	private Date dateEval;
	private DateTime date;
	
	public Observation() {
		
	}
	
	public Observation( String time, double value) {
		super();
		
		this.time = time;
		this.value = value;
	}
	
	public Observation( String time, String strValue) {
		super();
		
		this.time = time;
		this.strValue = strValue;
	}
	
	
	public String getTime() throws java.text.ParseException {			
		
		try {
			dateEval = CustomDateUtil.DateTimePatternEval(time) ;
			System.out.println("Check:"+ dateEval );
			try {
				date = CustomDateUtil.DateTimeCreator(dateEval);
				System.out.println("Check:"+ date );
			} catch (ParseException e) {
				System.err.println("Could not parse date: " + dateEval);
			}
		} catch (ParseException e) {
			System.err.println("Could not parse date: " + time);
		}
				
		//this.timestamp = CustomDateUtil.IsoFormatter(date);	
		timestamp = date.toString();
		System.out.println("Check:"+ timestamp );
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

	public String getStrValue() {
		return strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
	
	
	
}
