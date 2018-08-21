package org.tum.gis.minisos.dataSourceConnection.c3ntinel;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

public class C3ntinelConnection extends DataSourceConnection {

	private String serviceName;
	private String serviceType;
	private String baseUrl;
	private int meterId;
	private String resolution;
	private String username;
	private String password;
	private double latitude;
	private double longitude;
	
	public C3ntinelConnection() {
		super();
	}
	
	public C3ntinelConnection(  int id, 
								String name, 
								String description, 
								String connectionType,
								String observationProperty, 
								String observationType, 
								String unitOfMeasure,
								String serviceName, 
								String serviceType, 
								String baseUrl, 
								int meterId, 
								String resolution, 
								String username,
								String password,
								double latitude,
								double longitude) {
		super(id, 
				  name, 
				  description, 
				  connectionType, 
				  observationProperty, 
				  observationType, 
				  unitOfMeasure
				  );
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.baseUrl = baseUrl;
		this.meterId = meterId;
		this.resolution = resolution;
		this.username = username;
		this.password = password;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public String getServiceName() {
		return serviceName;
	}



	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}



	public String getServiceType() {
		return serviceType;
	}



	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}



	public String getBaseUrl() {
		return baseUrl;
	}

	

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}



	public int getMeterId() {
		return meterId;
	}



	public void setMeterId(int meterId) {
		this.meterId = meterId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
