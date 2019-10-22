package com.reportsManager.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportsManager.model.Department;
import com.reportsManager.model.Manager;
import com.reportsManager.model.Position;
import com.reportsManager.model.Report;
import com.reportsManager.repository.DepartmentRepository;
import com.reportsManager.repository.ManagerRepository;
import com.reportsManager.repository.PositionRepository;
import com.reportsManager.repository.ReportDao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportService {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private PositionRepository postRepo;
	
	@Autowired
	private ReportDao reportDao;
	
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
	 * Print the report
	 * @param managerID
	 * @return
	 */
	public JasperPrint get(String managerID) {
		return reportDao.get(managerID);
	}
		
//	public Report generateReport(String managerID) throws JRException{
	public Report generateReport(String managerID, HttpServletResponse response) throws JRException, IOException{
		
//		response.setContentType("application/x-download");
//		response.setHeader("Content-Disposition", String.format("attachment; filename=\"users.pdf\""));

		OutputStream out = response.getOutputStream();
		
		JasperPrint print = reportDao.get(managerID);
		byte[] content = null;
		Report report = new Report();
		if(print != null) {
//			JasperExportManager.exportReportToPdfStream(print, out);
			content = JasperExportManager.exportReportToPdf(print);
			if(content != null) {
				report.setFileName("first");
				report.setReportType("pdf");
				report.setMimeType("application/pdf");
				report.setReportBytes(content);
			}
		}
		return report;
	}
}