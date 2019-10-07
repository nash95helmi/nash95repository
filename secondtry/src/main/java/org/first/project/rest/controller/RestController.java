package org.first.project.rest.controller;

import org.first.project.model.Employee;
import org.first.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/employee")
public class RestController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/findAll")
	public Iterable<Employee> findAll() {

		Iterable<Employee> iList = employeeService.findAll(); 
		return iList;
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public Employee updateEmp(@RequestParam Integer id) {
		
		Employee employee = employeeService.findById(id);
		
		return employee;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Employee addUser(@RequestBody  Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
}
