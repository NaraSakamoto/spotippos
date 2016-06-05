package com.spotippos.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("id")
public class Realty implements Serializable{
	
	private static final long serialVersionUID = -1625637331290768849L;

	private int id;
	@NotNull
	private int x;
	@NotNull
	private int y;
	@NotNull
	private String title;
	@NotNull
	private long price;
	@NotNull
	private String description;
	@NotNull
	private int beds;
	@NotNull
	private int baths;
	@NotNull
	private int squareMeters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public int getSquareMeters() {
		return squareMeters;
	}

	public void setSquareMeters(int squareMeters) {
		this.squareMeters = squareMeters;
	}
}
