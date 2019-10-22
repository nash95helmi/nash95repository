package com.notificationsManager.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MailAttachment implements Serializable{

	private static final long serialVersionUID = 8618922023664345233L;
	
	private byte[] file;
	private String mimeType;
	private String fileName;
	
	public MailAttachment() {}

	public MailAttachment(byte[] file, String mimeType, String fileName) {
		super();
		this.file = file;
		this.mimeType = mimeType;
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
