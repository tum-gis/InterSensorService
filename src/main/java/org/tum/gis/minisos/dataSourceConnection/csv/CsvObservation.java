package org.tum.gis.minisos.dataSourceConnection.csv;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.util.CustomDateUtil;
import org.tum.gis.minisos.util.ObservationValueUtil;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CsvObservation extends Observation  {
	
	//private int timeseriesId;
	
	private String time;
	
	private double value;
	
	

}
