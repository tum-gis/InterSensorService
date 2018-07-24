package org.tum.gis.minisos.dataSourceConnection.c3ntinel.readings;

public class SummaryInfo {

	private int expectedReadings;
	private int totalReadings;
	private int missingReadings;
	private int filteredReadings;
	private double sum;
	private Reading minReading;
	private Reading maxReading;
	private double standardDeviation;
	private double mean;
	
	public SummaryInfo() {
		
	}
	
	public SummaryInfo(int expectedReadings, int totalReadings, int missingReadings, int filteredReadings, double sum,
			Reading minReading, Reading maxReading, double standardDeviation, double mean) {
		super();
		this.expectedReadings = expectedReadings;
		this.totalReadings = totalReadings;
		this.missingReadings = missingReadings;
		this.filteredReadings = filteredReadings;
		this.sum = sum;
		this.minReading = minReading;
		this.maxReading = maxReading;
		this.standardDeviation = standardDeviation;
		this.mean = mean;
	}
	public int getExpectedReadings() {
		return expectedReadings;
	}
	public void setExpectedReadings(int expectedReadings) {
		this.expectedReadings = expectedReadings;
	}
	public int getTotalReadings() {
		return totalReadings;
	}
	public void setTotalReadings(int totalReadings) {
		this.totalReadings = totalReadings;
	}
	public int getMissingReadings() {
		return missingReadings;
	}
	public void setMissingReadings(int missingReadings) {
		this.missingReadings = missingReadings;
	}
	public int getFilteredReadings() {
		return filteredReadings;
	}
	public void setFilteredReadings(int filteredReadings) {
		this.filteredReadings = filteredReadings;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public Reading getMinReading() {
		return minReading;
	}
	public void setMinReading(Reading minReading) {
		this.minReading = minReading;
	}
	public Reading getMaxReading() {
		return maxReading;
	}
	public void setMaxReading(Reading maxReading) {
		this.maxReading = maxReading;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	
	
	
}
