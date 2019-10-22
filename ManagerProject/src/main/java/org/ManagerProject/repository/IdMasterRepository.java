package org.ManagerProject.repository;

import java.util.Optional;

import org.ManagerProject.model.idMaster;
import org.springframework.data.repository.CrudRepository;

public interface IdMasterRepository extends CrudRepository<idMaster, Integer>{
	
	Optional<idMaster> findByid(String id);
}
