/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.jdbc;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.util.CustomDateUtil;

/**
 * @author kchaturvedi
 *
 */
@Entity
@Table(name = "DB1")
public class JdbcObservation extends Observation  {

	@Id
	@Column(name = "TIME")
	private String time;
	
	@Column(name = "VALUE")
	private double value;
	

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
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setValue(double value) {
		// TODO Auto-generated method stub
		this.value= value;
	}
	
}
