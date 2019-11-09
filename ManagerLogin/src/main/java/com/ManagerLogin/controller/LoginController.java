package com.ManagerLogin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ManagerLogin.model.Manager;
import com.ManagerLogin.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(path = "/loginManager")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("loginPageManager");
		Iterable<Manager> mList = loginService.findAll();
		mav.addObject("mList", mList);
		return mav;
	}
	
	@RequestMapping(value = "checkID")
	public ModelAndView checkManagerID(@RequestParam String mngrID) {
		Optional<Manager> optManager = loginService.findManagerID(mngrID);
		if(optManager.isPresent()) {
//			return new ModelAndView("redirect:"+"http://localhost:8083/manager/findAll");
			return new ModelAndView("redirect:"+"http://localhost:8083/manager/register");
		}
		return new ModelAndView("redirect:"+"http://localhost:8081/login/loginManager");
	}
}
