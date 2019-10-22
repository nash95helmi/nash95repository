package com.documentsManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documentsManager.model.Documents;
import com.documentsManager.repository.DocumentsRepositoy;

@RestController
@RequestMapping
public class DocumentsController {
	
	@Autowired
	DocumentsRepositoy documentsRepository;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Documents addNewApplication(@RequestBody Documents documents) {
		return documentsRepository.save(documents);
	}
}
