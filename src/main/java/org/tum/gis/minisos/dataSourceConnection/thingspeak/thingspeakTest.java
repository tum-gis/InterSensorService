package org.tum.gis.minisos.dataSourceConnection.thingspeak;

//import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

//import org.apache.catalina.mapper.Mapper;
//import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class thingspeakTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Yaml yaml = new Yaml();
		
		Reader yamlFile = new FileReader ("src/main/resources/application.yml");
		
		Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(yamlFile);
		
		Object obj = yamlMaps.get("datasource-connection");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ThingspeakConnection obj1 = mapper.convertValue(obj,ThingspeakConnection.class);
		
		JsonNode jsonNode = mapper.convertValue(obj1, JsonNode.class);
		
		
		System.out.println(jsonNode);
		
	}

}
