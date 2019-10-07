package org.first.project.service;

import java.util.List;
import java.util.Optional;

import org.first.project.model.Employee;
import org.first.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Iterable<Employee> findAll(){
		Iterable<Employee> employee = employeeRepository.findAll();
		return employee;
	}
	
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public Employee findById(Integer id) {
		Optional<Employee> opt = employeeRepository.findById(id);
		Employee employee = null;
		if(opt.isPresent()) {
			employee = opt.get();
		}
		return employee;
	}
	
	public void deleteByid(Integer id) {
		employeeRepository.deleteById(id);
	}
}
