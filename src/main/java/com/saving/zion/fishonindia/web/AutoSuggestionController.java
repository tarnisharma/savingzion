package com.saving.zion.fishonindia.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saving.zion.fishonindia.dao.Destinations;
import com.saving.zion.fishonindia.dao.DestinationsRepository;

@RestController
public class AutoSuggestionController {

	@Autowired DestinationsRepository destinationsRepository;
	
	@RequestMapping(value = "/getDestinations")
	public List<Destinations> getDestinations(@RequestParam(name="key", required=true, defaultValue="Andaman") String key) {
		return destinationsRepository.findByCityLikeIgnoringCaseOrStateLikeIgnoringCaseOrCountryLikeIgnoringCase(key, key, key);
	}
}
