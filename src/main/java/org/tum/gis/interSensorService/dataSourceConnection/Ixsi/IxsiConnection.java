package org.tum.gis.interSensorService.dataSourceConnection.Ixsi;

import org.tum.gis.interSensorService.dataSourceConnection.DataSourceConnection;

public class IxsiConnection extends DataSourceConnection {

	private String serviceName;
	private String serviceType;
	private String messageID;
	private String systemID;
	
	
	public IxsiConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public IxsiConnection(  int id, 
							String name, 
							String description, 
							String connectionType, 
							String observationProperty,
							String observationType, 
							String unitOfMeasure,
							String serviceName,
							String serviceType,
							String messageID,
							String systemID) {
								
								super(	id, 
										name, 
										description, 
										connectionType, 
										observationProperty, 
										observationType, 
										unitOfMeasure);
								this.serviceName = serviceName;
								this.serviceType = serviceType;
								this.messageID = messageID;
								this.systemID = systemID;
		// TODO Auto-generated constructor stub
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

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}
	
	
	
	
}
