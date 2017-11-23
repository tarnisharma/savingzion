package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListingRepository extends MongoRepository<Listing, String> {
	public List<Listing> findByName(String name);
	public List<Listing> findByListingId(String listingId);
	public List<Listing> findByLocationCode(String locationCode);
}
