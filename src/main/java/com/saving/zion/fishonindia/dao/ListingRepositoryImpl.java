package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class ListingRepositoryImpl implements ListingRepositoryCustom {

	@Autowired MongoTemplate mongoTemplate;
	
	@Override
	public List<Listing> getAvailableListings(String locationCode, int paxCount, String date) {
		
		return null;
	}

}
