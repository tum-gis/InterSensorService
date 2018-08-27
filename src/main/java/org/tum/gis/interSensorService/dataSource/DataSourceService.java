package org.tum.gis.interSensorService.dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSourceConnection.DataSourceConnection;
import org.tum.gis.interSensorService.dataSourceConnection.csv.CsvConnection;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;

@Service
public class DataSourceService {

	@Autowired
	private TimeseriesService timeseriesService;
	
	public List<DataSource> datasources = new ArrayList<>(Arrays.asList(
			//data1,
			//data2
			));
	
	public List<DataSource> getAllDataSources(){
		return datasources;
	}

	public void addDataSource(DataSource dataSource) {
		datasources.add(dataSource);		
		
	}
	
	public DataSource getDataSource(int id) {
		for (int i=0; i<datasources.size();i++) {
			if(datasources.get(i).getId()==id) {
				return datasources.get(i);
			}
		}
		return null;
		
	}
	
	public void deleteDataSource(int id) {
		timeseriesService.deleteTimeseriesById(id); //supposing each datasource has exactly one timeseries
		for (int i=0; i<datasources.size();i++) {
			if(datasources.get(i).getId()==id) {
				datasources.remove(i);	
			}
		}
	}
}
