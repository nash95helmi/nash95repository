package org.ManagerProject.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ManagerProject.model.Department;
import org.ManagerProject.model.DocMaster;
import org.ManagerProject.model.Manager;
import org.ManagerProject.model.Position;
import org.ManagerProject.model.idMaster;
import org.ManagerProject.repository.DepartmentRepository;
import org.ManagerProject.repository.DocMasterRepository;
import org.ManagerProject.repository.IdMasterRepository;
import org.ManagerProject.repository.ManagerRepository;
import org.ManagerProject.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private IdMasterRepository idMasterRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private PositionRepository postRepo;
	
	@Autowired
	private DocMasterRepository docMasterRepo;
	
	/**
	 * Show list of all manager
	 * @return
	 */
	public Iterable<Manager> findAll(){
		Iterable<Manager> mList = managerRepository.findAll();
		return mList;
	}
	
	/**
	 * Get current manager id to generate new manager id
	 * @param id
	 * @return
	 */
	public String findById(String id) {
		Optional<idMaster> opt = idMasterRepo.findByid(id);
		idMaster im = null;
		String currentId = null;
		if(opt != null) {
			im = opt.get();
			currentId = im.getCurrentId();
		}
		return generateManagerId(currentId);
	}
	
	/**
	 * To generate new Id for new created manager
	 * @param id
	 * @return
	 */
	public String generateManagerId(String id) {
		String newId = null;
		Integer numId = Integer.parseInt(id.substring(1)) + 1;
		if(numId < 10) {
			newId = "M0000"+numId;
		}else if(numId < 100) {
			newId = "M000"+numId;
		}else if(numId < 1000) {
			newId = "M00"+numId;
		}else if(numId < 10000) {
			newId = "M0"+numId;
		}else if(numId < 100000) {
			newId = "M"+numId;
		}
		return newId;
	}
	
	/**
	 * Find all available Position
	 * @return
	 */
	public Iterable<Position> findAllPos(){
		Iterable<Position> posList = postRepo.findAll();
		return posList;
	}
	
	/**
	 * Find all available Department
	 * @return
	 */
	public Iterable<Department> findAllDept(){
		Iterable<Department> depList = deptRepo.findAll();
		return depList;
	}
	
	/**
	 * Get position id based on position name
	 * @param posname
	 * @return
	 */
	public String getPostionID(String posname) {
		String posID = null;
		Position pos = null;
		Optional<Position> postObj = postRepo.findByposTitle(posname);
		if(postObj != null) {
			pos = postObj.get();
			posID = pos.getId();
		}
		return posID;
	}
	
	/**
	 * Get department id based on department name
	 * @param deptname
	 * @return
	 */
	public String getDepartmentID(String deptname) {
		String deptID = null;
		Department dep;
		Optional<Department> depObj = deptRepo.findBydepartment(deptname);
		if(depObj != null) {
			dep = depObj.get();
			deptID = dep.getId();
		}
		return deptID;
	}
	
	/**
	 * Save new registered manager.
	 * New managerID will be updated in IDMASTER
	 * @param manager
	 */
	public void SaveRegManager(Manager manager) {
		Optional<idMaster> opt = idMasterRepo.findByid("mngr");
		idMaster IM = null;
		if(opt != null) {
			IM = opt.get();
			IM.setCurrentId(manager.getId());
			idMasterRepo.save(IM);
		}
		managerRepository.save(manager);
	}
	
	/**
	 * Save updated details of manager
	 * @param manager
	 */
	public void saveUpdManager(Manager manager) {
		managerRepository.save(manager);
	}
	
	/**
	 * Find DocID based on managerID
	 * @param managerID
	 */
	public DocMaster getDocMaster(String managerID) {
		Optional<DocMaster> opt = docMasterRepo.findByid(managerID);
		DocMaster docMaster = null;
		if(opt.isPresent()){
			docMaster = opt.get();
		}
		return docMaster;
	}
	
	/**
	 * Save the document in DocMst after generate 
	 * the file id
	 * @param docMaster
	 */
	public void SaveDocMaster(DocMaster docMaster) {
		docMasterRepo.save(docMaster);
	}
	
	/**
	 * Get the manager by managerid, if found proceed to find 
	 * other details as well
	 * @param id
	 * @return
	 */
	public Manager GetManagerDetails(String id) {
		Manager manager = null;
		Optional<Manager> optManager = managerRepository.findByid(id);
		if(optManager != null) {
			manager = optManager.get();
		}
		return manager;
	}
	
	/**
	 * Get the department details by DeptID
	 * @param deptID
	 * @return
	 */
	public Department GetDepartmentDetails(String deptID) {
		Department dept = null;
		Optional<Department> optDepartment = deptRepo.findByid(deptID);
		if(optDepartment != null) {
			dept = optDepartment.get();
		}
		return dept;
	}
	
	/**
	 * Get the position details by posID
	 * @param posID
	 * @return
	 */
	public Position GetPositionDetails(String posID) {
		Position pos = null;
		Optional<Position> optPosition = postRepo.findByid(posID);
		if(optPosition != null) {
			pos = optPosition.get();
		}
		return pos;
	}
	
	/**
	 * Delete manager from Manager master
	 * @param managerID
	 */
	@Transactional	//Transactional is required when it comes to use deleteBy(other non-default id field)
	public void deleteManagerMaster(String managerID) {
		managerRepository.deleteByid(managerID);
	}
	
	/**
	 * Delete from Document master
	 * @param managerID
	 */
	@Transactional
	public void deleteDocMaster(String managerID) {
		docMasterRepo.deleteByid(managerID);
	}
}
