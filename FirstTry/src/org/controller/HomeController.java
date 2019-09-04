package org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.User;
import org.repository.UserRepository;

/**
 * Servlet implementation class homeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public HomeController() {
//        super();
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		/**
		 * Delete section
		 */
		if(request.getParameter("idDelete") != null) {
			deleteMethod(request,response);
			
		/**
		 * update 1st step
		 */
		}else if(request.getParameter("id") != null) {
			updateStep(request,response);
		}else {
			System.out.println("Inside doGet");
			String nextJSP = "/WEB-INF/jsps/welcome.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		}
		
//		if(act.equals("create_click")) {
//			goRegisterPage(request,response);
//		}
//		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPOST");
		String act = request.getParameter("act");
		
		/**
		 * ViewAll Section
		 */
		if(act.equals("viewall_click")) {
			viewAllMethod(request,response);
			
		/**
		 * Register Section
		 */
		}else if(act.equals("register_click")) {
			registerMethod(request,response);
		
		/**
		* Update Section
		*/		
		}else if(act.equals("update_click")) {
			updateMethod(request,response);
			
		/**
		 * Create Section
		 */
		}else if(act.equals("create_click")) {
			goRegisterPage(request,response);
		}
	}
	
	
	/**
	 * Redirect to register page
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void goRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("inside goRegisterPage");
		String nextJSP = "/WEB-INF/jsps/welcome.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}
	
	
	/**
	 * Method to insert data rec into DB
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void registerMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextJSP = "/WEB-INF/jsps/success.jsp";
		
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setFirstname(fName);
		user.setLastname(lName);
		user.setPassword(password);
		user.setEmail(email);
		
		int result = UserRepository.addUser(user);
		
		if(result==-1 || result==0) {
			nextJSP = "/WEB-INF/jsps/failed.jsp";
		}
		
		System.out.println("dopost_register");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}
	
	
	/**
	 * Method to view all rec
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void viewAllMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost_viewall");
		List<User> allUser = UserRepository.getAllUser();
		request.setAttribute("AllList", allUser);
		String nextJSP = "/WEB-INF/jsps/viewall.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}
	
	
	/**
	 * Steps for Update
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateStep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("doPost_GetUpdateID");
		System.out.println(request.getParameter("id"));
		String nextJSP = "/WEB-INF/jsps/update.jsp";
		int UID = Integer.parseInt(request.getParameter("id"));
		User user =  new User();
		user.setUserId(UID);
		UserRepository.getUserID(user);
		System.out.println("From DB "+user.getUserId());
		System.out.println("From DB "+user.getPassword());
		System.out.println("From DB "+user.getFirstname());
		System.out.println("From DB "+user.getLastname());
		System.out.println("From DB "+user.getEmail());
		request.setAttribute("UID", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}
	
	
	/**
	 * Method to update rec
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPOST_UpdateContr");
		String nextJSP = "/WEB-INF/jsps/viewall.jsp";
		
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		int UID = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		
		user.setUserId(UID);
		user.setFirstname(fName);
		user.setLastname(lName);
		user.setPassword(password);
		user.setEmail(email);
		
		UserRepository.editUser(user);
		List<User> allUser = UserRepository.getAllUser();
		request.setAttribute("AllList", allUser);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
	
	
	/**
	 * Method to delete rec
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("inside deleteMethod");
		String nextJSP = "/WEB-INF/jsps/viewall.jsp";
		
		int UID = Integer.parseInt(request.getParameter("idDelete"));
		User user = new User();
		
		user.setUserId(UID);
		UserRepository.deleteUser(user);
		List<User> allUser = UserRepository.getAllUser();
		request.setAttribute("AllList", allUser);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}
}
