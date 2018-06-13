package org.tum.gis.minisos.dataSourceConnection.twitter;

import org.tum.gis.minisos.dataSourceConnection.DataSourceConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TwitterConnection extends DataSourceConnection {

	private String serviceName;
	private String serviceType;
	private String baseUrl;
	
	private String apiKey;
	private String apiSecret;
	private String accessToken;
	private String accessTokenSecret;
	
	private String searchString;
	private double latitude;
	private double longitude;
	private int radius;
	
	public TwitterConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TwitterConnection(
					int id, 
					String name, 
					String description, 
					String connectionType, 
					String observationProperty,
					String observationType, 
					String unitOfMeasure,
					String serviceName,
					String serviceType,
					String baseUrl,
					String apiKey, 
					String apiSecret, 
					String accessToken, 
					String accessTokenSecret,
					String searchString, 
					double latitude, 
					double longitude, 
					int radius) {
		super(	id, 
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
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
		this.searchString = searchString;
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
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
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
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
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiSecret() {
		return apiSecret;
	}
	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	
	
	
	
	
	
	
	
}
