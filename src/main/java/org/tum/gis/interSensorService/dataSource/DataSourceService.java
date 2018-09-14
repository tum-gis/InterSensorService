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
