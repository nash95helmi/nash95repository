package com.reportsManager.client;

import org.springframework.beans.factory.annotation.Value;

public class RestClient {
	
	@Value("${service.url.managerProject}")
	private String managerProjectURL;

	public String getManagerProjectURL() {
		return managerProjectURL;
	}
}
