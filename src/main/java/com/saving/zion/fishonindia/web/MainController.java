package com.saving.zion.fishonindia.web;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.service.DestinationsService;
import com.saving.zion.fishonindia.service.ListingDetailsAggregator;
import com.saving.zion.fishonindia.service.SearchAggregator;
import com.saving.zion.fishonindia.util.Constants;
import com.saving.zion.fishonindia.util.Timeit;

@RestController
public class MainController {

	@Autowired
	DestinationsService destinationsService;
	@Autowired
	SearchAggregator searchAggregator;
	@Autowired
	ListingDetailsAggregator listingDetailsAggregator;

	@RequestMapping(value = "/getDestinations", method = RequestMethod.GET)
	public Response getDestinations(@RequestParam(name = "key", required = true) String key) {
		return destinationsService.getDestinations(key);
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
