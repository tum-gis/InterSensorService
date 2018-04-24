/**
 * 
 */
package org.tum.gis.minisos.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kchaturvedi
 *
 */
public class IdSequenceManager {
	
	static AtomicInteger dataSourceSeq = new AtomicInteger();
	static AtomicInteger timeseriesSeq = new AtomicInteger();
	
	static AtomicInteger observationSeq = new AtomicInteger();
	
	
	public static int DataSourceSequence() {
		return dataSourceSeq.incrementAndGet();
	}
	
	public static int TimeseriesSourceSequence() {
		return timeseriesSeq.incrementAndGet();
	}
	
	public static int ObservationSequence() {
		return observationSeq.incrementAndGet();
	}

}
