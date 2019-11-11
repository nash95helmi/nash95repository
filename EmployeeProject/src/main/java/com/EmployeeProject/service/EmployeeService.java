package com.EmployeeProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeProject.model.Department;
import com.EmployeeProject.model.Employee;
import com.EmployeeProject.model.Manager;
import com.EmployeeProject.model.Position;
import com.EmployeeProject.model.idMaster;
import com.EmployeeProject.repository.DepartmentRepository;
import com.EmployeeProject.repository.EmployeeRepository;
import com.EmployeeProject.repository.IdMasterRepository;
import com.EmployeeProject.repository.ManagerRepository;
import com.EmployeeProject.repository.PositionRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	IdMasterRepository idMasterRepo;
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	/**
	 * List of available employee based under particular manager
	 * @param managerId
	 * @return
	 */
	public Iterable<Employee> findAllEmpByManager(String managerId){
		return empRepo.findAllByempManager(managerId);
	}
	
	/**
	 * Find Employee based on employee id
	 * @param id
	 * @return
	 */
	public Employee findEmpId(String id) {
		Employee employee = null;
		Optional<Employee> optEmp = empRepo.findById(id);
		if(optEmp.isPresent()) {
			employee = optEmp.get();
		}
		return employee;
	}
	
	/**
	 * Get the new EmpId for registration
	 * @param id
	 * @return
	 */
	public String getNewEmpId(String id) {
		Optional<idMaster> opt = idMasterRepo.findById(id);
		idMaster im = null;
		String currentId = null;
		if(opt.isPresent()) {
			im = opt.get();
			currentId = im.getCurrentId();
		}
		return generateEmpID(currentId);
	}
	
	/**
	 * Assign specific id for new created ID
	 * @param id
	 * @return
	 */
	public String generateEmpID(String id) {
		String newId = null;
		Integer numId = Integer.parseInt(id.substring(1)) + 1;
		if(numId < 10) {
			newId = "E0000"+numId;
		}else if(numId < 100) {
			newId = "E000"+numId;
		}else if(numId < 1000) {
			newId = "E00"+numId;
		}else if(numId < 10000) {
			newId = "E0"+numId;
		}else if(numId < 100000) {
			newId = "E"+numId;
		}
		return newId;
	}
	
	/**
	 * Get list of position under "empl" posgroup
	 * @param posGrp
	 * @return
	 */
	public Iterable<Position> getPosList(String posGrp){
		Iterable<Position> posList = positionRepository.findAllByposGroup(posGrp);
		return posList;
	}
	
	/**
	 * Find all department 
	 * @return
	 */
	public Iterable<Department> getDeptList(){
		return departmentRepository.findAll();
	}
	
	/**
	 * Find all available manager
	 * @return
	 */
	public Iterable<Manager> findAllManager(){
		return managerRepository.findAll();
	}
	
	/**
	 * Get the manager obj from manager id
	 * @param managerId
	 * @return
	 */
	public Manager findManager(String managerId){
		Manager manager = null;
		Optional<Manager> optManager = managerRepository.findById(managerId);
		if(optManager.isPresent()) {
			manager = optManager.get();
		}
		return manager;
	}
	
	/**
	 * Find the department Id based on department name
	 * @param deptName
	 * @return
	 */
	public String findDepartmentId(String deptName) {
		String deptID = null;
		Department department = null;
		Optional<Department> optDept = departmentRepository.findBydepartment(deptName);
		if(optDept.isPresent()) {
			department = optDept.get();
			deptID = department.getId();
		}
		return deptID;
	}
	
	/**
	 * Find the position Id based on the position name
	 * @param position
	 * @return
	 */
	public String findPositionId(String positionName) {
		String posId = null;
		Position position = null;
		Optional<Position> optPos = positionRepository.findByposTitle(positionName);
		if(optPos.isPresent()) {
			position = optPos.get();
			posId = position.getId();
		}
		return posId;
	}
	
	/**
	 * Save the registered employee,
	 * update the current employee id in id_master 
	 */
	public void saveRegEmployee(Employee employee) {
		Optional<idMaster> optIdMaster = idMasterRepo.findById("empl");
		idMaster IM = null;
		if(optIdMaster.isPresent()) {
			IM = optIdMaster.get();
			IM.setCurrentId(employee.getId());
			idMasterRepo.save(IM);
		}
		empRepo.save(employee);
	}
}
