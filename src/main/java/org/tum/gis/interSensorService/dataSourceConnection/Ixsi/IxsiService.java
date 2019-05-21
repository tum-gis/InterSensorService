package org.tum.gis.interSensorService.dataSourceConnection.Ixsi;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSource.DataSource;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.interSensorService.observation.Observation;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;
import org.tum.gis.interSensorService.util.IdSequenceManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class IxsiService {

	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	public void addDataSource(IxsiConnection ixsiConnection) {
		int dataSourceId = IdSequenceManager.DataSourceSequence();
		int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
		
		DataSource dataSource = new DataSource(dataSourceId,ixsiConnection);
		dataSourceService.addDataSource(dataSource);
		
		timeseriesService.addTimeseries(timeseriesId,dataSourceId,ixsiConnection);
		validateIxsiConnection(timeseriesId,ixsiConnection);
	}
	
	public void validateIxsiConnection(int timeseriesId, IxsiConnection ixsiConnection) {
		//do nothing
	}
	
	public List<Observation> parseIxsi(int timeseriesId, IxsiConnection ixsiConnection) throws ParserConfigurationException, SAXException, IOException{
		List<Observation> observationList = new ArrayList<>();
		
		File fXmlFile = new File("C:/Hackathon/IxsiResponse.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		String bookeeId;
		String carName;
		String placeId;
		String longitude;
		String latitude;
		String streetHouseNr;
		String city;
		String url;
		
		NodeList nList = doc.getElementsByTagName("Bookee");
		for (int i = 0; i<nList.getLength(); i++) {
			Node nNode = nList.item(i);
			//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				if (eElement.getElementsByTagName("PlaceID").getLength()>0) {
					//System.out.println(eElement.getElementsByTagName("PlaceID"));
					bookeeId = eElement.getElementsByTagName("ID").item(0).getTextContent();
					carName = eElement.getElementsByTagName("Text").item(0).getTextContent();
					placeId = eElement.getElementsByTagName("PlaceID").item(0).getTextContent();
					
					url = "https://ewi3-de14test.preview.cantamen.de/#48.3646-10.8438-14-8/place/"+placeId;
					
					
					NodeList nList2 = doc.getElementsByTagName("Place");
					for (int j = 0; j < nList2.getLength(); j++) {
						Node nNode2 = nList2.item(j);
						
						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement2 = (Element) nNode2;
							
							
							if(eElement2.getElementsByTagName("ID").item(0).getTextContent().equals(placeId)) {
								longitude = eElement2.getElementsByTagName("Longitude").item(0).getTextContent();
								latitude =  eElement2.getElementsByTagName("Latitude").item(0).getTextContent();
								streetHouseNr = eElement2.getElementsByTagName("StreetHouseNr").item(0).getTextContent();
								city = eElement2.getElementsByTagName("City").item(0).getTextContent();
								
								//System.out.println(bookeeId+"---"+carName+"---"+placeId+"---"+longitude+"---"+latitude+"---"+streetHouseNr+"---"+city);
								
								ObjectMapper mapper = new ObjectMapper();
								ObjectNode resultIxsi = mapper.createObjectNode();
								
								resultIxsi.put("bookeeId",bookeeId);
								resultIxsi.put("carName",carName);
								resultIxsi.put("placeId",placeId);
								resultIxsi.put("longitude",longitude);
								resultIxsi.put("latitude",latitude);
								resultIxsi.put("streetHouseNr",streetHouseNr);
								resultIxsi.put("city",city);
								resultIxsi.put("url",url);
								
								
								IxsiObservation ixsiObservation = new IxsiObservation();
								Date date = new Date();
								ixsiObservation.setTime(date.toString());
								ixsiObservation.setStrValue(resultIxsi.toString());
								
								observationList.add(ixsiObservation);
								
								
							}
						}
					}
				}
				
			}
		}
		
		
		
		return observationList;
	}
}
