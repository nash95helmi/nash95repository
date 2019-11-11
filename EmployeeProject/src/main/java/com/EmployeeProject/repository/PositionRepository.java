package com.EmployeeProject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.EmployeeProject.model.Department;
import com.EmployeeProject.model.Position;

public interface PositionRepository extends CrudRepository<Position, String>{
	
	Iterable<Position> findAllByposGroup(String posGrp);
	Optional<Position> findByposTitle(String posTitle);
}
