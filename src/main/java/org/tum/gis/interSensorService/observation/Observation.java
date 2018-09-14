/*
 * InterSensor Service
 * http://www.intersensorservice.org/
 * 
 * Copyright 2018
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The InterSensor Service has been developed by
 * Kanishk Chaturvedi and Thomas H. Kolbe
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.tum.gis.interSensorService.observation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.expression.ParseException;
import org.tum.gis.interSensorService.util.CustomDateUtil;

public class Observation {

	//private int timeseriesId;
	private String time;
	private String timestamp;
	private double value;
	private int intValue;
	private boolean boolValue;
	private List<Double> geomValue;
	
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
	
	public Observation( String time, int intValue) {
		super();
		
		this.time = time;
		this.intValue = intValue;
	}
	
	public Observation( String time, boolean boolValue) {
		super();
		
		this.time = time;
		this.boolValue = boolValue;
	}
	
	public Observation( String time, List<Double> geomValue) {
		super();
		
		this.time = time;
		this.geomValue = geomValue;
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
				
		//this.timestamp = CustomDateUtil.IsoFormatter(date);	
		timestamp = date.toString();
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

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public boolean isBoolValue() {
		return boolValue;
	}

	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}

	public List<Double> getGeomValue() {
		return geomValue;
	}

	public void setGeomValue(List<Double> geomValue) {
		this.geomValue = geomValue;
	}
	
	
	
}
