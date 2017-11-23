package com.saving.zion.fishonindia.dao;

import java.util.Map;
import org.springframework.data.annotation.Id;

public class Listing {

	@Id
	public String id;
	public String name;
	public String listingId;
	public String locationCode;
	public Address address;
	public String operatorId;
	public Map<String, FareAndAvailability> fareAndAvailability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<String, FareAndAvailability> getFareAndAvailability() {
		return fareAndAvailability;
	}

	public void setFareAndAvailability(Map<String, FareAndAvailability> fareAndAvailability) {
		this.fareAndAvailability = fareAndAvailability;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
	@Override
	public String toString() {
		 return String.format(
	                "Listing[id=%s, name='%s', listingId='%s', operatorId='%s', locationCode='%s']",
	                id, name, listingId, operatorId, locationCode);
	}
}
