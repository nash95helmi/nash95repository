package com.EmployeeProject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeProject.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String>{
	
	Optional<Department> findBydepartment(String department);
}
