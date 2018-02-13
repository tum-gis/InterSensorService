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
	private String serviceUrl;
	private String authKey;
	
	public ThingspeakConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThingspeakConnection(int id, 
								String name, 
								String description, 
								String connectionType, 
								String observationType,
								String unitOfMeasure,
								String serviceName,
								String serviceType,
								String serviceUrl) {
		super(id, 
			  name, 
			  description, 
			  connectionType, 
			  observationType, 
			  unitOfMeasure);
		// TODO Auto-generated constructor stub
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.serviceUrl = serviceUrl;
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
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	
	
	
}
