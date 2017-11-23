package com.saving.zion.fishonindia;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "destinations_master_list")
public class Destinations {

	@Id
	public String id;
	
	public String city;
	public String state;
	public String country;
	public String locationCode;
	
	public Destinations() {}
	public Destinations(String city, String state, String country, String locationCode) {
		this.city = city;
		this.state = state;
		this.country = country;
		this.locationCode = locationCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

}
