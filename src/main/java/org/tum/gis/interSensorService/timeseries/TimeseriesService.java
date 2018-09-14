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
