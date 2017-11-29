package com.saving.zion.fishonindia.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Filters {

	@Id
	private String id;
	private Map<Integer, String> species;
	private Map<Integer, String> techniques;
	private Map<Integer, String> listingType;
	private Map<Integer, String> amenities;
	private Map<Integer, String> bestMonths;
	private Map<Integer, String> paymentOps;

	public Map<Integer, String> getSpecies() {
		return species;
	}

	public Map<Integer, String> getTechniques() {
		return techniques;
	}

	public Map<Integer, String> getListingType() {
		return listingType;
	}

	public Map<Integer, String> getAmenities() {
		return amenities;
	}

	public Map<Integer, String> getAvailability_months() {
		return bestMonths;
	}

	public Map<Integer, String> getPaymentOps() {
		return paymentOps;
	}

	public void setSpecies(Map<Integer, String> species) {
		this.species = species;
	}

	public void setTechniques(Map<Integer, String> techniques) {
		this.techniques = techniques;
	}

	public void setListingType(Map<Integer, String> listingType) {
		this.listingType = listingType;
	}

	public void setAmenities(Map<Integer, String> amenities) {
		this.amenities = amenities;
	}

	public void setAvailability_months(Map<Integer, String> availability_months) {
		this.bestMonths = availability_months;
	}

	public void setPaymentOps(Map<Integer, String> paymentOps) {
		this.paymentOps = paymentOps;
	}

	@Override
	public String toString() {
		return "Filters [id=" + id + ", species=" + species + ", techniques=" + techniques + ", listingType="
				+ listingType + ", amenities=" + amenities + ", bestMonths=" + bestMonths + ", paymentOps=" + paymentOps
				+ "]";
	}

}
