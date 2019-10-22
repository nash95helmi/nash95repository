package org.ManagerProject.repository;

import java.util.Optional;

import org.ManagerProject.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	
	Optional<Department> findBydepartment(String dept);
	Optional<Department> findByid(String deptID);
}
