package org.tum.gis.minisos.dataSourceConnection;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.tum.gis.minisos.util.CustomDateUtil;
import org.tum.gis.minisos.util.ObservationValueUtil;

import com.opencsv.bean.CsvBindByPosition;

public class CSVObject {

	@CsvBindByPosition(position = 0)
	private String timestamp;
	
	
	private Date dateEval;
	private DateTime date;
	
		
	private String isoDate ;
	
	@CsvBindByPosition(position = 1)
	private String value;
	
	private double doubleValue;
	

	
	public CSVObject() {
		
	}
	
	
	public CSVObject(String timestamp, String value) {
		super();	
		
		this.isoDate = isoDate;		
		this.doubleValue = doubleValue;	
		
		
	}
	
	
	public String getValue() {
		
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
	public double getDoubleValue() {
		this.doubleValue = ObservationValueUtil.StringToDouble(value);
		return doubleValue;
	}
	
	public String getIsoDate() {
		
				
		try {
			dateEval = CustomDateUtil.DateTimePatternEval(timestamp) ;
			
			try {
				date = CustomDateUtil.DateTimeCreator(dateEval);
			} catch (ParseException e) {
				System.err.println("Could not parse date: " + dateEval);
			}
		} catch (ParseException e) {
			System.err.println("Could not parse date: " + timestamp);
		}
				
		this.isoDate = CustomDateUtil.IsoFormatter(date);
		
		return isoDate;
	}
	
	
	
	
}
