package com.HokensoAssessment.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HokensoAssessment.model.ChallengeItem;
import com.HokensoAssessment.service.ItemService;

@RestController
@RequestMapping("/findItem")
public class ItemTitleController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="/findAll")
	public Iterable<ChallengeItem> findAllItemInDB(){
		return itemService.findAllItem();
	}
	
	/**
	 * Get item object based on the title
	 * @param title
	 * @return
	 */
	@RequestMapping(value="/title/{title}", method = RequestMethod.GET)
	public ChallengeItem findItemByTitle(@PathVariable("title") String title){
		return itemService.findChallengeByTitle(title);
	}
}
