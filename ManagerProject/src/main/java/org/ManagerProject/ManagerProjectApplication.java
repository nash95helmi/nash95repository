package org.ManagerProject;

import org.ManagerProject.client.DocumentsClient;
import org.ManagerProject.client.NotificationsClient;
import org.ManagerProject.client.ReportsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerProjectApplication.class, args);
	}
	
	@Bean
	protected ReportsClient reportsClient() {
		return new ReportsClient();
	}
	
	@Bean
	protected DocumentsClient documentsClient() {
		return new DocumentsClient();
	}
	
	@Bean
	protected NotificationsClient notificationsClient() {
		return new NotificationsClient();
	}
}
