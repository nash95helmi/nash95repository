package org.ManagerProject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ManagerProject.client.RestClient;
import org.ManagerProject.model.Department;
import org.ManagerProject.model.DocMaster;
import org.ManagerProject.model.Documents;
import org.ManagerProject.model.Mail;
import org.ManagerProject.model.MailAttachment;
import org.ManagerProject.model.Manager;
import org.ManagerProject.model.Position;
import org.ManagerProject.model.Report;
import org.ManagerProject.service.ManagerService;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/manager")
public class ManagerController extends RestClient{
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	RestTemplate restTemplate;
	
	@RequestMapping(path = "/findAll")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView("managerList");
		Iterable<Manager> mList = managerService.findAll();
		mav.addObject("mList",mList);
		return mav;
	}
	
	/**
	 * Redirect to register page
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView RegistManager() {
		ModelAndView mav = new ModelAndView("register");
		String currentID = managerService.findById("mngr");
		Iterable<Department> dList = managerService.findAllDept();
		Iterable<Position> pList = managerService.findAllPos();
		mav.addObject("currentID", currentID);
		mav.addObject("dList", dList);
		mav.addObject("pList", pList);
		return mav;
	}
	
	/**
	 * Save the registered manager & redirect to findAll page
	 * @return
	 */
	@RequestMapping(value = "saveReg", method = RequestMethod.GET)
	public ModelAndView SaveRegister(@RequestParam String managerID, @RequestParam String fname, @RequestParam String lname,
									 @RequestParam String postn, @RequestParam String dept, @RequestParam String mEmel) {
		Manager manager = new Manager();
		manager.setId(managerID);
		manager.setManagerFName(fname);
		manager.setManagerLName(lname);
		manager.setManagerPos(managerService.getPostionID(postn));
		manager.setManagerDept(managerService.getDepartmentID(dept));
		manager.setManagerSta("Active");
		manager.setManagerEmel(mEmel);
		managerService.SaveRegManager(manager);
		checkSaveReg(managerID);
		ModelAndView mav = findAll();
		return mav;
	}
	
	/**
	 * Check if managerDetails successfully created, proceed to print the report
	 * and upload it in MongoDB, notify to manager email.
	 * @param managerID
	 */
	public void checkSaveReg(String managerID) {
		Manager manager = managerService.GetManagerDetails(managerID);
		if(manager != null) {
			Report report = getReportsClient().getForObject(reportsURL + "/test?managerID="+managerID, Report.class);
			Documents documents = new Documents();
			if(report != null) {
				documents.setName(report.getFileName());
				documents.setType(report.getMimeType());
				documents.setContents(report.getReportBytes());
				documents.setSize(String.valueOf(report.getReportBytes().length));
				documents = getDocumentsClient().postForObject(documentsURL+"/upload", documents, Documents.class);
				if(documents != null) {
					DocMaster docMaster = new DocMaster();
					docMaster.setPersonID(managerID);
					docMaster.setDocumentID(documents.getId());
					managerService.SaveDocMaster(docMaster);
					
//					MailAttachment mailAttachment = new MailAttachment(documents.getName(), documents.getContents(), documents.getType());
//					Mail mail = new Mail("ManagerController@locahost8083", manager.getManagerEmel(), "Added", mailAttachment,"You has been register as "+manager.getId());
//					boolean status = getNotificationsClient().postForObject(notificationsURL + "/registrationDetails", mail, Boolean.class);
//					System.out.println("Sending email status is "+status);
				}
			}
		}
	}
	
	/**
	 * Take param from userID, posID, deptID
	 * @return
	 */
	@RequestMapping(value = "/viewManager", method = RequestMethod.GET)
	public ModelAndView ViewManager(@RequestParam String ManagerId, @RequestParam String PositionId, @RequestParam String DepartmentId) {
		ModelAndView mav = new ModelAndView("viewManager");
		Manager manager = managerService.GetManagerDetails(ManagerId);
		Department department = managerService.GetDepartmentDetails(DepartmentId);
		Position position = managerService.GetPositionDetails(PositionId);
		mav.addObject("manager", manager);
		mav.addObject("department",department);
		mav.addObject("position",position);
		return mav;
	}
	
	/**
	 * Redirect to updateManager page
	 * @param UpdateId
	 * @param PositionId
	 * @param DepartmentId
	 * @return
	 */
	@RequestMapping(value = "/updateMng", method = RequestMethod.GET)
	public ModelAndView updateManager(@RequestParam String UpdateId,  @RequestParam String PositionId, @RequestParam String DepartmentId) {
		ModelAndView mav = new ModelAndView("updateManager");
		Manager manager = managerService.GetManagerDetails(UpdateId);
		Department department = managerService.GetDepartmentDetails(DepartmentId);
		Position position = managerService.GetPositionDetails(PositionId);
		String selectedPosL = position.getPosTitle();
		String selectedDeptL = department.getDepartment(); 
		Iterable<Department> dList = managerService.findAllDept();
		Iterable<Position> pList = managerService.findAllPos();
		mav.addObject("dList", dList);
		mav.addObject("pList", pList);
		mav.addObject("manager", manager);
		mav.addObject("department", department);
		mav.addObject("position", position);
		mav.addObject("selectedPosL", selectedPosL);
		mav.addObject("selectedDeptL", selectedDeptL);
		mav.addObject("dList", dList);
		mav.addObject("pList", pList);
		return mav;
	}
	
	/**
	 * Save the updated Manager details
	 * @return
	 */
	@RequestMapping(value = "saveUpd", method=RequestMethod.GET)
	public ModelAndView saveUpdManager(@RequestParam String managerID, @RequestParam String fname, @RequestParam String lname,
			 						   @RequestParam String postn, @RequestParam String dept, @RequestParam String mEmel) {
		Manager manager = managerService.GetManagerDetails(managerID);
		if(manager != null) {
			manager.setManagerFName(fname);
			manager.setManagerLName(lname);
			manager.setManagerPos(managerService.getPostionID(postn));
			manager.setManagerDept(managerService.getDepartmentID(dept));
			manager.setManagerSta("Active");
			manager.setManagerEmel(mEmel);
			managerService.saveUpdManager(manager);
			updateManagerDoc(managerID);
		}
		ModelAndView mav = findAll();
		return mav;
	}
	
	/**
	 * Update documents in MongoDB
	 * @param managerID
	 */
	public void updateManagerDoc(String managerID) {
		DocMaster docMaster = managerService.getDocMaster(managerID);
		Report report = getReportsClient().getForObject(reportsURL + "/test?managerID="+managerID, Report.class);
		Documents documents = new Documents();
		if(report != null) {
			documents.setName(report.getFileName());
			documents.setType(report.getMimeType());
			documents.setContents(report.getReportBytes());
			documents.setSize(String.valueOf(report.getReportBytes().length));
			if(docMaster != null) {
				getDocumentsClient().delete(documentsURL+"/delete/id/"+docMaster.getDocumentID());
			}
			documents = getDocumentsClient().postForObject(documentsURL+"/upload", documents, Documents.class);
			if(documents != null) {
				if(docMaster != null) {
					docMaster.setDocumentID(documents.getId());
				}else {
					docMaster = new DocMaster();
					docMaster.setPersonID(managerID);
					docMaster.setDocumentID(documents.getId());
				}
				managerService.SaveDocMaster(docMaster);
			}
		}
	}
	
	/**
	 * Delete the manager from manager master & doc master
	 * Delete the data in mongoDB
	 * @param DeleteId
	 */
	@RequestMapping(value = "/deleteMng", method = RequestMethod.GET)
	public ModelAndView deleteManager(@RequestParam String DeleteId) {
		DocMaster docMaster = managerService.getDocMaster(DeleteId);
		getDocumentsClient().delete(documentsURL+"/delete/id/"+docMaster.getDocumentID());
		managerService.deleteDocMaster(DeleteId);
		managerService.deleteManagerMaster(DeleteId);
		ModelAndView mav = findAll();
		return mav;
	}
	
	/**
	 * Print manager details if found in db,
	 * else create report n download
	 */
	@RequestMapping(value = "/printMng", method = RequestMethod.GET)
	public void printDetails(@RequestParam String PrintId, HttpServletRequest request, HttpServletResponse response) throws Exception {	
		DocMaster docMaster = managerService.getDocMaster(PrintId);
		if(docMaster != null) {
			Documents documents = new Documents();
			documents = getDocumentsClient().getForObject(documentsURL+"/download/id/"+docMaster.getDocumentID(),Documents.class);
			if (documents != null) {
				writeFile(documents.getContents(),response,PrintId);
			}
		}else {
			PrintManager(PrintId, request, response);
		}
	}
	
	/**
	 * Print the manager details report based on manager id
	 * This will call report services
	 * @throws Exception 
	 */
	public void PrintManager(String PrintId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Report report = getReportsClient().getForObject(reportsURL + "/test?managerID="+PrintId, Report.class);
		writeFile(report.getReportBytes(),response,PrintId);
	}
	
	/**
	 * Park this file in program directory 
	 * @param fileInput
	 * @param response
	 * @throws Exception
	 */
	public void writeFile(byte[] fileInput,HttpServletResponse response, String PrintId) throws Exception {
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\""+PrintId+".pdf\""));
		OutputStream out = response.getOutputStream();
		File file = new File("newfile.pdf");
		try (FileOutputStream fop = new FileOutputStream(file)){
			if(!file.exists()) {
				file.createNewFile();
			}
			fop.write(fileInput);
			InputStream fileInputStream = new FileInputStream(file);
			IOUtils.copyLarge(fileInputStream, out);
			out.flush();
			fop.close();
			file.delete();
			System.out.println("Done");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
