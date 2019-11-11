package com.EmployeeProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeProject.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{
	
	Iterable<Employee> findAllByempManager(String managerID); 
}
