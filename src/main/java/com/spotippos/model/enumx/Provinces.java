package com.spotippos.model.enumx;

import java.util.ArrayList;
import java.util.List;

public enum Provinces {
	
	GODE("Gode", 0, 1000, 600, 500),
	
	RUJA("Ruja", 400, 1000, 1100, 500),
	
	JABY("Jaby", 1100, 1000, 1400, 500),
	
	SCAVY("Scavy", 0, 500, 600, 0),
	
	GROOLA("Groola", 600, 500, 800, 0),
	
	NOVA("Nova", 800, 500, 1400, 0);
	
	private String name;
	private int ax;
	private int ay;
	private int bx;
	private int by;
	
	private Provinces(String name, int ax, int ay, int bx, int by) {
		this.name = name;
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
	}
	
	public static List<Provinces> getProvincesByPosition(int x, int y){
		List<Provinces> result = new ArrayList<>();
		for (Provinces province : Provinces.values()) {
			if(province.ax <= x &&	province.ay >= y &&
				province.bx >= x && province.by <= y){
				result.add(province);
			}
		}
		return result;
	}
	
	public String getName(){
		return this.name;
	}
}
