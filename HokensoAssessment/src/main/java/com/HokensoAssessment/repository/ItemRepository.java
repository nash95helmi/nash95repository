package com.HokensoAssessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HokensoAssessment.model.ChallengeItem;

@Repository	
public interface ItemRepository extends CrudRepository<ChallengeItem, String>{
	
	/**
	 * Custom search by title 
	 * @return
	 */
	Optional<ChallengeItem> findBytitle(String title);
	
	/**
	 * Custom filter based on level(Beginner,Intermediate,Advanced)
	 * and type(Cardio Challenges)
	 * @param level
	 * @param type
	 * @return
	 */
	Iterable<ChallengeItem> findAllBylevel(String level);
	
	@Query("select c from ChallengeItem c where c.level=?1 AND c.type = ?2")
	Iterable<ChallengeItem> findByLevelandType(String level,String type);
}
