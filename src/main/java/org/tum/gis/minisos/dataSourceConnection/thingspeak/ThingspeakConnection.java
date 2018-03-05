/**
 * 
 */
package org.tum.gis.minisos.dataSourceConnection.thingspeak;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

/**
 * @author kchaturvedi
 *
 */
public class ThingspeakConnection extends DataSourceConnection {

	private String serviceName;
	private String serviceType;
	//private String serviceUrl;
	private int channel;
	private int field;
	private String authKey;
	
	public ThingspeakConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThingspeakConnection(int id, 
								String name, 
								String description, 
								String connectionType, 
								String observationProperty,
								String observationType,
								String unitOfMeasure,
								String serviceName,
								String serviceType,
								int channel,
								int field,
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
		this.channel = channel;
		this.field = field;
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
		
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getfield() {
		return field;
	}
	public void setfield(int field) {
		this.field = field;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	
	
	
}
