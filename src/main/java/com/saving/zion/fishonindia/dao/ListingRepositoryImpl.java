package com.saving.zion.fishonindia.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.saving.zion.fishonindia.model.ListingFareAndAvailability;

public class ListingRepositoryImpl implements ListingRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<ListingFareAndAvailability> getAvailableListings(String locationCode, int paxCount, String fromDate, int days) {
		try {
			ISO8601DateFormat outputFormatter = new ISO8601DateFormat();
			SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date inputFromDate = null;
			try {
				inputFromDate = inputFormatter.parse(fromDate);
				String outputFromDate = outputFormatter.format(inputFromDate);
				System.out.println(outputFromDate);
				Boolean success = true;
			//	Query q
				for(int i=0 ; i<days ; i++) {
					// Query query = new
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
