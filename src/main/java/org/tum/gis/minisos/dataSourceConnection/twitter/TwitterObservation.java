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
			dateEval = CustomDateUtil.DateTimePatternEval(time) ;
			
			try {
				date = CustomDateUtil.DateTimeCreator(dateEval);
			} catch (ParseException e) {
				System.err.println("Could not parse date: " + dateEval);
			}
		} catch (ParseException e) {
			System.err.println("Could not parse date: " + time);
		}
				
		//this.timestamp = CustomDateUtil.IsoFormatter(date);	
		timestamp = date.toString();
		return timestamp;
	}
	
	@Override
	public void setTime(String time) {
		// TODO Auto-generated method stub
		this.time=time;
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
