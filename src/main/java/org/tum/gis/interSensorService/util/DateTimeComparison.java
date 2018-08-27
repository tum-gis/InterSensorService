/**
 * 
 */
package org.tum.gis.interSensorService.util;

import java.text.ParseException;
import java.util.Comparator;

import org.joda.time.DateTime;
import org.tum.gis.interSensorService.observation.Observation;

/**
 * @author kchaturvedi
 *
 */
public class DateTimeComparison implements Comparator<Observation> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Observation o1, Observation o2) {
		// TODO Auto-generated method stub
		try {
			return DateTime.parse(o1.getTime()).compareTo(DateTime.parse(o2.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
