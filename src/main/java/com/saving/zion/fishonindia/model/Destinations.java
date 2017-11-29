package com.saving.zion.fishonindia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "destinations_master_list")
public class Destinations {

	@Id
	private String id;
	
	private String city;
	private String state;
	private String country;
	private String locationCode;
	
	public Destinations() {}
	public Destinations(String city, String state, String country, String locationCode) {
		this.city = city;
		this.state = state;
		this.country = country;
		this.locationCode = locationCode;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	@Override
	public String toString() {
		 return String.format(
	                "Destination[id=%s, city='%s', state='%s', country='%s', locationCode='%s']",
	                id, city, state, country, locationCode);
	}

}
