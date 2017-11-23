package com.saving.zion.fishonindia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saving.zion.fishonindia.dao.Destinations;
import com.saving.zion.fishonindia.dao.DestinationsRepository;
import com.saving.zion.fishonindia.dao.Listing;
import com.saving.zion.fishonindia.dao.ListingRepository;
import com.saving.zion.fishonindia.web.AutoSuggestionController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FishOnIndiaApplicationTests {

	@Autowired
	AutoSuggestionController autoSuggestionController;

	@Autowired
	DestinationsRepository destinationsRepository;
	
	@Autowired
	ListingRepository listingRepository;

	@Test
	public void contextLoads() {
	}

	//@Test
	public void destinationsRepositoryTest() {
		Destinations andamans, goa, srinagar, pancheshwar,akhnoor;
		destinationsRepository.deleteAll();
		goa = destinationsRepository.save(new Destinations("Morijim", "Goa", "India", "GOA-IN"));
		andamans = destinationsRepository.save(new Destinations("Port Blair", "Andamans", "India", "ANDM-IN"));
		srinagar = destinationsRepository.save(new Destinations("Srinagar", "J&K", "India", "SXR-IN"));
		pancheshwar = destinationsRepository.save(new Destinations("Pancheshwar", "Uttarakhand", "India", "PNCH-IN"));
		akhnoor = destinationsRepository.save(new Destinations("Akhnoor", "J&K", "India", "AKH-IN"));
		akhnoor = destinationsRepository.save(new Destinations("Andagreat", "J&K", "India", "ANDG-IN"));

		List<Destinations> result = destinationsRepository.findByCityLikeIgnoringCase("mor");
		assertThat(result).hasSize(1).extracting("city").contains("Morijim");

		result = destinationsRepository.findByStateIgnoringCase("J&K");
		assertThat(result).hasSize(3).extracting("state").contains("J&K");

		result = destinationsRepository.findByCityLikeIgnoringCaseOrStateLikeIgnoringCaseOrCountryLikeIgnoringCase("anda","anda","anda");
		System.err.println(result.size());
		for (Destinations d : result) {
			System.err.println(d.toString());
		}
	}

	@Test
	public void autosuggestion() {
		List<Destinations> result = autoSuggestionController.getDestinations("and");
		for (Destinations d : result) {
			System.out.println(d.toString());
		}

	}

	//@Test
	public void listingRepositoryTest() {
		List<Listing> result = listingRepository.findByLocationCodeLikeIgnoringCase("GOA-IN");
		for (Listing d : result) {
			System.out.println(d.toString());
		}
	}
}
