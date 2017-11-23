package com.saving.zion.fishonindia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saving.zion.fishonindia.web.AutoSuggestionController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FishonindiaApplicationTests {

	@Autowired
	AutoSuggestionController autoSuggestionController;

	@Autowired
	DestinationsRepository destinationsRepository;

	@Test
	public void contextLoads() {
	}

	//@Test
	public void destinationsRepositoryTest() {
		Destinations andamans, goa, srinagar, pancheshwar;
		destinationsRepository.deleteAll();
		goa = destinationsRepository.save(new Destinations("Morijim", "Goa", "India", "GOA-IN"));
		andamans = destinationsRepository.save(new Destinations("Port Blair", "Andamans", "India", "ANDM-IN"));
		srinagar = destinationsRepository.save(new Destinations("Srinagar", "J&K", "India", "SXR-IN"));
		pancheshwar = destinationsRepository.save(new Destinations("Pancheshwar", "Uttarakhand", "India", "PNCH-IN"));
		
		List<Destinations> result = destinationsRepository.findByCityLike("Mor");
		assertThat(result).hasSize(1).extracting("city").contains("Morijim");
		
		result = destinationsRepository.findByState("J&K");
		assertThat(result).hasSize(1).extracting("state").contains("J&K");
		
		result = destinationsRepository.findByCountry("India");
		//System.err.println(result);
	}

	@Test
	public void autosuggestion() {
		List<Destinations> result = autoSuggestionController.getDestinations("");
		for(Destinations d : result ) {
			System.out.println(d.toString());
		}
		
	}
}
