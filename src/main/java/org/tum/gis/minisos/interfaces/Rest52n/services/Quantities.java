/**
 * 
 */
package org.tum.gis.minisos.interfaces.Rest52n.services;

/**
 * @author kchaturvedi
 *
 */
public class Quantities {

	private int procedures = 1;
	private int categories = 1;
	private int phenomena = 1;
	private int datasets = 1;
	private int platforms = 1;
	private int features = 1;
	private int offerings = 1;
	
	public Quantities(){
		
	}
	
	public Quantities(int procedures, int categories, int phenomena, int datasets, int platforms, int features,
			int offerings) {
		super();
		this.procedures = procedures;
		this.categories = categories;
		this.phenomena = phenomena;
		this.datasets = datasets;
		this.platforms = platforms;
		this.features = features;
		this.offerings = offerings;
	}

	public int getProcedures() {
		return procedures;
	}

	public void setProcedures(int procedures) {
		this.procedures = procedures;
	}

	public int getCategories() {
		return categories;
	}

	public void setCategories(int categories) {
		this.categories = categories;
	}

	public int getPhenomena() {
		return phenomena;
	}

	public void setPhenomena(int phenomena) {
		this.phenomena = phenomena;
	}

	public int getDatasets() {
		return datasets;
	}

	public void setDatasets(int datasets) {
		this.datasets = datasets;
	}

	public int getPlatforms() {
		return platforms;
	}

	public void setPlatforms(int platforms) {
		this.platforms = platforms;
	}

	public int getFeatures() {
		return features;
	}

	public void setFeatures(int features) {
		this.features = features;
	}

	public int getOfferings() {
		return offerings;
	}

	public void setOfferings(int offerings) {
		this.offerings = offerings;
	}
	
	
	
}
