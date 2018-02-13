package org.tum.gis.minisos.observation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;
import org.tum.gis.minisos.dataSourceConnection.thingspeak.ThingspeakConnection;
import org.tum.gis.minisos.dataSourceConnection.thingspeak.ThingspeakService;
import org.tum.gis.minisos.timeseries.Timeseries;
import org.tum.gis.minisos.timeseries.TimeseriesService;

@Service
public class ObservationService {

	//public List<Observation> observationList = new ArrayList<>();
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private ThingspeakService thingspeakService;
	
	public List<ObservationListManager> observationList = new ArrayList<>();
	
	
	//getObservation() - if type is CSV, parse CSV and return List of CSV Object
	
	/*
	 getObservation(id){
	 	return List<Observation> for that id
	 }
	 
	 */
	
	/*public List<Observation> getObservationList(int id){
		return observationList.get(id-1).getObservationList();
	}*/
	
	public List<Observation> getObservationList(int id, String startTime, String endTime) throws ParseException {
		DateTime start = DateTime.parse(startTime);
		DateTime end = DateTime.parse(endTime);
	
		List<Observation> originalList = observationList.get(id-1).getObservationList();
		List<Observation> queriedList = new ArrayList<>();
		for (int i=0;i<originalList.size();i++) {
			if(DateTime.parse(originalList.get(i).getTime()).isAfter(start)&&DateTime.parse(originalList.get(i).getTime()).isBefore(end)) {
				queriedList.add(originalList.get(i));
			}
		}
		return queriedList;
	}
	
	//Another approach
	//Input timeseries ID, check with timeseries ID, what datasource it is. Open the connection and Parse accordingly and close
	//getObservationList(timeseriesID)
	//Datasource.parse()
	// insert into observationList
	//retrieve List
	
	public List<Observation> getObservationList(int id){
		Timeseries timeseries = timeseriesService.timeseriesList.get(id-1);
		DataSourceConnection dataSource = dataSourceService.datasources.get(timeseries.getDataSourceId()-1).getDataSourceConnection();
		
		if (dataSource instanceof ThingspeakConnection) {
			ThingspeakConnection ts = (ThingspeakConnection) dataSource;
			
			//thingspeakService.parseTSService(id, ts);
			thingspeakService.parseThingspeak(id,ts);
			
		}
		//check data source and parse
		return observationList.get(id-1).getObservationList();
	}
	
	
}
