package com.saving.zion.fishonindia.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Listing {
	@Id
	private String id;
	private String name;
	private String listingId;
	private String locationCode;
	private Address address;
	private String operatorId;
	private List<String> contact;
	private Float rating;
	private List<String> content;
	private MiscDetails filters;
	private List<FareAndAvailability> fareAndAvailability;

	public String getName() {
		return name;
	}

	public String getListingId() {
		return listingId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public Address getAddress() {
		return address;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public List<String> getContact() {
		return contact;
	}

	public Float getRating() {
		return rating;
	}

	public List<String> getContent() {
		return content;
	}

	public MiscDetails getFilters() {
		return filters;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public void setContact(List<String> contact) {
		this.contact = contact;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public void setFilters(MiscDetails filters) {
		this.filters = filters;
	}

	public List<FareAndAvailability> getFareAndAvailability() {
		return fareAndAvailability;
	}

	public void setFareAndAvailability(List<FareAndAvailability> fareAndAvailability) {
		this.fareAndAvailability = fareAndAvailability;
	}
}
