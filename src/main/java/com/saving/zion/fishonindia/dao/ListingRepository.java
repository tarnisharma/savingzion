package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListingRepository extends MongoRepository<Listing, String> , ListingRepositoryCustom{
	public List<Listing> findByNameLikeIgnoringCase(String name);
	public List<Listing> findByListingId(String listingId);
	public List<Listing> findByLocationCodeLikeIgnoringCase(String locationCode);
}
