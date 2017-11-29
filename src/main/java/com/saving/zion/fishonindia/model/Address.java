package com.saving.zion.fishonindia.model;

import org.springframework.data.annotation.Id;

public class Address {
	
	@Id
	private String id;
	
	private String city;
	private String state;
	private String country;
	private String area;
	private String fullAddress;
	private float lat;
	private float lon;
	
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public float getLatitude() {
		return lat;
	}
	public float getLongitude() {
		return lon;
	}
	public void setLatitude(float latitude) {
		this.lat = latitude;
	}
	public void setLongitude(float longitude) {
		this.lon = longitude;
	}
}
