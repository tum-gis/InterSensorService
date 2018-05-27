package org.tum.gis.minisos.dataSourceConnection;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.tum.gis.minisos.util.CustomDateUtil;


public class testDate {

	
	
	public static void main(String[] args) throws IOException, ParseException{
		
		Date d;
		String s;
		DateTime dt;
		//CSVObject o1 = new CSVObject("2017-03-13","3");
		//s="2017-03-13";
		
		
		
		s="2018-05-27T19:03:00Z";
		//System.out.println(CustomDateUtil.convertDate(s));
		d = CustomDateUtil.DateTimePatternEval(s);
		System.out.println(d);
		dt = CustomDateUtil.DateTimeCreator(d);
		
		System.out.println(dt.toString());
		
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
