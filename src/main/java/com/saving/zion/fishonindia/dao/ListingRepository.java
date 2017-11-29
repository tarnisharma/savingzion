package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.saving.zion.fishonindia.model.Listing;

public interface ListingRepository extends MongoRepository<Listing, String> , ListingRepositoryCustom{
	public List<Listing> findByNameStartingWithIgnoringCase(String name);
	public Listing findByListingId(String listingId);
	public List<Listing> findByLocationCodeStartingWithIgnoringCase(String locationCode);
	public List<Listing> findByLocationCode(String locationCode);
	public List<Listing> findByLocationCodeIgnoringCase(String locationCode);
	//@Query("fareAndAvailability : {'$elemMatch' : { avlDate : { '$eq' : new ISODate(?0) },availableCapacity : {'$gte' : ?0}}}")
	//public List<Listing> findByLocationCodeStartingWithAndFareAvailability(String locationCode);
}
