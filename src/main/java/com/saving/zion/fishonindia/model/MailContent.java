package com.saving.zion.fishonindia.model;

public class MailContent {

	private RequestSubmission requestSubmission;
	private Listing listing;

	public MailContent(RequestSubmission requestSubmission, Listing listing) {
		this.requestSubmission = requestSubmission;
		this.listing = listing;
	}

	public RequestSubmission getRequestSubmission() {
		return requestSubmission;
	}

	public void setRequestSubmission(RequestSubmission requestSubmission) {
		this.requestSubmission = requestSubmission;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
}
