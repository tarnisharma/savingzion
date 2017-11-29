package com.saving.zion.fishonindia.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Content {

	@Id
	private String Id;
	private String listingId;
	private List<Map<String, String>> photos;
	private List<Map<String, String>> videos;
	private List<Map<String, String>> website;
	private Map<String, String> contact;
	private Map<String, Object> text;
	private Map<String, String> inclusions;
	private Map<String, Object> policies;

	public Map<String, String> getInclusions() {
		return inclusions;
	}

	public void setInclusions(Map<String, String> inclusions) {
		this.inclusions = inclusions;
	}

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public List<Map<String, String>> getPhotos() {
		return photos;
	}

	public List<Map<String, String>> getVideos() {
		return videos;
	}

	public List<Map<String, String>> getWebsite() {
		return website;
	}

	public Map<String, String> getContact() {
		return contact;
	}

	public Map<String, Object> getText() {
		return text;
	}

	public Map<String, Object> getPolicies() {
		return policies;
	}

	public void setPhotos(List<Map<String, String>> photos) {
		this.photos = photos;
	}

	public void setVideos(List<Map<String, String>> videos) {
		this.videos = videos;
	}

	public void setWebsite(List<Map<String, String>> website) {
		this.website = website;
	}

	public void setContact(Map<String, String> contact) {
		this.contact = contact;
	}

	public void setText(Map<String, Object> text) {
		this.text = text;
	}

	public void setPolicies(Map<String, Object> policies) {
		this.policies = policies;
	}
}
