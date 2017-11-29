package com.saving.zion.fishonindia.model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class ListingFareAndAvailability {

	@Id
	private String id;
	private String listingId;
	private List<FareAndAvailability> fareAndAvailability;

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public List<FareAndAvailability> getFareAndAvailability() {
		return fareAndAvailability;
	}

	public void setFareAndAvailability(List<FareAndAvailability> fareAndAvailability) {
		this.fareAndAvailability = fareAndAvailability;
	}
}
