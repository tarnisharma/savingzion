package com.saving.zion.fishonindia.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.saving.zion.fishonindia.dao.DestinationsRepository;
import com.saving.zion.fishonindia.model.Destinations;
import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.util.Constants;
import com.saving.zion.fishonindia.util.Timeit;
import com.saving.zion.fishonindia.util.ValidationUtil;

@Service
public class DestinationsService {
	@Autowired
	DestinationsRepository destinationsRepository;

	@Cacheable(value = "destinationsCache", key = "#key", condition = "#result.resCode == 200", sync = true)
	public Response getDestinations(String key) {
		Timeit.timeIt("Inside Destinations");
		try {
			List<Destinations> destinations = destinationsRepository
					.findByCityStartingWithIgnoringCaseOrStateStartingWithIgnoringCaseOrCountryStartingWithIgnoringCase(
							key, key, key);
			if (ValidationUtil.isNullOrEmpty(destinations)) {
				return new Response(Timeit.timeTaken(), 204, null, true,
						Collections.singletonList(Constants.NO_MATCH_FOUND));
			}
			return new Response(Timeit.timeTaken(), 200, destinations);
		} catch (Exception e) {
			return new Response(Timeit.timeTaken(), 500, null, true,
					Collections.singletonList(Constants.NO_MATCH_FOUND));
		}
	}
}
