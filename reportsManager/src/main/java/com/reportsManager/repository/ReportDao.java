package com.reportsManager.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import com.reportsManager.model.Department;
import com.reportsManager.model.Manager;
import com.reportsManager.model.Position;
import com.reportsManager.service.ReportService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class ReportDao {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private ReportService reportService;
	
	
	/**
	 * Take input of manager id to find other details
	 * @param managerID
	 * @return
	 */
	public JasperPrint get(String managerID) {
		JasperPrint print = null;
		try {
			resourceLoader = new DefaultResourceLoader();
			String path = resourceLoader.getResource("classpath:reports/ManagerReportFile.jrxml").getURI().getPath();
			System.out.println(path);
			
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			Manager manager = reportService.GetManagerDetails(managerID);
			Department department = reportService.GetDepartmentDetails(manager.getManagerDept());
			Position position = reportService.GetPositionDetails(manager.getManagerPos());
			
			if(manager != null && department != null && position != null) {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("manager_ID", manager.getId());
				parameters.put("manager_FName", manager.getManagerFName());
				parameters.put("manager_LName", manager.getManagerLName());
				parameters.put("position_ID", position.getId());
				parameters.put("position_Title", position.getPosTitle());
				parameters.put("department_ID", manager.getManagerDept());
				parameters.put("department_Name",department.getDepartment());
				parameters.put("controlling_Office",department.getControlOffice());
				parameters.put("department_Add1",department.getAddress1());
				parameters.put("department_Add2",department.getAddress2());
				
				print = JasperFillManager.fillReport(jasperReport, parameters);
			}
		}catch(Exception e) {
			
		}
		return print;
	}
}
