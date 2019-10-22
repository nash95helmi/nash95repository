package com.reportsManager.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reportsManager.model.Position;

public interface PositionRepository extends CrudRepository<Position, Integer>{
	
	Optional<Position> findByposTitle(String posTitle);
	Optional<Position> findByid(String posID);
}
