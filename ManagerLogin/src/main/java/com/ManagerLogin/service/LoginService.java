package com.ManagerLogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ManagerLogin.model.Manager;
import com.ManagerLogin.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public Iterable<Manager> findAll(){
		Iterable<Manager> mList = loginRepository.findAll();
		return mList;
	}
	
	public Optional<Manager> findManagerID(String managerID) {
		Optional<Manager> optManager = loginRepository.findById(managerID);
		Manager manager = null;
		if(optManager.isPresent()) {
			manager = optManager.get();
		}
		return optManager;
	}
}
