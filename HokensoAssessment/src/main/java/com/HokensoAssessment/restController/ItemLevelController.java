package com.HokensoAssessment.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HokensoAssessment.model.ChallengeItem;
import com.HokensoAssessment.repository.ItemRepository;

@RestController
@RequestMapping("/filterLevel")
public class ItemLevelController {
	
	@Autowired
	ItemRepository itemRepo;
	
	@RequestMapping(value = "/filterLevelandType/{level}&{type}")
	public Iterable<ChallengeItem> findItemListByLevel(@PathVariable("level") String level, @PathVariable("type") String type){
		return itemRepo.findByLevelandType(level, type);
	}
}
