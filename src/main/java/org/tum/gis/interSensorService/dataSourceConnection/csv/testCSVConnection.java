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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.interSensorService.dataSource.DataSource;
import org.tum.gis.interSensorService.dataSource.DataSourceService;
import org.tum.gis.interSensorService.observation.ObservationService;
import org.tum.gis.interSensorService.util.IdSequenceManager;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


public class testCSVConnection {

	private static final String SAMPLE_CSV_FILE_PATH = "C:/Kanishk/testCSV1.csv";
	
	private static DataSourceService dataSourceService;
	
	/*public static void main(String[] args) throws IOException {
		try(
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				){
			CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvObservation.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();
			
			List<CsvObservation> csvObservations = csvToBean.parse();
			
			for (CsvObservation csvObservation : csvObservations) {
				System.out.println(csvObservation.getDoubleValue() );
			}
			
		}
	}*/

	
    public static void main(String[] args) throws IOException, ParseException, CsvRequiredFieldEmptyException, InstantiationException, IllegalAccessException, IllegalStateException {
        
    	BufferedReader br = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH));    
    	Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        	//CSVReader reader = new CSVReader(new FileReader(SAMPLE_CSV_FILE_PATH));
        	//CSVReader csvReader = new CSVReader(reader);
        
        	
        	
        	
        	Map<String, String> mapping = new HashMap<String, String>();
        	mapping.put("1", "timeseriesId");
        	mapping.put("time", "time");
        	mapping.put("value", "value");
        	
        	/*ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(CsvObservation.class);
            String[] memberFieldsToBindTo = {"time", "value"};
            strategy.setColumnMapping(memberFieldsToBindTo);*/
        	//System.out.println(strategy.getColumnName(0));
        	HeaderColumnNameTranslateMappingStrategy<CsvObservation> strategy = new HeaderColumnNameTranslateMappingStrategy<CsvObservation>();
        	strategy.setType(CsvObservation.class);
        	strategy.setColumnMapping(mapping);
        	//strategy.captureHeader(csvReader);
        	//strategy.generateHeader();
        	
        	String header = br.readLine();
        	if (header != null) {
        		String[] columns = header.split(";");
        		System.out.println(columns.length);
        	}
        	System.out.println(br.readLine());
        	
        	 
        	 
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
            		.withType(CsvObservation.class)
                    .withMappingStrategy(strategy)
                    //.withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();
            
            //csvToBean.setMappingStrategy(strategy);
            
           
           
            List<CsvObservation> myUsers = csvToBean.parse();
            
           // AtomicInteger seq = new AtomicInteger();
            
            //@SequenceGenerator(name="idGen", sequenceName="idSeq")
           // int nextVal;
            
            //for (int i=0;i<10;i++) {
            //	nextVal = seq.getAndIncrement();
                
             //   System.out.println(nextVal);
            //}
            

           // System.out.println(myUsers);
            
            
           /* for (CsvObservation myUser : myUsers) {
            	System.out.println("Name : " + myUser.getTimeseriesId());
            	System.out.println("Name : " + myUser.getTime());
                System.out.println("Email : " + myUser.getValue());               
                System.out.println("---------------------------");
            }*/
    	/*int dataSourceId = IdSequenceManager.DataSourceSequence();
    	System.out.println(dataSourceId);
    	
    	List<String> abc = new ArrayList<>(Arrays.asList("a","b","c","d"));
    	int flag = 0;
    	for(int i=0;i<abc.size();i++) {
    		if(abc.get(i)=="cd") {
    			flag = 1;
    			break;
    		}
    		
    	}
    	
    	if (flag==1) {
    		System.out.println("Success");
    	}else {
    		System.out.println("failure");
    	}*/
    	
    	
    }
}
