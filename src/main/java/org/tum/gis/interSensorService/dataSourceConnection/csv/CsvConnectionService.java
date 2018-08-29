package org.tum.gis.interSensorService.dataSourceConnection.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSource.DataSource;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.interfaces.sensorThingsApi.SensorThingsApiService;
import org.tum.gis.interSensorService.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.interSensorService.observation.Observation;
import org.tum.gis.interSensorService.observation.ObservationListManager;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.timeseries.TimeseriesService;
import org.tum.gis.interSensorService.util.DateTimeComparison;
import org.tum.gis.interSensorService.util.IdSequenceManager;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

@Service
public class CsvConnectionService {

	@Autowired
	private DataSourceService dataSourceService;
	
	
	
	@Autowired
	private TimeseriesService timeseriesService;
	
	@Autowired
	private ObservationService observationService;
	
	@Autowired
	private SeriesRestApiService seriesRestApiService;
	
	@Autowired
	private SensorThingsApiService sensorThingsApiService;
	
	public void addDataSource(CsvConnection csvConnection) throws IOException, ParseException {	
		
		//Add a new dataSourceConnection
		//if datasource with name is not available, add a new data source with unique id; else don't insert
		
		//check if dataSourceService.datasources contains the object with same name or not
		
		// if not, then generate a new sequence and insert a datasource
		
		int flag = 0;
		int dataSourceId = 1;
		for (int i=0; i<dataSourceService.datasources.size(); i++) {			
			if(csvConnection.getName().equals(dataSourceService.datasources.get(i).getDataSourceConnection().getName()))  {
				flag = 1;
				dataSourceId = dataSourceService.datasources.get(i).getId();
				break;
			}			
		}
		
		if (flag==1) {
			//get dataSourceID and create timeseries
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,csvConnection);
			//create an entry in ObservationListmanagere with TimeseriesID
			validateCsvConnection(timeseriesId, csvConnection);
			seriesRestApiService.seriesRestApi52nFormatter(csvConnection);
			sensorThingsApiService.SensorThingsApiFormatter(csvConnection);
			
		}else {
			//create datasource with new id and then create timeseries
			dataSourceId = IdSequenceManager.DataSourceSequence();
			DataSource dataSource = new DataSource(dataSourceId,csvConnection);
			dataSourceService.addDataSource(dataSource);
			
			int timeseriesId = IdSequenceManager.TimeseriesSourceSequence();
			timeseriesService.addTimeseries(timeseriesId,dataSourceId,csvConnection);
			//create an entry in ObservationListmanagere with TimeseriesID
			validateCsvConnection(timeseriesId, csvConnection);
			seriesRestApiService.seriesRestApi52nFormatter(csvConnection);
			sensorThingsApiService.SensorThingsApiFormatter(csvConnection);
		}

		
		//insert a new timeseries with unique id
		//timeseriesService.addTimeseries(csvConnection);
		
