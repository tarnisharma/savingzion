package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinationsRepository extends MongoRepository<Destinations,String>{

	public List<Destinations> findByCityIgnoringCase(String city);
	public List<Destinations> findByStateIgnoringCase(String state);
	public List<Destinations> findByCountryIgnoringCase(String country);
	public List<Destinations> findByCityLikeIgnoringCase(String city);
	public List<Destinations> findByStateLikeIgnoringCase(String state);
	public List<Destinations> findByCountryLikeIgnoringCase(String country);
	public List<Destinations> findByCityLikeIgnoringCaseOrStateLikeIgnoringCaseOrCountryLikeIgnoringCase(String city, String state, String country);
}
