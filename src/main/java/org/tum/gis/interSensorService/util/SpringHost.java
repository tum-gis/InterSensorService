package org.tum.gis.interSensorService.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpringHost {

	
	//private static Environment environment;
	
	public static String getPort() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		
		Reader yamlFile = new FileReader ("application.yml");		
		Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(yamlFile);		
		Object obj = yamlMaps;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.convertValue(obj,JsonNode.class);
		
		//if port not defined explicitly in YAML file, then default is 8080
		if (jsonNode.get("server")==null) {
			return "8080";
		}else {
			
			
			return jsonNode.get("server").get("port").toString();
		}
		
		
	}
	
	public static String getHostAddress() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	public static String getHostName() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}
}
