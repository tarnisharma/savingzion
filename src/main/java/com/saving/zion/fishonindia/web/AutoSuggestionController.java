package com.saving.zion.fishonindia.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saving.zion.fishonindia.Destinations;
import com.saving.zion.fishonindia.DestinationsRepository;

@RestController
public class AutoSuggestionController {

	@Autowired DestinationsRepository destinationsRepository;
	
	@RequestMapping(value = "/getDestinations")
	public List<Destinations> getDestinations(@RequestParam(name="key", required=true, defaultValue="Andaman") String key) {
		List<Destinations> cities = destinationsRepository.findByCityLike(key);
		List<Destinations> states = destinationsRepository.findByStateLike(key);
		List<Destinations> countries = destinationsRepository.findByCountryLike(key);
		
		List<Destinations> result =  new ArrayList<Destinations>();
		result.addAll(cities);
		result.addAll(states);
		result.addAll(countries);
		return result;
	}
}
