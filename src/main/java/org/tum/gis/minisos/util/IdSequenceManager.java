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
	
	AtomicInteger dataSourceSeq = new AtomicInteger();
	AtomicInteger timeseriesSeq = new AtomicInteger();
	
	
	public int DataSourceSequence() {
		return dataSourceSeq.incrementAndGet();
	}
	
	public int TimeseriesSourceSequence() {
		return timeseriesSeq.incrementAndGet();
	}

}
