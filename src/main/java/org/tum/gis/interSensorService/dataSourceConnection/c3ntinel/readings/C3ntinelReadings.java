package org.tum.gis.interSensorService.dataSourceConnection.c3ntinel.readings;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C3ntinelReadings {

	@JsonProperty("summaryInfo")
	private SummaryInfo summaryInfo;
	
	@JsonProperty("units")
	private Units units;
	
	private String resolution;
	
	@JsonProperty("readings")
	private List<Reading> readings;

	public C3ntinelReadings() {
		
	}

	public C3ntinelReadings(SummaryInfo summaryInfo, Units units, String resolution, List<Reading> readings) {
		super();
		this.summaryInfo = summaryInfo;
		this.units = units;
		this.resolution = resolution;
		this.readings = readings;
	}

	public SummaryInfo getSummaryInfo() {
		return summaryInfo;
	}

	public void setSummaryInfo(SummaryInfo summaryInfo) {
		this.summaryInfo = summaryInfo;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public List<Reading> getReadings() {
		return readings;
	}

	public void setReadings(List<Reading> readings) {
		this.readings = readings;
	}
	
	
	
	
}
