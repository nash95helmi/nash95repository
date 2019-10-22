package org.ManagerProject.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MailAttachment implements Serializable{

	private static final long serialVersionUID = -7155323191078784175L;
	
	private byte[] file;
	private String mimeType;
	private String fileName;
	
	public MailAttachment() {}
	
	public MailAttachment(String fileName, byte[] file, String mimeType) {
		this.fileName = fileName;
		this.file = file;
		this.mimeType = mimeType;
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
