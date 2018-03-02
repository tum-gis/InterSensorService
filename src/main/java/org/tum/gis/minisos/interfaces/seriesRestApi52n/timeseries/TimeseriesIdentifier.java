package org.tum.gis.minisos.interfaces.seriesRestApi52n.timeseries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeseriesIdentifier {

	private TimeseriesIdentifierCollection timeseriesIdentifierCollection = new TimeseriesIdentifierCollection();

	public TimeseriesIdentifier() {
		
	}
	
	public TimeseriesIdentifier(TimeseriesIdentifierCollection timeseriesIdentifierCollection) {
		super();
		this.timeseriesIdentifierCollection = timeseriesIdentifierCollection;
	}

	@JsonProperty("1")
	public TimeseriesIdentifierCollection getTimeseriesIdentifierCollection() {
		return timeseriesIdentifierCollection;
	}

	public void setTimeseriesIdentifierCollection(TimeseriesIdentifierCollection timeseriesIdentifierCollection) {
		this.timeseriesIdentifierCollection = timeseriesIdentifierCollection;
	}
	
	
}
