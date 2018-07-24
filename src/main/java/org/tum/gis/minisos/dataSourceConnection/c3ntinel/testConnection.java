package org.tum.gis.minisos.dataSourceConnection.c3ntinel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.minisos.dataSourceConnection.c3ntinel.meter.Meter;
import org.tum.gis.minisos.dataSourceConnection.c3ntinel.readings.C3ntinelReadings;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testConnection {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		String notEncoded = "Kanishk.Chaturvedi"+":"+"TUMgis2017";
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		
		String authString = "Basic "+encodedAuth;
		
		String startTime= "2018-07-17T21:59:59%2B02:00";
		String startTimeModified = startTime.substring(0, 19)+".000Z";
		String endTime= "2018-07-24T21:59:59%2B02:00";
		String endTimeModified = endTime.substring(0, 19)+".000Z";
		
		String url = "https://api.staging.c3ntinel.com/meter/13462/readings?resolution=DAY&start_date="+startTimeModified+"&end_date="+endTimeModified;
		URI uri = new URI(url);
		headers.set("Accept", "application/json");
	    //headers.set("Authorization", "Basic S2FuaXNoay5DaGF0dXJ2ZWRpOlRVTWdpczIwMTc=");
		headers.set("Authorization", authString);
		
	    HttpEntity entity = new HttpEntity(headers);
	    
	    
	    ResponseEntity<C3ntinelReadings> response = restTemplate.exchange(url, HttpMethod.GET, entity, C3ntinelReadings.class);
	    
	    System.out.println(startTimeModified);
	 
	    
	    System.out.println(response.getBody().getSummaryInfo().getSum());
	    
	}

}
