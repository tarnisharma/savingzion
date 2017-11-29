package com.saving.zion.fishonindia.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class MiscDetails {
	@Id
	private Integer id;
	private List<Integer> species;
	private List<Integer> techniques;
	private int listingType;
	private List<Integer> amenities;
	private List<Integer> bestMonths;
	private List<Integer> paymentOps;
	private List<String> tags;

	public List<Integer> getSpecies() {
		return species;
	}

	public List<Integer> getTechniques() {
		return techniques;
	}

	public int getListingType() {
		return listingType;
	}

	public List<Integer> getAmenities() {
		return amenities;
	}

	public List<Integer> getAvailability_months() {
		return bestMonths;
	}

	public List<Integer> getPaymentOps() {
		return paymentOps;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setSpecies(List<Integer> species) {
		this.species = species;
	}

	public void setTechniques(List<Integer> techniques) {
		this.techniques = techniques;
	}

	public void setListingType(int listingType) {
		this.listingType = listingType;
	}

	public void setAmenities(List<Integer> amenities) {
		this.amenities = amenities;
	}

	public void setAvailability_months(List<Integer> availability_months) {
		this.bestMonths = availability_months;
	}

	public void setPaymentOps(List<Integer> paymentOps) {
		this.paymentOps = paymentOps;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
