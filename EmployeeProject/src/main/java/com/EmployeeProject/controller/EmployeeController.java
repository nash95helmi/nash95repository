package com.EmployeeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeProject.model.Department;
import com.EmployeeProject.model.Employee;
import com.EmployeeProject.model.Manager;
import com.EmployeeProject.model.Position;
import com.EmployeeProject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/findAllEmployee", method = RequestMethod.GET)
	public ModelAndView findAllEmloyee(@RequestParam String ManagerId) {
		ModelAndView mav = new ModelAndView("EmployeeList");
		Iterable<Employee> employeeList = employeeService.findAllEmpByManager(ManagerId);
		String managerName = employeeService.findManager(ManagerId).getManagerFName()+" "+employeeService.findManager(ManagerId).getManagerLName();
		String managerID = employeeService.findManager(ManagerId).getId();
		mav.addObject("managerID", managerID);
		mav.addObject("managerName", managerName);
		mav.addObject("employeeList",employeeList);
		return mav;
	}
	
	/**
	 * This is Employee Registration Page
	 * @return
	 */
	@RequestMapping(value = "/createEmployee")
	public ModelAndView registerEmp(@RequestParam String managerId) {
		ModelAndView mav = new ModelAndView("RegisterEmp");
		String newID = employeeService.getNewEmpId("empl");
		Iterable<Position> posList = employeeService.getPosList("empl");
		Iterable<Department> departmentList = employeeService.getDeptList();
		Manager manager = employeeService.findManager(managerId);
//		Iterable<Manager> managerList = employeeService.findAllManager();
		mav.addObject("newID", newID);
		mav.addObject("posList", posList);
		mav.addObject("departmentList", departmentList);
		mav.addObject("manager", manager);
		return mav;
	}
	
	/**
	 * Save the registered employee rec
	 * @param employeeID
	 * @param fname
	 * @param lname
	 * @param postn
	 * @param dept
	 * @param mngr
	 * @param emplType
	 * @param mEmel
	 * @return
	 */
	@RequestMapping(value = "saveReg", method = RequestMethod.GET)
	public ModelAndView saveRegEmployee(@RequestParam String employeeID, @RequestParam String fname, @RequestParam String lname,
										@RequestParam String postn, @RequestParam String dept, @RequestParam String mngr,
										@RequestParam String emplType, @RequestParam String mEmel) {
		Employee employee = new Employee();
		employee.setId(employeeID); 
		employee.setEmpFName(fname);
		employee.setEmpLName(lname);
		employee.setEmpPosId(employeeService.findPositionId(postn));
		employee.setEmpDept(employeeService.findDepartmentId(dept));
		employee.setEmpType(emplType);
		employee.setEmpManager(mngr);
		employee.setEmpEmel(mEmel);
		employeeService.saveRegEmployee(employee);
		return new ModelAndView("redirect:"+"http://localhost:8088/employee/findAllEmployee?ManagerId="+mngr); 
	}
}
