package org.ManagerProject.repository;

import java.util.Optional;

import org.ManagerProject.model.DocMaster;
import org.springframework.data.repository.CrudRepository;

public interface DocMasterRepository extends CrudRepository<DocMaster, Integer>{
	Optional<DocMaster> findByid(String id);
	void deleteByid(String managerID);
}
