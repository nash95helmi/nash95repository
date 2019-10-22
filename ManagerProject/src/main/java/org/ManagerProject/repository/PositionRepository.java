package org.ManagerProject.repository;

import java.util.Optional;

import org.ManagerProject.model.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Integer>{
	
	Optional<Position> findByposTitle(String posTitle);
	Optional<Position> findByid(String posID);
}
