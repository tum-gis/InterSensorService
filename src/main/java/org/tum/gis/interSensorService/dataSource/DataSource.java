package org.tum.gis.interSensorService.dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.tum.gis.interSensorService.dataSourceConnection.DataSourceConnection;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.C3ntinelConnection;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.C3ntinelService;
import org.tum.gis.interSensorService.dataSourceConnection.csv.CsvConnection;
import org.tum.gis.interSensorService.dataSourceConnection.sensorThings.SensorThingsConnection;
import org.tum.gis.interSensorService.dataSourceConnection.thingspeak.ThingspeakConnection;
import org.tum.gis.interSensorService.dataSourceConnection.twitter.TwitterConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DataSource {

	private int id;
	private DataSourceConnection dataSourceConnection;	
	private List<Double> coordinates = new ArrayList<>(Arrays.asList(11.566464,48.150175)); //default Chair of Geoinformatics, TU Munich
	

	
	public DataSource(int id, DataSourceConnection dataSourceConnection) {
		super();
		this.id = id;
		this.dataSourceConnection = dataSourceConnection;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonIgnore
	public DataSourceConnection getDataSourceConnection() {
		return dataSourceConnection;
	}
	
	
	public Object getDataConnection() {
		Map<String,Object> mapper = new HashMap<>();
		mapper.put("name", dataSourceConnection.getName());
		mapper.put("description", dataSourceConnection.getDescription());
		mapper.put("connectionType", dataSourceConnection.getConnectionType());
		
		if (dataSourceConnection instanceof C3ntinelConnection ) {
			C3ntinelConnection c3ntinelConnection = (C3ntinelConnection) dataSourceConnection;
			mapper.put("serviceType", c3ntinelConnection.getServiceType());	
			mapper.put("baseUrl", c3ntinelConnection.getBaseUrl());
			mapper.put("meterId", c3ntinelConnection.getMeterId());
			mapper.put("resolution", c3ntinelConnection.getResolution());		
			mapper.put("userName", "********");
			mapper.put("userPassword", "********");
		}
		
		if (dataSourceConnection instanceof ThingspeakConnection ) {
			ThingspeakConnection thingspeakConnection = (ThingspeakConnection) dataSourceConnection;
			mapper.put("serviceType", thingspeakConnection.getServiceType());
			mapper.put("channel", thingspeakConnection.getChannel());
			mapper.put("field", thingspeakConnection.getfield());			
		}
		
		if (dataSourceConnection instanceof TwitterConnection ) {
			TwitterConnection twitterConnection = (TwitterConnection) dataSourceConnection;
			mapper.put("serviceType", twitterConnection.getServiceType() );
			mapper.put("baseUrl", twitterConnection.getBaseUrl());
			mapper.put("apiKey", "********");
			mapper.put("apiSecret", "********");
			mapper.put("accessToken", "********");
			mapper.put("accessTokenSecret", "********");
			mapper.put("searchString", twitterConnection.getSearchString());
			mapper.put("radius", twitterConnection.getRadius());
			
		}
		
		if (dataSourceConnection instanceof CsvConnection ) {
			CsvConnection csvConnection = (CsvConnection) dataSourceConnection;
			mapper.put("fileLocation", csvConnection.getFileLocation());
			mapper.put("separator", csvConnection.getSeparator());
			mapper.put("timeBeginColumn", csvConnection.getTimeBeginColumn());
			mapper.put("timeEndColumn", csvConnection.getTimeEndColumn());
			mapper.put("valueColumn", csvConnection.getValueColumn());
			mapper.put("searchStringColumn", csvConnection.getVenueColumn());
			mapper.put("searchString", csvConnection.getSearchVenue());
		}
		
		if (dataSourceConnection instanceof SensorThingsConnection ) {
			SensorThingsConnection sensorThingsConnection = (SensorThingsConnection) dataSourceConnection;
			mapper.put("serviceType", sensorThingsConnection.getServiceType());
			mapper.put("baseUrl", sensorThingsConnection.getBaseUrl());
			mapper.put("thingId", sensorThingsConnection.getThingId());
			mapper.put("datastreamId", sensorThingsConnection.getDatastreamId());
		}
		
		return mapper;
	}
	
	
	public void setDataSourceConnection(DataSourceConnection dataSourceConnection) {
		this.dataSourceConnection = dataSourceConnection;
	}
	
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
}
