package org.tum.gis.interSensorService.timeseries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSourceConnection.DataSourceConnection;

@Service
public class TimeseriesService {

	//read newly created dataSourceConnection details and form a new TimseriesObject
	
	public List<Timeseries> timeseriesList = new ArrayList<>(); 
	
	public void addTimeseries(int timeseriesId , int dataSourceId, DataSourceConnection dataSourceConnection) {
		
		Timeseries timeseries = new Timeseries(
				timeseriesId,
				dataSourceId,				
				dataSourceConnection.getName(),
				dataSourceConnection.getDescription(),
				dataSourceConnection.getConnectionType(),
				null,
				null,
				dataSourceConnection.getObservationProperty(),
				dataSourceConnection.getObservationType(),
				dataSourceConnection.getUnitOfMeasure()				
				);
		
		timeseriesList.add(timeseries);	
	}
	
	public List<Timeseries> getTimeseriesList(){
		return timeseriesList;
	}
	
	public Timeseries getTimeseriesById(int id) {
		for (int i=0;i<timeseriesList.size();i++) {
			if (timeseriesList.get(i).getId()==id) {
				return timeseriesList.get(i);
			}
		}
		return null;
		
	}
	
	public void deleteTimeseriesById (int id) {
		for (int i=0;i<timeseriesList.size();i++) {
			if (timeseriesList.get(i).getId()==id) {
				timeseriesList.remove(i);
			}
		}
	}
}