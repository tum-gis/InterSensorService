package org.tum.gis.interSensorService.dataSourceConnection;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.tum.gis.interSensorService.util.CustomDateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class testDate {

	
	
	public static void main(String[] args) throws IOException, ParseException{
		
		Date d;
		String s;
		DateTime dt;
		//CSVObject o1 = new CSVObject("2017-03-13","3");
		//s="2017-03-13";
		
		Long unixTime = 1529798400000L;
		
		Date d123 = new Date(unixTime);
		
		//s="Tue Jun 12 10:04:08 +0000 2018";
		s = "12.07.18 08:00";
		//System.out.println(CustomDateUtil.convertDate(s));
		d = CustomDateUtil.DateTimePatternEval(s);
		System.out.println(d);
		dt = CustomDateUtil.DateTimeCreator(d123);
		
		//String t = "30000";
		//System.out.println(Double.parseDouble(t));
		DateTime dt1 = new DateTime("2018-06-24T01:59:55.000+02:00");
		dt1 = dt1.plusSeconds(5);
		System.out.println(dt1);
		//System.out.println(dt.minusSeconds(5));
		
		
		
		/*String[] acceptedFormats = {"dd/MM/yyyy","dd/MM/yyyy HH:mm","dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss"};
		Date date1 = DateUtils.parseDate(s, acceptedFormats);*/
		//System.out.println(date1);
		//DateTime dt = DateTime.parse(s);
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date timeComponent = dateFormat.parse(s);
		
		//DateTime dt = new DateTime(timeComponent);
		
		//Date dt123 = CustomDateUtil.DateTimePatternEval(s);
		//Date dt123 = CustomDateUtil.extractTimestampInput(s);
		//DateTime dt1234 = CustomDateUtil.DateTimeCreator(dt123);
		//System.out.println(CustomDateUtil.IsoFormatter(dt123));
		
		
		//System.out.println(dt);
		//System.out.println(o1.getIsoDate());
	}
}
