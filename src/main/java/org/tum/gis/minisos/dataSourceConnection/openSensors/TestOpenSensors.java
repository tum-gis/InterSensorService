package org.tum.gis.minisos.dataSourceConnection.openSensors;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.tum.gis.minisos.dataSourceConnection.openSensors.observations.Observations;
import org.tum.gis.minisos.dataSourceConnection.openSensors.topics.Topics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestOpenSensors {

	public static void main(String[] args) throws URISyntaxException, JsonProcessingException, IOException {
		// TODO Auto-generated method stub

		String baseUrl = "https://api.opensensors.io/v1";
		String topicName = "/users/thomashkolbe/tumgis-seeeduino-wo-gps";
		String start = "2018-05-01";
		String end = "2018-05-02";
		String authKey = "5bc93dcc-6bf6-4cae-9ea3-a325587d6443";
		
		
		String start1;
		start1 = start.replaceAll("\\+","%2B");
		//start.replaceAll(regex, replacement)
		String end1;
		end1 = end.replaceAll("\\+","%2B");
		
	
		
		String serviceUrl = baseUrl+"/messages/topic/"+topicName+"?api-key="+authKey+"&start-date="+start1+"&end-date="+end1;
		//System.out.println(serviceUrl);
		URI uri = new URI(serviceUrl);
		//System.out.println(uri);
		RestTemplate restTemplate = new RestTemplate();
		Observations observations = restTemplate.getForObject(uri, Observations.class);
		//Topics topics = restTemplate.getForObject(uri, Topics.class); 
		
		String topicUrl = baseUrl+"/topics/"+topicName+"?api-key="+authKey;
		//RestTemplate requires Get request as URI. The default conversion of string to Uri omits special or extra characters which lead to issues
		URI topicUri = new URI(topicUrl); 
		
		
		RestTemplate restTemplateTopic = new RestTemplate();
		Topics topics = restTemplateTopic.getForObject(topicUri, Topics.class);
		
		List<Double> coordinates = new ArrayList<>();
		coordinates.add(topics.getStats().getLocation().getLat());
		coordinates.add(topics.getStats().getLocation().getLon());
		System.out.println(coordinates.get(1));
		
		
		
		//System.out.println(observations.getMessages().get(0).getDate());
		//System.out.println(observations.getMessages().get(0).getPayload().getText());
		
		String str = observations.getMessages().get(0).getPayload().getText();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(str);
		JsonNode abc = actualObj.get("abc");
		//System.out.println(abc);
	}
	

}
