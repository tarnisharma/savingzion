package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saving.zion.fishonindia.model.Destinations;

public interface DestinationsRepository extends MongoRepository<Destinations,String>{

	public List<Destinations> findByCityIgnoringCase(String city);
	public List<Destinations> findByStateIgnoringCase(String state);
	public List<Destinations> findByCountryIgnoringCase(String country);
	public List<Destinations> findByCityStartingWithIgnoringCase(String city);
	public List<Destinations> findByStateStartingWithIgnoringCase(String state);
	public List<Destinations> findByCountryStartingWithIgnoringCase(String country);
	public List<Destinations> findByCityStartingWithIgnoringCaseOrStateStartingWithIgnoringCaseOrCountryStartingWithIgnoringCase(String city, String state, String country);
}
