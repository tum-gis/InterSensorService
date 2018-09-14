/*
 * InterSensor Service
 * http://www.intersensorservice.org/
 * 
 * Copyright 2018
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The InterSensor Service has been developed by
 * Kanishk Chaturvedi and Thomas H. Kolbe
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.tum.gis.interSensorService.initializer;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//import java.io.UnsupportedEncodingException;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.Map;

//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.C3ntinelConnection;
import org.tum.gis.interSensorService.dataSourceConnection.csv.CsvConnection;
import org.tum.gis.interSensorService.dataSourceConnection.openSensors.OpenSensorsConnection;
import org.tum.gis.interSensorService.dataSourceConnection.sensorThings.SensorThingsConnection;
import org.tum.gis.interSensorService.dataSourceConnection.thingspeak.ThingspeakConnection;
import org.tum.gis.interSensorService.dataSourceConnection.twitter.TwitterConnection;
import org.tum.gis.interSensorService.util.SpringHost;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Initializer {

	public static void httpPost() throws ClientProtocolException, IOException {
		// Check if datasource connection details exist in application.yml

	
		
		
		Yaml yaml = new Yaml();
		
		Reader yamlFile = new FileReader ("application.yml");		
		Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(yamlFile);		
		Object obj = yamlMaps.get("datasource-connection");
		
		// check the datasource name. If it is ThingSpeak, datasource type is Thingspeak
		
		ObjectMapper mapper = new ObjectMapper();		
		
		
		JsonNode jsonNode = mapper.convertValue(obj,JsonNode.class);
		
		JsonNode jsonNodeDataSource = null;
		
		
		//HTTP POST with the defined datasourceconnection
		String connectionType = jsonNode.get("connectionType").toString();
		
		String datasourceType = null;
		switch(connectionType) {
			
			case "\"Thingspeak\"":
				datasourceType = "thingspeak";
				ThingspeakConnection thingspeakConnection = mapper.convertValue(obj,ThingspeakConnection.class);
				jsonNodeDataSource = mapper.convertValue(thingspeakConnection, JsonNode.class);
				break;
			
			case "\"SensorThings\"":
				datasourceType = "sensorThings";
				SensorThingsConnection sensorThingsConnection = mapper.convertValue(obj, SensorThingsConnection.class);
				jsonNodeDataSource = mapper.convertValue(sensorThingsConnection, JsonNode.class);
				break;
			
			case "\"OpenSensors\"":
				datasourceType = "openSensors";
				OpenSensorsConnection openSensorsConnection = mapper.convertValue(obj, OpenSensorsConnection.class);
				jsonNodeDataSource = mapper.convertValue(openSensorsConnection, JsonNode.class);
				break;
			
			case "\"CSV\"":
				datasourceType = "csv";
				CsvConnection csvConnection = mapper.convertValue(obj, CsvConnection.class);
				jsonNodeDataSource = mapper.convertValue(csvConnection, JsonNode.class);
				break;
			
			case "\"C3ntinel\"":
				datasourceType = "c3ntinel";
				C3ntinelConnection c3ntinelConnection = mapper.convertValue(obj, C3ntinelConnection.class);
				jsonNodeDataSource = mapper.convertValue(c3ntinelConnection, JsonNode.class);
				break;
			
			case "\"Twitter\"":
				datasourceType = "twitter";
				TwitterConnection twitterConnection = mapper.convertValue(obj, TwitterConnection.class);
				jsonNodeDataSource = mapper.convertValue(twitterConnection, JsonNode.class);
				break;
			
			/*case "\"JDBC\"":
				datasourceType = "jdbc";
				JdbcConnection jdbcConnection = mapper.convertValue(obj, JdbcConnection.class);
				jsonNodeDataSource = mapper.convertValue(jdbcConnection, JsonNode.class);
				break;*/
		}
		
		
		
		 HttpClient httpClient = new DefaultHttpClient();
		 
		 
		 String postUrl = 	"http://"+ 
				 			SpringHost.getHostAddress() + 
				 			":"+
				 			SpringHost.getPort()+
				 			"/"+
				 			datasourceType;
		
					
				 			
		 
		 HttpPost httpPost = new HttpPost(postUrl);

		 httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		 
		 
		 try {

			 StringEntity stringEntity = new StringEntity(jsonNodeDataSource.toString());
			 httpPost.getRequestLine();
			 
		     httpPost.setEntity(stringEntity);
		    
		     
		     
		     httpClient.execute(httpPost);
		 } catch (Exception e) {
			 throw new RuntimeException(e);
		 }
		
	}
	
	
}
