package com.saving.zion.fishonindia;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.saving.zion.fishonindia.dao.DestinationsRepository;
import com.saving.zion.fishonindia.dao.FiltersRepository;
import com.saving.zion.fishonindia.dao.ListingRepository;
import com.saving.zion.fishonindia.model.Destinations;
import com.saving.zion.fishonindia.model.Listing;
import com.saving.zion.fishonindia.model.RequestSubmission;
import com.saving.zion.fishonindia.model.Response;
import com.saving.zion.fishonindia.model.UserDetails;
import com.saving.zion.fishonindia.service.ListingDetailsAggregator;
import com.saving.zion.fishonindia.service.SearchAggregator;
import com.saving.zion.fishonindia.service.SubmitRequestService;
import com.saving.zion.fishonindia.web.MainController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FishOnIndiaApplicationTests {

	@Autowired
	MainController autoSuggestionController;

	@Autowired
	DestinationsRepository destinationsRepository;

	@Autowired
	ListingRepository listingRepository;

	@Autowired
	FiltersRepository filtersRepository;
	@Autowired
	SearchAggregator searchAggregator;
	@Autowired
	ListingDetailsAggregator listingDetailsAggregator;
	@Autowired SubmitRequestService submitRequestService;


	// @Test
	public void contextLoads() {
	}

	// @Test
	public void destinationsRepositoryTest() {
		Destinations andamans, goa, srinagar, pancheshwar, akhnoor;
		destinationsRepository.deleteAll();
		goa = destinationsRepository.save(new Destinations("Morijim", "Goa", "India", "GOA-IN"));
		andamans = destinationsRepository.save(new Destinations("Port Blair", "Andamans", "India", "ANDM-IN"));
		srinagar = destinationsRepository.save(new Destinations("Srinagar", "J&K", "India", "SXR-IN"));
		pancheshwar = destinationsRepository.save(new Destinations("Pancheshwar", "Uttarakhand", "India", "PNCH-IN"));
		akhnoor = destinationsRepository.save(new Destinations("Akhnoor", "J&K", "India", "AKH-IN"));
		akhnoor = destinationsRepository.save(new Destinations("Andagreat", "J&K", "India", "ANDG-IN"));

		List<Destinations> result = destinationsRepository.findByCityStartingWithIgnoringCase("mor");
		assertThat(result).hasSize(1).extracting("city").contains("Morijim");

		result = destinationsRepository.findByStateIgnoringCase("J&K");
		assertThat(result).hasSize(3).extracting("state").contains("J&K");

		result = destinationsRepository
				.findByCityStartingWithIgnoringCaseOrStateStartingWithIgnoringCaseOrCountryStartingWithIgnoringCase(
						"anda", "anda", "anda");
		System.err.println(result.size());
		for (Destinations d : result) {
			System.err.println(d.toString());
		}
	}

	// @Test
	public void autosuggestion() {
		Response result = autoSuggestionController.getDestinations("an");
		System.out.println(result.toString());
	}

	// @Test
	public void listingRepositoryTest() {
		List<Listing> result = listingRepository.findByLocationCode("ANDM-IN");
		for (Listing d : result) {
			System.err.println(d.toString());
		}
	}

	// @Test
	public void testDate() {
		String fromDate = "2017-12-01";
		ISO8601DateFormat outputFormatter = new ISO8601DateFormat();
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate;
		try {
			inputDate = inputFormatter.parse(fromDate);
			String outputDate = outputFormatter.format(inputDate);
			System.out.println(outputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//@Test
	public void testFilters() {
		System.out.println(filtersRepository.findAll().toString());
	}
	
	//@Test
	public void getListingsTest() {
		System.out.println(searchAggregator.getListings("ANDM-IN"));
	}
	
	//@Test
	public void getListingDetailsTest() {
		System.out.println(listingRepository.findByListingId("3").toString());
		System.out.println(listingDetailsAggregator.getListingDetails("3"));
	}
	
	@Test
	public void submitRequestTest() {
		RequestSubmission req = new RequestSubmission();
		req.setComments("djkfvkuahf");
		req.setInterests("jkhfuhsf");
		req.setDates("skjdhfkahf");
		req.setListingId("3");
		req.setLocationCode("ANDM-IN");
		req.setName("kjhfhrf");
		req.setPaxCount(3);
		UserDetails user = new UserDetails();
		user.setContactNumber("kjdfef");
		user.setEmailId("jkfhhf");
		user.setName("hjfgfr");
		req.setUserDetails(user);
		System.out.println(submitRequestService.submitRequest(req));
	}

}
