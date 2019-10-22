package org.ManagerProject.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class ReportsClient extends RestTemplate{

	@Value("${service.url.reports}")
	private String reportsURL;
	
	public ReportsClient() {
		super();
	}
}
