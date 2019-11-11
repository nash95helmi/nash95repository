package com.EmployeeProject.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeProject.model.idMaster;

@Repository
public interface IdMasterRepository extends CrudRepository<idMaster, String>{
	Optional<idMaster> findByid(String id);
}
