package com.saving.zion.fishonindia.dao;

import java.util.List;

import com.saving.zion.fishonindia.model.ListingFareAndAvailability;

public interface ListingRepositoryCustom {

	public  List<ListingFareAndAvailability> getAvailableListings(String locationCode, int paxCount, String fromDate, int days);
}
