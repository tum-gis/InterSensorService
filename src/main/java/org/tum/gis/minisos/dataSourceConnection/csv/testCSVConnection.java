package org.tum.gis.minisos.dataSourceConnection.csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tum.gis.minisos.dataSource.DataSource;
import org.tum.gis.minisos.observation.ObservationService;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


public class testCSVConnection {

	//private static final String SAMPLE_CSV_FILE_PATH = "C:/Kanishk/testCSV1.csv";
	
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

	
	/*private ObservationService observationService;
	
	public static void main(String[] args) throws IOException {
		String a = "C:/Kanishk/testCSV1.csv";
		System.out.println(a);
		csvConnectionService.parseCsv(a);
		//csvConnectionService.parseCsv("C:/Kanishk/testCSV1.csv");
		System.out.println("Success");
	}*/
}
