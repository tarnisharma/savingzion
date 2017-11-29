package com.saving.zion.fishonindia.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saving.zion.fishonindia.dao.DestinationsRepository;
import com.saving.zion.fishonindia.model.Destinations;
import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.service.ListingDetailsAggregator;
import com.saving.zion.fishonindia.service.SearchAggregator;
import com.saving.zion.fishonindia.util.Constants;
import com.saving.zion.fishonindia.util.Timeit;
import com.saving.zion.fishonindia.util.ValidationUtil;

@RestController
public class MainController {

	@Autowired
	DestinationsRepository destinationsRepository;
	@Autowired
	SearchAggregator searchAggregator;
	@Autowired
	ListingDetailsAggregator listingDetailsAggregator;

	@RequestMapping(value = "/getDestinations", method = RequestMethod.GET)
	public Response getDestinations(@RequestParam(name = "key", required = true) String key) {
		Timeit.timeIt("getDestinations");
		System.out.println(key);
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

	@RequestMapping(value = "/getListings", method = RequestMethod.GET)
	public Response getListings(@RequestParam(name = "locCode", required = true) String locCode) {
		try {
			return searchAggregator.getListings(locCode);
		} catch (Exception e) {
			return new Response(Timeit.timeTaken(), 500, null, true,
					Collections.singletonList(Constants.NO_LISTING_FOUND));
		}
	}

	@RequestMapping(value = "/getListingDetails", method = RequestMethod.GET)
	public Response getListingDetails(@RequestParam(name = "listingId", required = true) String listingId) {
		try {
			return listingDetailsAggregator.getListingDetails(listingId);
		} catch (Exception e) {
			return new Response(Timeit.timeTaken(), 500, null, true,
					Collections.singletonList(Constants.NO_LISTING_FOUND));
		}
	}
}
