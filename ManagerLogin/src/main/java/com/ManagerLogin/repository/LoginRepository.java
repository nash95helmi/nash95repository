package com.ManagerLogin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ManagerLogin.model.Manager;

@Repository
public interface LoginRepository extends CrudRepository<Manager, String>{
	
//	Optional<Manager> findByid(String managerID);
}
