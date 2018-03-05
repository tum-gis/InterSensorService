package org.tum.gis.minisos.dataSourceConnection.csv;

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
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.dataSource.DataSourceService;
import org.tum.gis.minisos.interfaces.seriesRestApi52n.SeriesRestApiService;
import org.tum.gis.minisos.observation.Observation;
import org.tum.gis.minisos.observation.ObservationListManager;
import org.tum.gis.minisos.observation.ObservationService;
import org.tum.gis.minisos.timeseries.TimeseriesService;
import org.tum.gis.minisos.util.DateTimeComparison;
import org.tum.gis.minisos.util.IdSequenceManager;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

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
		}
		//DataSource dataSource = new DataSource(3,csvConnection);
		
		
		
		//dataSourceService.addDataSource(dataSource);
		
		//insert a new timeseries with unique id
		//timeseriesService.addTimeseries(csvConnection);
		
		//parseCsv(csvConnection);
		//should parse csv and create an ordered list of observation ( time,value for one timeseries id)
		// /timeseries/id/observation should refer to this list (queried by timeseries id and later, dates)
	}
	
	//parseCSV function
	
	//read csv location details, parse csv, create a list of observation 
	
	public void validateCsvConnection(int timeseriesId, CsvConnection csvConnection) throws IOException, ParseException {
		int timeColumn = csvConnection.getTimeColumn();
		int valueColumn = csvConnection.getValueColumn();
		String fileLocation = csvConnection.getFileLocation();
		
		List<Observation> observationList = new ArrayList<>();
		
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
		        	mapping.put(csvHeaderList[valueColumn], "value");
		        	
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
		             
		             if (csvObservations!=null) {
		            	 timeseriesService.timeseriesList.get(timeseriesId-1).setFirstObservation(csvObservations.get(0).getTime());
		            	 timeseriesService.timeseriesList.get(timeseriesId-1).setLastObservation(csvObservations.get(csvObservations.size()-1).getTime());
		             }
		             
		             for (CsvObservation csvObservation : csvObservations) {
		            	 //apply sorting here
		 				observationList.add(csvObservation);
		 				
		 				//Collections.sort(observationList1, new DateTimeComparison());
		 			}
		            
		             
		            
	        	}
	        	
				
	        	
			
			}
		
	}
	
	public List<Observation> parseCsv(int timeseriesId, CsvConnection csvConnection) throws IOException {
		int timeColumn = csvConnection.getTimeColumn();
		int valueColumn = csvConnection.getValueColumn();
		String fileLocation = csvConnection.getFileLocation();
		
		List<Observation> observationList = new ArrayList<>();
		
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
		        	mapping.put(csvHeaderList[valueColumn], "value");
		        	
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
		             
		             
		             
		             for (CsvObservation csvObservation : csvObservations) {
		            	 //apply sorting here
		 				observationList.add(csvObservation);
		 				
		 				//Collections.sort(observationList1, new DateTimeComparison());
		 			}
		            
		             
		            
	        	}
	        	
				
	        	return observationList;
			
			}
		
	}
	
	public List<Observation> parseCsv(int timeseriesId, CsvConnection csvConnection, String startTime, String endTime) throws IOException, ParseException {
		int timeColumn = csvConnection.getTimeColumn();
		int valueColumn = csvConnection.getValueColumn();
		String fileLocation = csvConnection.getFileLocation();
		
		DateTime start = DateTime.parse(startTime);
		DateTime end = DateTime.parse(endTime);
		
		List<Observation> observationList = new ArrayList<>();
	
		
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
		        	mapping.put(csvHeaderList[valueColumn], "value");
		        	
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
		             
		             
		             
		             for (CsvObservation csvObservation : csvObservations) {
		            	 //apply sorting here
		            	 if(DateTime.parse(csvObservation.getTime()).isAfter(start)&&DateTime.parse(csvObservation.getTime()).isBefore(end)) {
		            		 observationList.add(csvObservation);
		            	 }
		            	 
		            	 
		 				
		 				//Collections.sort(observationList1, new DateTimeComparison());
		 			}
		            
		             
		            
	        	}
	        	
				
	        	return observationList;
			
			}
		
	}
	
	
	
	
}
