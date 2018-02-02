package org.tum.gis.minisos.dataSourceConnection;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


@Service
public class CSVReadAndParseToBean {
	
	
	
	private static final String SAMPLE_CSV_FILE_PATH = "C:/Kanishk/testCSV1.csv";
	
	public static void main(String[] args) throws IOException {
		
		try (
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				){
			CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVObject.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();
			
			List<CSVObject> csvObjects = csvToBean.parse();
			
			for (CSVObject csvObject : csvObjects) {
				System.out.println("Original : " + csvObject.getIsoDate());
				
				System.out.println("Value : " + csvObject.getValue());
				
			}
			
		}
		
	}
	
	public List<CSVObject> parseCSV() throws IOException {
			
			try (
					Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
					){
				CsvToBean csvToBean = new CsvToBeanBuilder(reader)
	                    .withType(CSVObject.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .withSkipLines(1)
	                    .build();
				
				 List<CSVObject> csvObjects = csvToBean.parse();
				 return csvObjects;
				
				
				
			}
			
		}
	
	public List<CSVObject> getObservation() throws IOException{
		return parseCSV();
	}


}
