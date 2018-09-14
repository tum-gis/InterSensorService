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

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSource.DataSource;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.dataSourceConnection.DataSourceConnection;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.C3ntinelConnection;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.C3ntinelService;
import org.tum.gis.interSensorService.dataSourceConnection.csv.CsvConnection;
import org.tum.gis.interSensorService.dataSourceConnection.csv.CsvConnectionService;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.OpenSensorsConnection;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.OpenSensorsService;
import org.tum.gis.interSensorService.dataSourceConnection.sensorThings.SensorThingsConnection;
import org.tum.gis.interSensorService.dataSourceConnection.sensorThings.SensorThingsService;
import org.tum.gis.interSensorService.dataSourceConnection.thingspeak.ThingspeakConnection;
import org.tum.gis.interSensorService.dataSourceConnection.thingspeak.ThingspeakService;
import org.tum.gis.interSensorService.dataSourceConnection.twitter.TwitterConnection;
import org.tum.gis.interSensorService.dataSourceConnection.twitter.TwitterService;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation.GetObservationResponse;
import org.tum.gis.interSensorService.interfaces.sensorObservationService.GetObservation.ObservationData;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.ListObservation52n;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.Observation52n;
import org.tum.gis.interSensorService.timeseries.Timeseries;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;
import org.tum.gis.interSensorService.util.CustomDateUtil;

@Service
public class ObservationService {

	//public List<Observation> observationList = new ArrayList<>();
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private ThingspeakService thingspeakService;
	
	@Autowired
	private CsvConnectionService csvConnectionService;
	
	@Autowired
	private SensorThingsService sensorThingsService;
	
	@Autowired
	private OpenSensorsService openSensorsService;
	
	@Autowired
	private TwitterService twitterService;
	
	@Autowired
	private C3ntinelService c3ntinelService;
	
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
	
	/*public List<Observation> getObservationList(int id, String startTime, String endTime) throws ParseException {
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
	}*/
	
	//Another approach
	//Input timeseries ID, check with timeseries ID, what datasource it is. Open the connection and Parse accordingly and close
	//getObservationList(timeseriesID)
	//Datasource.parse()
	// insert into observationList
	//retrieve List
	
	public List<Observation> getObservationList(int timeseriesId) throws IOException, ParseException{
		Timeseries timeseries = null;
		DataSourceConnection dataSource = null;
		for (int i = 0; i< timeseriesService.timeseriesList.size();i++) {
			if (timeseriesService.timeseriesList.get(i).getId()==timeseriesId) {
				timeseries = timeseriesService.timeseriesList.get(i);
			}
		}
		
		for (int i = 0; i<dataSourceService.datasources.size();i++ ) {
			if (dataSourceService.datasources.get(i).getId()==timeseries.getDataSourceId()) {
				dataSource = dataSourceService.datasources.get(i).getDataSourceConnection();
			}
		}
		
		
		
		if (dataSource instanceof ThingspeakConnection) {
			ThingspeakConnection thingspeakConnection = (ThingspeakConnection) dataSource;
			
			//thingspeakService.parseTSService(id, ts);
			return thingspeakService.parseThingspeak(timeseriesId,thingspeakConnection);
			
		} else if (dataSource instanceof CsvConnection) {
			CsvConnection csvConnection = (CsvConnection) dataSource;
			return csvConnectionService.parseCsv(timeseriesId, csvConnection);
		} else if (dataSource instanceof TwitterConnection) {
			
			
			TwitterConnection twitterConnection = (TwitterConnection) dataSource;
			return twitterService.parseTwitter(timeseriesId, twitterConnection);
		} 
		return null;
	}
	
	public List<Observation> getObservationList(int timeseriesId, String startTime, String endTime) throws IOException, ParseException, URISyntaxException{
		Timeseries timeseries = null;
		DataSourceConnection dataSource = null;
		for (int i = 0; i< timeseriesService.timeseriesList.size();i++) {
			if (timeseriesService.timeseriesList.get(i).getId()==timeseriesId) {
				timeseries = timeseriesService.timeseriesList.get(i);
			}
		}
		
		for (int i = 0; i<dataSourceService.datasources.size();i++ ) {
			if (dataSourceService.datasources.get(i).getId()==timeseries.getDataSourceId()) {
				dataSource = dataSourceService.datasources.get(i).getDataSourceConnection();
			}
		}
		
		if (dataSource instanceof ThingspeakConnection) {
			ThingspeakConnection thingspeakConnection = (ThingspeakConnection) dataSource;		
			return thingspeakService.parseThingspeak(timeseriesId,thingspeakConnection, startTime, endTime);
			
		}else if (dataSource instanceof CsvConnection) {
			CsvConnection csvConnection = (CsvConnection) dataSource;
			return csvConnectionService.parseCsv(timeseriesId, csvConnection, startTime, endTime);
			
		} else if(dataSource instanceof SensorThingsConnection) {
			SensorThingsConnection sensorThingsConnection = (SensorThingsConnection) dataSource;
			return sensorThingsService.parseSensorThings(timeseriesId, sensorThingsConnection, startTime, endTime);
			
		} else if (dataSource instanceof OpenSensorsConnection) {
			OpenSensorsConnection openSensorsConnection = (OpenSensorsConnection) dataSource;
			return openSensorsService.parseOpenSensors(timeseriesId, openSensorsConnection, startTime, endTime);
		} else if (dataSource instanceof C3ntinelConnection) {
			C3ntinelConnection c3ntinelConnection = (C3ntinelConnection) dataSource;
			return c3ntinelService.parseC3ntinel(timeseriesId, c3ntinelConnection, startTime, endTime);
		}
		return null;
	}
	
