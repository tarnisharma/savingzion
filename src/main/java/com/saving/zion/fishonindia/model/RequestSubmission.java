package com.saving.zion.fishonindia.model;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class RequestSubmission {

	@Id
	private String id;
	private String name;
	private String listingId;
	private String locationCode;
	private Map<String,String> userDetails;
	
}
