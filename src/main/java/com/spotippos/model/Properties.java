package com.spotippos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

	@JsonProperty("totalProperties")
	private int totalProperties;
	
	@JsonProperty("properties")
	private List<Realty> properties;

	public int getTotalProperties() {
		return totalProperties;
	}

	public List<Realty> getProperties() {
		return properties;
	}

	public void setProperties(List<Realty> properties) {
		this.properties = properties;
		this.totalProperties = properties.size();
	}
	
	
}
