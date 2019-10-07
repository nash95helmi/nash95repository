package org.first.project.controller;

import org.first.project.model.Employee;
import org.first.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView("employee-list");
		Iterable<Employee> iList = employeeService.findAll(); 
		mav.addObject("iList", iList);
		return mav;
	}
	
	/**
	 * Redirect to other Register pages
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerEmp() {
		return "register";
	}
	
	/**
	 * Redirect to other UpdateEmp pages
	 * Perform update later
	 * @return
	 */
	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public ModelAndView updateEmp(@RequestParam Integer UpdateId) {
		ModelAndView mav = new ModelAndView("updateEmp");
		Employee employee = employeeService.findById(UpdateId);
		mav.addObject("employee", employee);
		return mav;
	}
	
	@RequestMapping(value = "/SaveUpd", method = RequestMethod.GET)
	public ModelAndView saveUpd(@RequestParam Integer updid, @RequestParam String fname, @RequestParam String lname, @RequestParam String email) {
		Employee emp = employeeService.findById(updid);
		if(emp != null) {
			emp.setFirstName(fname);
			emp.setLastName(lname);
			emp.setEmail(email);
			employeeService.save(emp);
		}
		ModelAndView mav = findAll();
		return mav;
	}
	
	
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public ModelAndView addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		employeeService.save(emp);
		ModelAndView mav = findAll();
		return mav;
	}
	
	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public ModelAndView deleteEmp(@RequestParam Integer DeleteId) {
		employeeService.deleteByid(DeleteId);
		ModelAndView mav = findAll();
		return mav;
	}
}
