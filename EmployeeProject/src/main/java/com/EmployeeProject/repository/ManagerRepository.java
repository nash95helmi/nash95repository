package com.EmployeeProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeProject.model.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, String>{
	
}
