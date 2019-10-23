package org.ManagerProject.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class RestClient {
	
	@Value("${service.url.reports}")
	protected String reportsURL;
	
	@Value("${service.url.documents}")
	protected String documentsURL;
	
	@Value("${service.url.notifications}")
	protected String notificationsURL;
	
	@Autowired
	private ReportsClient reportsClient;
	
	@Autowired
	private DocumentsClient documentsClient;
	
	@Autowired
	private NotificationsClient notificationsClient;
	
	public ReportsClient getReportsClient() {
		return reportsClient;
	}
	
	protected DocumentsClient getDocumentsClient() {
		return documentsClient;
	}
	
	public NotificationsClient getNotificationsClient() {
		return notificationsClient;
	}
}
