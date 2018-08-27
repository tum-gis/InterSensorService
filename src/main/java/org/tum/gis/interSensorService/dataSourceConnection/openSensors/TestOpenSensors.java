package org.tum.gis.interSensorService.dataSourceConnection.openSensors;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.client.RestTemplate;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.observations.Observations;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.topics.Topics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestOpenSensors {

	public static void main(String[] args) throws URISyntaxException, JsonProcessingException, IOException {
		// TODO Auto-generated method stub

		String baseUrl = "https://api.opensensors.io";
		String topicName = "/users/thomashkolbe/tumgis-seeeduino-wo-gps";
		String start = "2018-05-02T00:00:00";
		String end = "2018-05-03T00:00:00";
		String authKey = "5bc93dcc-6bf6-4cae-9ea3-a325587d6443";
		
		
		String start1;
		start1 = start.replaceAll("\\+","%2B");
		//start.replaceAll(regex, replacement)
		String end1;
		end1 = end.replaceAll("\\+","%2B");
		
	
		
		String serviceUrl = baseUrl+"/v1/messages/topic/"+topicName+"?start-date="+start+"&end-date="+end+"&api-key="+authKey;
		//System.out.println(serviceUrl);
		URI uri = new URI(serviceUrl);
		//System.out.println(uri);
		RestTemplate restTemplate = new RestTemplate();
		Observations observations = restTemplate.getForObject(uri, Observations.class);
		//Topics topics = restTemplate.getForObject(uri, Topics.class); 
		String nextLink = "/v1/messages/topic/"+topicName+"?start-date="+start1+"&end-date="+end1;
				
		while (nextLink != null) {
			System.out.println("Before:"+nextLink);
			serviceUrl = baseUrl+nextLink+"&api-key="+authKey;
			uri = new URI(serviceUrl);
			System.out.println("Uri:"+uri);
			
			observations = restTemplate.getForObject(uri, Observations.class);
			nextLink = observations.getNext();
			System.out.println("After:"+nextLink);
		}
		//System.out.println(observations.getMessages().size());
		//System.out.println(observations.getNext());
	
		//System.out.println(observations.getMessages().size());
		
		
		//System.out.println(observations.getMessages().get(0).getDate());
		//System.out.println(observations.getMessages().get(0).getPayload().getText());
		
		//String str = observations.getMessages().get(0).getPayload().getText();
		
		//ObjectMapper mapper = new ObjectMapper();
		//JsonNode actualObj = mapper.readTree(str);
		//JsonNode abc = actualObj.get("abc");
		//System.out.println(abc);
	}
	

}
