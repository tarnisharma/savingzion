package com.saving.zion.fishonindia.model;

import org.springframework.data.annotation.Id;

public class RequestSubmission {

	@Id
	private String id;
	private String submissionId;
	private String name;
	private String listingId;
	private String locationCode;
	private UserDetails userDetails;
	private String dates;
	private int paxCount;
	private String comments;
	private String interests;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public int getPaxCount() {
		return paxCount;
	}

	public void setPaxCount(int paxCount) {
		this.paxCount = paxCount;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "RequestSubmission [submissionId=" + submissionId + ", name=" + name + ", listingId=" + listingId
				+ ", locationCode=" + locationCode + ", userDetails=" + userDetails + ", dates=" + dates + ", paxCount="
				+ paxCount + ", comments=" + comments + ", interests=" + interests + "]";
	}

}
