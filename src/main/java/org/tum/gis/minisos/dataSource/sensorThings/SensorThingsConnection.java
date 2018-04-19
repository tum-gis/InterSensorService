package org.tum.gis.minisos.dataSource.sensorThings;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

public class SensorThingsConnection extends DataSourceConnection {

	private String serviceName;
	private String serviceType;
	private String baseUrl;
	private int thingId;
	private int datastreamId;
	private String authKey;
	
	public SensorThingsConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SensorThingsConnection(int id, 
								  String name, 
								  String description, 
								  String connectionType,								  
								  String observationProperty, 
								  String observationType, 
								  String unitOfMeasure,
								  String serviceName, 
								  String serviceType, 
								  String baseUrl, 
								  int thingId, 
								  int datastreamId,
								  String authKey) {
		super(id, 
			  name, 
			  description, 
			  connectionType, 
			  observationProperty, 
			  observationType, 
			  unitOfMeasure);
		// TODO Auto-generated constructor stub
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.baseUrl = baseUrl;
		this.thingId = thingId;
		this.datastreamId = datastreamId;
		this.authKey = authKey;
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
	public int getThingId() {
		return thingId;
	}
	public void setThingId(int thingId) {
		this.thingId = thingId;
	}
	public int getDatastreamId() {
		return datastreamId;
	}
	public void setDatastreamId(int datastreamId) {
		this.datastreamId = datastreamId;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	
	
	
	
}
