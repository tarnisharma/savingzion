package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saving.zion.fishonindia.model.ListingFareAndAvailability;
import com.saving.zion.fishonindia.model.Listing;

public interface ListingDetailsRepository extends MongoRepository<Listing, String> {
	public List<ListingFareAndAvailability> findByNameLikeIgnoringCase(String name);
	public List<ListingFareAndAvailability> findByListingId(String listingId);
	public List<ListingFareAndAvailability> findByLocationCodeLikeIgnoringCase(String locationCode);
}
