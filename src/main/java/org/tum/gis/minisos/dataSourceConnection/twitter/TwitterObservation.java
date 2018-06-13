package org.tum.gis.minisos.dataSourceConnection.twitter;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.util.CustomDateUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TwitterObservation extends Observation {

	private String time;
	private double value;
	private String strValue;
	
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		String timestamp;
		Date dateEval;
		DateTime date = null;
		
		try {
			System.out.println("Step1: "+time);
			dateEval = CustomDateUtil.DateTimePatternEval(time) ;
			System.out.println("Step2: "+dateEval);
			try {
				date = CustomDateUtil.DateTimeCreator(dateEval);
				System.out.println("Step3: "+date);
			} catch (ParseException e) {
				System.err.println("dateEval: Could not parse date: " + dateEval);
			}
		} catch (ParseException e) {
			System.err.println("time: Could not parse date: " + time);
		}
				
		//this.timestamp = CustomDateUtil.IsoFormatter(date);	
		timestamp = date.toString();
		return timestamp;
	}
	
	@Override
	public void setTime(String time) {
		// TODO Auto-generated method stub
		if(time != null) {
			this.time=time;
		}
		
	}

	@Override
	public String getStrValue() {
		return strValue;
	}

	@Override
	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	@JsonIgnore
	public double getValue() {
		return value;
	}
	
	
}