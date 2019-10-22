package com.documentsManager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.documentsManager.model.Documents;

@Repository
public interface DocumentsRepositoy extends MongoRepository<Documents, String>{
	
}