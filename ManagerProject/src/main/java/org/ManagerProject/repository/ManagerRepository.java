package org.ManagerProject.repository;

import java.util.Optional;

import org.ManagerProject.model.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	Optional<Manager> findByid(String id);

	void deleteByid(String id);
}
