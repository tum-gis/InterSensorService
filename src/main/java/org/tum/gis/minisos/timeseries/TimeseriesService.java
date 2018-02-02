package org.tum.gis.minisos.timeseries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

@Service
public class TimeseriesService {

	//read newly created dataSourceConnection details and form a new TimseriesObject
	
	public List<Timeseries> timeseriesList = new ArrayList<>(); 
	
	public void addTimeseries(DataSourceConnection dataSourceConnection) {
		
		Timeseries timeseries = new Timeseries(
				dataSourceConnection.getId(),
				dataSourceConnection.getName(),
				dataSourceConnection.getDescription(),
				dataSourceConnection.getConnectionType(),
				null,
				null,
				dataSourceConnection.getObservationType(),
				dataSourceConnection.getUnitOfMeasure()				
				);
		
		timeseriesList.add(timeseries);	
	}
	
	public List<Timeseries> getTimeseriesList(){
		return timeseriesList;
	}
}
