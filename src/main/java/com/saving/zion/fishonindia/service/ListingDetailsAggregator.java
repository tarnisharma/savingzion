package com.saving.zion.fishonindia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saving.zion.fishonindia.dao.ContentRepository;
import com.saving.zion.fishonindia.dao.FiltersRepository;
import com.saving.zion.fishonindia.dao.ListingRepository;
import com.saving.zion.fishonindia.model.Content;
import com.saving.zion.fishonindia.model.Filters;
import com.saving.zion.fishonindia.model.Listing;
import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.util.Constants;
import com.saving.zion.fishonindia.util.Timeit;

@Service
public class ListingDetailsAggregator {
	@Autowired
	ListingRepository listingRepository;
	@Autowired
	FiltersRepository filtersRepository;
	@Autowired
	ContentRepository contentRepository;

	public Response getListingDetails(String listingId) {
		Timeit.timeIt("getListingDetails");
		try {
			if (filtersRepository.count() > 0) {
				Filters filters = filtersRepository.findAll().get(0);
				Listing listing = listingRepository.findByListingId(listingId);
				if(listing == null)
					return new Response(Timeit.timeTaken(), 204, null, true,
							Collections.singletonList(Constants.NO_LISTING_FOUND));
				Content content = contentRepository.findByListingId(listingId);
				if(content == null)
					return new Response(Timeit.timeTaken(), 500, null, true,
							Collections.singletonList(Constants.CONTENT_ERROR));
				List<Object> responseJsonArray = new ArrayList<Object>();
				Map<String, Object> result = new HashMap<String, Object>();
				result.put("listing", listing);
				result.put("filters", filters);
				result.put("content", content);
				responseJsonArray.add(result);
				return new Response(Timeit.timeTaken(), 200, responseJsonArray);
			}
			return new Response(Timeit.timeTaken(), 500, null, true, Collections.singletonList(Constants.FILTER_ERROR));
		} catch (Exception e) {
			return new Response(Timeit.timeTaken(), 500, null, true,
					Collections.singletonList(Constants.NO_LISTING_FOUND));
		}
	}
}
