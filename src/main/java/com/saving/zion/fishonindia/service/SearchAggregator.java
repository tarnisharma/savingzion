package com.saving.zion.fishonindia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saving.zion.fishonindia.dao.FiltersRepository;
import com.saving.zion.fishonindia.dao.ListingRepository;
import com.saving.zion.fishonindia.model.Filters;
import com.saving.zion.fishonindia.model.Listing;
import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.util.Constants;
import com.saving.zion.fishonindia.util.Timeit;
import com.saving.zion.fishonindia.util.ValidationUtil;

@Service
public class SearchAggregator {

	@Autowired
	ListingRepository listingRepository;
	@Autowired
	FiltersRepository filtersRepository;

	public Response getListings(String locCode) {
		Timeit.timeIt("getListings");
		try {
			if (filtersRepository.count() > 0) {
				Filters filters = filtersRepository.findAll().get(0);
				List<Listing> listings = listingRepository.findByLocationCodeIgnoringCase(locCode);
				if (ValidationUtil.isNullOrEmpty(listings))
					return new Response(Timeit.timeTaken(), 204, null, true,
							Collections.singletonList(Constants.NO_LISTING_FOUND));
				List<Object> responseJsonArray = new ArrayList<Object>();
				Map<String,Object> result = new HashMap<String,Object>();
				result.put("resultCount", listings.size());
				result.put("listings", listings);
				result.put("filters",filters);
				responseJsonArray.add(result);
				return new Response(Timeit.timeTaken(), 200, responseJsonArray);
			}
			return new Response(Timeit.timeTaken(), 500, null, true,
					Collections.singletonList(Constants.FILTER_ERROR));
		} catch (Exception e) {
			return new Response(Timeit.timeTaken(), 500, null, true,
					Collections.singletonList(Constants.NO_LISTING_FOUND));
		}
	}
}
