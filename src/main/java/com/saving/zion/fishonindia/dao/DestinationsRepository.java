package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinationsRepository extends MongoRepository<Destinations,String>{

	public List<Destinations> findByCity(String city);
	public List<Destinations> findByState(String state);
	public List<Destinations> findByCountry(String country);
	public List<Destinations> findByCityLike(String city);
	public List<Destinations> findByStateLike(String state);
	public List<Destinations> findByCountryLike(String country);
}