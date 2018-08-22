package org.tum.gis.minisos.dataSourceConnection.thingspeak;

import static org.mockito.Matchers.contains;

//import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

import org.springframework.web.client.RestTemplate;
//import org.apache.catalina.mapper.Mapper;
//import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class thingspeakTest {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		// TODO Auto-generated method stub

		Yaml yaml = new Yaml();
		
		Reader yamlFile = new FileReader ("application.yml");
		
		Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(yamlFile);
		
		Object obj = yamlMaps.get("datasource-connection");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ThingspeakConnection obj1 = mapper.convertValue(obj,ThingspeakConnection.class);
		
		JsonNode jsonNode = mapper.convertValue(obj1, JsonNode.class);
		String str = jsonNode.toString();
		String url1 = "https://api.thingspeak.com/channels/64242/feeds.json";
		RestTemplate restTemplate = new RestTemplate();
		
		String str1 = restTemplate.getForObject(url1, String.class);
		 
		 
		JsonNode jsonTextResponse = mapper.readTree(str1);
		
		
		//if(jsonTextResponse.has(""))
		
		/*String str2 = "field2";
		if (str2.contains("field")) {
			System.out.println("Yes");
		}*/
		
		int totalFields = jsonTextResponse.get("channel").size()-8;
		
		for(int i=1;i<=totalFields;i++) {
			String fieldNumber = Integer.toString(i);
			System.out.println(jsonTextResponse.get("channel").get("field"+fieldNumber));
		}
		
		
	}

}
