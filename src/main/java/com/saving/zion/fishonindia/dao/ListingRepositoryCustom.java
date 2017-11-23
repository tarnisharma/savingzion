package com.saving.zion.fishonindia.dao;

import java.util.List;

public interface ListingRepositoryCustom {

	public  List<Listing> getAvailableListings(String locationCode, int paxCount, String date);
}
