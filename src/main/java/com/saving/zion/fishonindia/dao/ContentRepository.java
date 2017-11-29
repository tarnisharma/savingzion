package com.saving.zion.fishonindia.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.saving.zion.fishonindia.model.Content;

public interface ContentRepository extends MongoRepository<Content, String> {

	public Content findByListingId(String listingId);
}
