package com.saving.zion.fishonindia.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saving.zion.fishonindia.model.RequestSubmission;

public interface RequestSubmissionRepository extends MongoRepository<RequestSubmission, String> {

}
