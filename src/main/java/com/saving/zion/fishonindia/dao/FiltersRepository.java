package com.saving.zion.fishonindia.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saving.zion.fishonindia.model.Filters;

public interface FiltersRepository extends MongoRepository<Filters, String> {
	public List<Filters> findAll();
}
