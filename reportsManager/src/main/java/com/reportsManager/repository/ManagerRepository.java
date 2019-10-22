package com.reportsManager.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reportsManager.model.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer>{
	Optional<Manager> findByid(String id);
}