	//just for testing
	public ListObservation52n list52n;
	
	public ListObservation52n getObservationList(int timeseriesId, String startTime, String endTime, String format) throws IOException, ParseException, URISyntaxException{
		Timeseries timeseries = null;
		DataSourceConnection dataSource = null;
		for (int i = 0; i< timeseriesService.timeseriesList.size();i++) {
			if (timeseriesService.timeseriesList.get(i).getId()==timeseriesId) {
				timeseries = timeseriesService.timeseriesList.get(i);
			}
		}
		
		for (int i = 0; i<dataSourceService.datasources.size();i++ ) {
			if (dataSourceService.datasources.get(i).getId()==timeseries.getDataSourceId()) {
				dataSource = dataSourceService.datasources.get(i).getDataSourceConnection();
			}
		}
		
		
		List<Observation> observationList = new ArrayList<>();
		List<Observation52n> observation52nList = new ArrayList<>();
		 list52n = new ListObservation52n();
		
		if (dataSource instanceof ThingspeakConnection) {
			ThingspeakConnection thingspeakConnection = (ThingspeakConnection) dataSource;		
			observationList = thingspeakService.parseThingspeak(timeseriesId,thingspeakConnection, startTime, endTime);
			for (Observation observation : observationList) {
				Observation52n observation52n = new Observation52n();
				observation52n.setTimestamp(CustomDateUtil.UnixTimeCreator(observation.getTime()));
				observation52n.setValue(observation.getValue());
				observation52nList.add(observation52n);
			}
			list52n.setValues(observation52nList);
			return list52n;
			
		}else if (dataSource instanceof CsvConnection) {
			CsvConnection csvConnection = (CsvConnection) dataSource;
			observationList = csvConnectionService.parseCsv(timeseriesId, csvConnection, startTime, endTime);
			for (Observation observation : observationList) {
				Observation52n observation52n = new Observation52n();
				observation52n.setTimestamp(CustomDateUtil.UnixTimeCreator(observation.getTime()));
				observation52n.setValue(observation.getValue());
				observation52nList.add(observation52n);
			}
			list52n.setValues(observation52nList);
			return list52n;
			
		} else if (dataSource instanceof SensorThingsConnection) {
			SensorThingsConnection sensorThingsConnection = (SensorThingsConnection) dataSource;
			observationList = sensorThingsService.parseSensorThings(timeseriesId, sensorThingsConnection, startTime, endTime);
			for (Observation observation : observationList) {
				Observation52n observation52n = new Observation52n();
				observation52n.setTimestamp(CustomDateUtil.UnixTimeCreator(observation.getTime()));
				observation52n.setValue(observation.getValue());
				observation52nList.add(observation52n);
			}
			list52n.setValues(observation52nList);
			return list52n;
			
		} else if (dataSource instanceof OpenSensorsConnection) {
			OpenSensorsConnection openSensorsConnection = (OpenSensorsConnection) dataSource;
			observationList = openSensorsService.parseOpenSensors(timeseriesId, openSensorsConnection, startTime, endTime);
			for (Observation observation : observationList) {
				Observation52n observation52n = new Observation52n();
				observation52n.setTimestamp(CustomDateUtil.UnixTimeCreator(observation.getTime()));
				observation52n.setValue(observation.getValue());
				observation52nList.add(observation52n);
			}
			list52n.setValues(observation52nList);
			return list52n;
			
		} else if (dataSource instanceof C3ntinelConnection) {
			C3ntinelConnection c3ntinelConnection = (C3ntinelConnection) dataSource;
			observationList = c3ntinelService.parseC3ntinel(timeseriesId, c3ntinelConnection, startTime, endTime);
			for (Observation observation : observationList) {
				Observation52n observation52n = new Observation52n();
				observation52n.setTimestamp(CustomDateUtil.UnixTimeCreator(observation.getTime()));
				observation52n.setValue(observation.getValue());
				observation52nList.add(observation52n);
			}
			list52n.setValues(observation52nList);
			return list52n;
		}
		return null;
	}
	
	/*public GetObservationResponse getObservationList(int timeseriesId, String startTime, String endTime, String format) throws IOException, ParseException{
		Timeseries timeseries = timeseriesService.timeseriesList.get(timeseriesId-1);
		DataSourceConnection dataSource = dataSourceService.datasources.get(timeseries.getDataSourceId()-1).getDataSourceConnection();
		List<Observation> observationList = new ArrayList<>();
		List<ObservationData> observationDataList = new ArrayList<>();
		GetObservationResponse observationResponse = new GetObservationResponse();
		
		if (dataSource instanceof ThingspeakConnection) {
			ThingspeakConnection thingspeakConnection = (ThingspeakConnection) dataSource;		
			observationList = thingspeakService.parseThingspeak(timeseriesId,thingspeakConnection, startTime, endTime);
			for (Observation observation : observationList) {
				ObservationData observationData = new ObservationData();
				observationData.setPhenomenonTime(observation.getTime()); 
				observationData.setValue(observation.getValue());
				observationDataList.add(observationData);
			}
			observationResponse.setGetObservationResponse(observationDataList);
			return observationResponse;
			
		}else if (dataSource instanceof CsvConnection) {
			CsvConnection csvConnection = (CsvConnection) dataSource;
			observationList = csvConnectionService.parseCsv(timeseriesId, csvConnection, startTime, endTime);
			for (Observation observation : observationList) {
				ObservationData observationData = new ObservationData();
				observationData.setPhenomenonTime(observation.getTime()); 
				observationData.setValue(observation.getValue());
				observationDataList.add(observationData);
			}
			observationResponse.setGetObservationResponse(observationDataList);
			return observationResponse;
		}		
		return null;
	} */
	
}
