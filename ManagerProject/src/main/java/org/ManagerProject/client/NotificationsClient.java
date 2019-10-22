package org.ManagerProject.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class NotificationsClient extends RestTemplate{
	
	@Value("${service.url.notifications}")
	private String notificationsURL;
	
	public NotificationsClient() {
		super();
	}
}