		//parseCsv(csvConnection);
		//should parse csv and create an ordered list of observation ( time,value for one timeseries id)
		// /timeseries/id/observation should refer to this list (queried by timeseries id and later, dates)
	}
	
	//parseCSV function
	
	//read csv location details, parse csv, create a list of observation 
	
	public void validateCsvConnection(int timeseriesId, CsvConnection csvConnection) throws IOException, ParseException {
		int timeColumn = csvConnection.getTimeBeginColumn();
		int valueColumn = csvConnection.getValueColumn();
		String fileLocation = csvConnection.getFileLocation();
		
		List<Observation> observationList = new ArrayList<>();
		
		//location
				List<Double> coordinates = new ArrayList<>();
				coordinates.add(csvConnection.getLongitude());
				coordinates.add(csvConnection.getLatitude());
				
				dataSourceService.datasources.get(0).setCoordinates(coordinates);
		
		
		try(
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));  
				Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
				
			){
			
				//Store Header values in an array. It is used for fetching appropriate header columns
				String[] csvHeaderList;
				String csvHeader = bufferedReader.readLine();
	        	if (csvHeader != null) {
	        		csvHeaderList = csvHeader.split(csvConnection.getSeparator());	      		
	        	
	        		Map<String, String> mapping = new HashMap<String, String>();
	        		
	        		mapping.put(csvHeaderList[timeColumn], "time");
		        	mapping.put(csvHeaderList[valueColumn], "csvValue");
		        	
		        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
		        	strategy.setType(CsvObservation.class);
		        	strategy.setColumnMapping(mapping);
		        	
		        	 CsvToBean csvToBean = new CsvToBeanBuilder(reader)
		             		 .withType(CsvObservation.class)
		                     .withMappingStrategy(strategy)		                     
		                     .withIgnoreLeadingWhiteSpace(true)
		                     .withSeparator(csvConnection.getSeparator().charAt(0))
		                     .build();
		             
		        	 csvToBean.setMappingStrategy(strategy);		             
		            
		            
		        	 
		             List<CsvObservation> csvObservations = csvToBean.parse();
		             
		            /* if (csvObservations!=null) {
		            	 timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation(csvObservations.get(0).getTime());
		            	 timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation(csvObservations.get(csvObservations.size()-1).getTime());
		             }*/
		             
		             for (CsvObservation csvObservation : csvObservations) {
		            	 //apply sorting here
		            	 double obsValue = Double.parseDouble(csvObservation.getCsvValue());
		            	 Observation newObservation = new Observation (csvObservation.getTimeBegin(),obsValue);
		            	 
		            	 observationList.add(newObservation);
		 				
		 				//Collections.sort(observationList1, new DateTimeComparison());
		 			}
		            
		             
		            
	        	}
	        	
				
	        	
			
			}
		
	}
	
	public List<Observation> parseCsv(int timeseriesId, CsvConnection csvConnection) throws IOException, ParseException {
		int timeBeginColumn = csvConnection.getTimeBeginColumn();
		int timeEndColumn = csvConnection.getTimeEndColumn();
		int valueColumn = csvConnection.getValueColumn();
		int venueColumn = csvConnection.getVenueColumn();
		
		String fileLocation = csvConnection.getFileLocation();
		
		List<Observation> observationList = new ArrayList<>();
		
		try(
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));  
				Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
				
				BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileLocation));  
				Reader reader1 = Files.newBufferedReader(Paths.get(fileLocation));
				
			){
			
				//Store Header values in an array. It is used for fetching appropriate header columns
				String[] csvHeaderList;
				String[] csvHeaderList1;
				
				String csvHeader = bufferedReader.readLine();
				String csvHeader1 = bufferedReader1.readLine();
				
	        	if (csvHeader != null) {
	        		csvHeaderList = csvHeader.split(csvConnection.getSeparator());	      		
	        	
	        		Map<String, String> mapping = new HashMap<String, String>();
	        		
	        		mapping.put(csvHeaderList[timeBeginColumn], "timeBegin");
		        	mapping.put(csvHeaderList[valueColumn], "csvValue");
		        	
		        	if(venueColumn!=0) {
		        		mapping.put(csvHeaderList[venueColumn], "venue");
		        	}
		        	
		        	
		        	
		        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
		        	strategy.setType(CsvObservation.class);
		        	strategy.setColumnMapping(mapping);
		        	
		        	
		        	
		        	 CsvToBean csvToBean = new CsvToBeanBuilder(reader)
		             		 .withType(CsvObservation.class)
		                     .withMappingStrategy(strategy)		                     
		                     .withIgnoreLeadingWhiteSpace(true)
		                     .withSeparator(csvConnection.getSeparator().charAt(0))
		                     .build();
		             
		        	 csvToBean.setMappingStrategy(strategy);		             
		        	
		             List<CsvObservation> csvObservations = csvToBean.parse();
		             
		             csvHeaderList1 = csvHeader1.split(csvConnection.getSeparator());
		        		
		        		Map<String, String> mapping1 = new HashMap<String, String>();
		            	 
		            	 	mapping1.put(csvHeaderList1[timeEndColumn], "timeEnd");
				        	mapping1.put(csvHeaderList1[valueColumn], "csvValue");
				        	
				        	
				        	
				        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy1 = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
				        	strategy1.setType(CsvObservation.class);
				        	strategy1.setColumnMapping(mapping1);
				        	
				        	 CsvToBean csvToBean1 = new CsvToBeanBuilder(reader1)
				             		 .withType(CsvObservation.class)
				                     .withMappingStrategy(strategy1)		                     
				                     .withIgnoreLeadingWhiteSpace(true)
				                     .withSeparator(csvConnection.getSeparator().charAt(0))
				                     .build();
				             
				        	 csvToBean1.setMappingStrategy(strategy1);		
				        	 
				        	 List<CsvObservation> csvObservations1 = csvToBean1.parse();
		         	
		           
		             
				       for (int i=0;i<csvObservations.size();i++) {
					   
				    	 if(!(csvConnection.getSearchVenue()==null)&&(csvConnection.getVenueColumn()!=0)) {
				    		 if (csvObservations.get(i).getVenue().equals(csvConnection.getSearchVenue())) {
					    		 double obsValue = Double.parseDouble(csvObservations.get(i).getCsvValue());
							     Observation newObservation = new Observation (csvObservations.get(i).getTimeBegin(),obsValue);
							            	 
							     if(timeEndColumn!=0) {
							    	 DateTime init_time = new DateTime(newObservation.getTime());
					            	 init_time = init_time.minusSeconds(5);
					            	 Observation initObservation = new Observation (init_time.toString(),0.0);
					            	 
					            	 double obsValue1 = Double.parseDouble(csvObservations1.get(i).getCsvValue());
					            	 Observation newObservation1 = new Observation (csvObservations1.get(i).getTimeEnd(),obsValue1);
					            	 
					            	 DateTime end_time = new DateTime(newObservation1.getTime());
					            	 end_time = end_time.plusSeconds(5);
					            	 Observation endObservation = new Observation (end_time.toString(),0.0);
					            	 
					            	 if(!newObservation.getTime().equals(newObservation1.getTime())) {
					            		 observationList.add(initObservation);		            		
						            	 observationList.add(newObservation);		            	 
						            	 observationList.add(newObservation1);			            	
						            	 observationList.add(endObservation);
					            	 } 
							     }
				            	 else {
				            		 observationList.add(newObservation);
				            	 }
				            		 
				            	 
					    	 }
				    	 }else {
				    		 double obsValue = Double.parseDouble(csvObservations.get(i).getCsvValue());
						     Observation newObservation = new Observation (csvObservations.get(i).getTimeBegin(),obsValue);
			            	 
						     
						     
						     if(timeEndColumn!=0) {
						    	 DateTime init_time = new DateTime(newObservation.getTime());
				            	 init_time = init_time.minusSeconds(5);
				            	 Observation initObservation = new Observation (init_time.toString(),0.0);
				            	 
				            	 double obsValue1 = Double.parseDouble(csvObservations1.get(i).getCsvValue());
				            	 Observation newObservation1 = new Observation (csvObservations1.get(i).getTimeEnd(),obsValue1);
				            	 
				            	 DateTime end_time = new DateTime(newObservation1.getTime());
				            	 end_time = end_time.plusSeconds(5);
				            	 Observation endObservation = new Observation (end_time.toString(),0.0);
				            	 
				            	if(!newObservation.getTime().equals(newObservation1.getTime())) {
				            		observationList.add(initObservation);		            		
					            	 observationList.add(newObservation);		            	 
					            	 observationList.add(newObservation1);			            	
					            	 observationList.add(endObservation);
				            	}
						     }else {
				            		observationList.add(newObservation);
				            	}
						     
			            	 
			            	 
				    	 }
				    	  
				    	 
		            
		            	 
		 				
		 				//Collections.sort(observationList1, new DateTimeComparison());
		 			}
	        	}
		            

	        	return observationList;
			
			}
		
	}
	
	public List<Observation> parseCsv(int timeseriesId, CsvConnection csvConnection, String startTime, String endTime) throws IOException, ParseException {
		int timeBeginColumn = csvConnection.getTimeBeginColumn();
		int timeEndColumn = csvConnection.getTimeEndColumn();
		int valueColumn = csvConnection.getValueColumn();
		int venueColumn = csvConnection.getVenueColumn();
		String fileLocation = csvConnection.getFileLocation();
		
		
		
		DateTime start = DateTime.parse(startTime);
		DateTime end = DateTime.parse(endTime);
		
		List<Observation> observationList = new ArrayList<>();
	
		
		try(
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));  
				Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
				
				BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileLocation));  
				Reader reader1 = Files.newBufferedReader(Paths.get(fileLocation));
				
			){
			
				//Store Header values in an array. It is used for fetching appropriate header columns
				String[] csvHeaderList;
				String csvHeader = bufferedReader.readLine();
				
				String[] csvHeaderList1;
				String csvHeader1 = bufferedReader1.readLine();
				
	        	if ((csvHeader != null) && (csvHeader1 != null)) {
	        		csvHeaderList = csvHeader.split(csvConnection.getSeparator());	      		
	        	
	        		Map<String, String> mapping = new HashMap<String, String>();
	        		
	        		mapping.put(csvHeaderList[timeBeginColumn], "timeBegin");
		        	mapping.put(csvHeaderList[valueColumn], "csvValue");
		        	
		        	if(venueColumn!=0) {
		        		mapping.put(csvHeaderList[venueColumn], "venue");
		        	}
		        	
		        	
		        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
		        	strategy.setType(CsvObservation.class);
		        	strategy.setColumnMapping(mapping);
		        	
		        	 CsvToBean csvToBean = new CsvToBeanBuilder(reader)
		             		 .withType(CsvObservation.class)
		                     .withMappingStrategy(strategy)		                     
		                     .withIgnoreLeadingWhiteSpace(true)
		                     .withSeparator(csvConnection.getSeparator().charAt(0))
		                     .build();
		             
		        	 csvToBean.setMappingStrategy(strategy);		            
		        	 
		             List<CsvObservation> csvObservations = csvToBean.parse();
		             
		             
		             csvHeaderList1 = csvHeader1.split(csvConnection.getSeparator());
		        		
	        		 Map<String, String> mapping1 = new HashMap<String, String>();
	            	 
	        		 	mapping1.put(csvHeaderList1[timeEndColumn], "timeEnd");
			        	mapping1.put(csvHeaderList1[valueColumn], "csvValue");
			        	
			        	
			        	
			        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy1 = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
			        	strategy1.setType(CsvObservation.class);
			        	strategy1.setColumnMapping(mapping1);
			        	
			        	 CsvToBean csvToBean1 = new CsvToBeanBuilder(reader1)
			             		 .withType(CsvObservation.class)
			                     .withMappingStrategy(strategy1)		                     
			                     .withIgnoreLeadingWhiteSpace(true)
			                     .withSeparator(csvConnection.getSeparator().charAt(0))
			                     .build();
			             
			        	 csvToBean1.setMappingStrategy(strategy1);		             
			            
			            
			        	 
			             List<CsvObservation> csvObservations1 = csvToBean1.parse();
			             
			             
		             
		             for (int i=0;i<csvObservations.size();i++) {
		            	 
		            	 if(!(csvConnection.getSearchVenue()==null)&&(csvConnection.getVenueColumn()!=0)) {
		            		 if (csvObservations.get(i).getVenue().equals(csvConnection.getSearchVenue())) {
			            		 double obsValue = Double.parseDouble(csvObservations.get(i).getCsvValue());
				            	 Observation newObservation = new Observation (csvObservations.get(i).getTimeBegin(),obsValue);
				            	 
				            	 if(timeEndColumn!=0) {
				            		 DateTime init_time = new DateTime(newObservation.getTime());
					            	 init_time = init_time.minusSeconds(5);
					            	 Observation initObservation = new Observation (init_time.toString(),0.0);
					            	 
					            	 double obsValue1 = Double.parseDouble(csvObservations1.get(i).getCsvValue());
					            	 Observation newObservation1 = new Observation (csvObservations1.get(i).getTimeEnd(),obsValue1);
					            	 
					            	
					            	 
					            	 DateTime end_time = new DateTime(newObservation1.getTime());
					            	 end_time = end_time.plusSeconds(5);
					            	 Observation endObservation = new Observation (end_time.toString(),0.0);
					            	 
					            	 if(DateTime.parse(newObservation.getTime()).isAfter(start)&&DateTime.parse(newObservation.getTime()).isBefore(end)) {
					            		 
					            		 
					            		 if(!newObservation.getTime().equals(newObservation1.getTime())) {
					            			 observationList.add(initObservation);			            		 
							            	 observationList.add(newObservation);					            	
							            	 observationList.add(newObservation1);				            	
							            	 observationList.add(endObservation);
					            		 }
					            		
						            
						            	
					            	 }
				            	 }else {
				            		 if(DateTime.parse(newObservation.getTime()).isAfter(start)&&DateTime.parse(newObservation.getTime()).isBefore(end)) {
				            			 observationList.add(newObservation);	
				            		 }
			            		 }
				            	
			            	 }
		            	 }else {
		            		 double obsValue = Double.parseDouble(csvObservations.get(i).getCsvValue());
			            	 Observation newObservation = new Observation (csvObservations.get(i).getTimeBegin(),obsValue);
			            	 
			            	 if(timeEndColumn!=0) {
			            		 DateTime init_time = new DateTime(newObservation.getTime());
				            	 init_time = init_time.minusSeconds(5);
				            	 Observation initObservation = new Observation (init_time.toString(),0.0);
				            	 double obsValue1 = Double.parseDouble(csvObservations1.get(i).getCsvValue());
				            	 Observation newObservation1 = new Observation (csvObservations1.get(i).getTimeEnd(),obsValue1);

				            	 DateTime end_time = new DateTime(newObservation1.getTime());
				            	 end_time = end_time.plusSeconds(5);
				            	 Observation endObservation = new Observation (end_time.toString(),0.0);
				            	 
				            	 if(DateTime.parse(newObservation.getTime()).isAfter(start)&&DateTime.parse(newObservation.getTime()).isBefore(end)) {
				            		 
				            		 
				            		
				            		 if(!newObservation.getTime().equals(newObservation1.getTime())) {
				            			 observationList.add(initObservation);			            		 
						            	 observationList.add(newObservation);					            	
						            	 observationList.add(newObservation1);				            	
						            	 observationList.add(endObservation);
				            		 }
				            	 }
			            	 }
			            	 else {
			            		 if(DateTime.parse(newObservation.getTime()).isAfter(start)&&DateTime.parse(newObservation.getTime()).isBefore(end)) {
			            			 observationList.add(newObservation);	
			            		 }
			            		 	
			            		 }
				            
				            	
			            	 
		            	 }
		            	 
		            	 
		             }
		             
		             
	        	}    
		             
				
	        	return observationList;
			
			}
		
	}
	
	
	
	
}
