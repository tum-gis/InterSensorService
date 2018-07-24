package org.tum.gis.minisos.util;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.expression.ParseException;

public class CustomDateUtil {

	public static Date DateTimePatternEval(String str) throws java.text.ParseException{
		String[] acceptedFormats = {
				"EEE MMM dd HH:mm:ss ZZZZZ yyyy",
				"dd/MM/yyyy",
				"dd/MM/yyyy HH:mm",
				"dd/MM/yyyy HH:mm:ss", 
				"yyyy-MM-dd",
				"yyyy-MM-dd HH:mm",
				"yyyy-MM-dd HH:mm:ss",
				"yyyy-MM-dd'T'HH:mm:ss",
				"yyyy-MM-dd'T'HH:mm:ssXXX",
				"yyyy-MM-dd'T'HH:mm:ss'Z'",
				"yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
				"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
				"dd.MM.yy HH:mm"
				};
		
		
		try {
			return DateUtils.parseDate(str, Locale.ENGLISH, acceptedFormats);
		} catch (ParseException pe) {
			System.err.println("DateTimePatternEval: Could not parse date: " + str);
		}
		return null;
	}
	
	public static DateTime DateTimeCreator(Date dt) throws java.text.ParseException  {
		
		try {
			//Date dateValidity = DateTimePatternEval(str);
			DateTime validDate = new DateTime(dt);
			return validDate;
		} catch (ParseException pe) {
			System.err.println("DateTimeCreator: Could not parse date: " + dt);
		}
		
		return null;
	}
	
	public static String IsoFormatter(DateTime dt) {
		org.joda.time.format.DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
		String str = fmt.print(dt);
		return str;
	}
	
	public static long UnixTimeCreator(String time) {
		DateTime dt = DateTime.parse(time);
		return dt.getMillis();
	}
	
	public static String UnixToDateConvertor(Long unixTime) throws java.text.ParseException {
		Date date = new Date (unixTime);
		DateTime dt = DateTimeCreator(date);
		return dt.toString();
		
	}
	
}





