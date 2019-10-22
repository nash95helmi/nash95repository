package com.notificationsManager.model;

import java.io.Serializable;


public class Mail implements Serializable{

	private static final long serialVersionUID = 866625812674498496L;
	private String from;
    private String to;
    private String subject;
    private String bodyContent;
    private MailAttachment mailAttachment;
    
    public Mail() {}
    
	public Mail(String from, String to, String subject, String bodyContent, MailAttachment mailAttachment) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.bodyContent = bodyContent;
		this.mailAttachment = mailAttachment;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBodyContent() {
		return bodyContent;
	}

	public void setBodyContent(String bodyContent) {
		this.bodyContent = bodyContent;
	}

	public MailAttachment getMailAttachment() {
		return mailAttachment;
	}

	public void setMailAttachment(MailAttachment mailAttachment) {
		this.mailAttachment = mailAttachment;
	}
	
	@Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", bodyContent='" + bodyContent + '\'' +
                '}';
    }
}
