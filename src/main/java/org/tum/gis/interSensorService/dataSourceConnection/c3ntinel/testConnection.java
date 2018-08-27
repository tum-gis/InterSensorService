package org.tum.gis.interSensorService.dataSourceConnection.c3ntinel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.meter.Meter;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.readings.C3ntinelReadings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testConnection {

	public static void main(String[] args) throws URISyntaxException, JsonProcessingException, IOException {
		// TODO Auto-generated method stub

		/*RestTemplate restTemplate = new RestTemplate();
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
	 
	    
	    System.out.println(response.getBody().getSummaryInfo().getSum());*/
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		
		String notEncoded = "cb15e1c0-ec03-4e38-ab7c-0fc07fb3a276"+":"+"Mcr]D^{2EJ";
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		
		String authString = "Basic "+encodedAuth;
		headers.set("Authorization", authString);
		
		String url = "https://auth.c3ntinel.com/sso/oauth/token";
		URI uri = new URI(url);
	    
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity( uri, request , String.class );
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonTextResponse = mapper.readTree(response.getBody());
		//JSONObject jsonObj = new JSONObject(response.getBody());
		//System.out.println(jsonTextResponse.get("access_token").toString());
		String accessToken = jsonTextResponse.get("access_token").toString().replace("\"", "");
		
		String startTime= "2018-07-17T21:59:59%2B02:00";
		String startTimeModified = startTime.substring(0, 19)+".000Z";
		String endTime= "2018-07-24T21:59:59%2B02:00";
		String endTimeModified = endTime.substring(0, 19)+".000Z";
		
		String url1 = "https://api.c3ntinel.com/meter/64575/readings?resolution=DAY&start_date="+startTimeModified+"&end_date="+endTimeModified;
		URI uri1 = new URI(url1);
		
		
		HttpHeaders headers2 = new HttpHeaders();
		String authBearerString = "Bearer "+accessToken;
		
		headers2.set("Accept", "application/json");
	    //headers.set("Authorization", "Basic S2FuaXNoay5DaGF0dXJ2ZWRpOlRVTWdpczIwMTc=");
		headers2.set("Authorization", authBearerString);
		
	    HttpEntity entity2 = new HttpEntity(headers2);
		
	    
	    
	    ResponseEntity<String> response2 = restTemplate.exchange(url1, HttpMethod.GET, entity2, String.class);
		
		System.out.println(response2.getBody());
	}

}
