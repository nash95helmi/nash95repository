package com.reportsManager.model;

import java.io.Serializable;

public class Report implements Serializable{

	private static final long serialVersionUID = 2086479900431457147L;

	private String reportType; // pdf/excel/data
	private byte[] reportBytes;
	private String fileName;
	private String mimeType;

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public byte[] getReportBytes() {
		return reportBytes;
	}

	public void setReportBytes(byte[] reportBytes) {
		this.reportBytes = reportBytes;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}	
