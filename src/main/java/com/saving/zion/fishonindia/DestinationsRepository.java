package com.saving.zion.fishonindia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface DestinationsRepository extends MongoRepository<Destinations,String>{

	public List<Destinations> findByCity(String city);
	public List<Destinations> findByState(String state);
	public List<Destinations> findByCountry(String country);
}
