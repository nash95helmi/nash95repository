package org.ManagerProject.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class DocumentsClient extends RestTemplate{
	
	@Value("${service.url.reports}")
	private String documensURL;
	
	public DocumentsClient() {
		super();
	}
}
