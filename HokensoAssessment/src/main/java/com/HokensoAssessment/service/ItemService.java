package com.HokensoAssessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HokensoAssessment.model.ChallengeItem;
import com.HokensoAssessment.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepo;
	
	/**
	 * Find all from db
	 * @return
	 */
	public Iterable<ChallengeItem> findAllItem(){
		return itemRepo.findAll();
	}
	
	/**
	 * Find challenges based on challenge title
	 * @param title
	 * @return
	 */
	public ChallengeItem findChallengeByTitle(String title) {
		ChallengeItem item = null;
		Optional<ChallengeItem> optItem = itemRepo.findBytitle(title);
		if(optItem.isPresent()) {
			item = optItem.get();
		}
		return item;
	}
	
	/**
	 * Find challenges based on level and type
	 * @param level
	 * @param type
	 * @return
	 */
	public Iterable<ChallengeItem> findChallengeByLevel(String level, String type){
		return itemRepo.findByLevelandType(level, type);
	}
//	public Iterable<ChallengeItem> findChallengeByLevel(String level){
//		return itemRepo.findAllBylevel(level);
//	}
}
