package com.ManagerLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ManagerLogin.controller.LoginController;

@SpringBootApplication
public class ManagerLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerLoginApplication.class, args);
	}

}
