package org.tum.gis.minisos.dataSourceConnection;

import java.io.FileReader;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ParseCSVLineByLine {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		
		//@SuppressWarnings("deprecation")
		CSVReader reader = new CSVReaderBuilder (new FileReader("C:/Kanishk/testCSV1.csv")).withSkipLines(1).build();
		//CSVReader reader = new CSVReader(new FileReader("data.csv"), ',' , '"' , 1);
	       
	      //Read CSV line by line and use the string array as you want
	      String[] nextLine;
	      while ((nextLine = reader.readNext()) != null) {
	         if (nextLine != null) {
	            //Verifying the read data here
	            System.out.println(Arrays.toString(nextLine));
	         }
	       }
	      
	}

}
