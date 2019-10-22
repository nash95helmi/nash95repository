package com.reportsManager.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reportsManager.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	
	Optional<Department> findBydepartment(String dept);
	Optional<Department> findByid(String deptID);
}
