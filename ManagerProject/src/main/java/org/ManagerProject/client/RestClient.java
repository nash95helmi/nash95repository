package org.ManagerProject.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class RestClient {
	
	@Value("${service.url.reports}")
	protected String reportsURL;
	
	@Value("${service.url.documents}")
	protected String documentsURL;
	
	@Autowired
	private ReportsClient reportsClient;
	
	@Autowired
	private DocumentsClient documentsClient;
	
	public ReportsClient getReportsClient() {
		return reportsClient;
	}
	
	protected DocumentsClient getDocumentsClient() {
		return documentsClient;
	}
}
