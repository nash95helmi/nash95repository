package com.reportsManager.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.annotations.rules.PathCallParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.reportsManager.client.RestClient;
import com.reportsManager.model.Report;
import com.reportsManager.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping(value = "/")
public class ReportController extends RestClient{
	
	
	@Autowired
	private ReportService reportService;
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public ModelAndView home(@RequestParam String managerID) {
//		ModelAndView mav = new ModelAndView("home");
//		mav.addObject("ManagerID", managerID);
//		return mav;
//	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Report generateReport(@RequestParam String managerID, HttpServletResponse response) throws JRException, IOException{
//		return reportService.generateReport(managerID);
		return reportService.generateReport(managerID,response);
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public void export(@RequestParam String managerID ,ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"users.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = reportService.get(managerID);
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	 }
}
