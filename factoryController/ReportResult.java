package com.webservice.factoryController;

import java.util.Arrays;

public class ReportResult {
	private boolean success;
	private String message;
	private byte[] reportByte;
	private String fileType;
	private String savedReportName;

	public ReportResult(){
		this.success = true;
		this.setMessage("SUCCESS");
	}
	
	public ReportResult(boolean success,String message){
		this.setSuccess(success);
		this.setMessage(message);
	}
	
	public ReportResult(boolean success,String message,byte[] reportByte){
		this.setSuccess(success);
		this.setMessage(message);
		this.setReportByte(reportByte);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	

	public byte[] getReportByte() {
		return reportByte;
	}

	public void setReportByte(byte[] reportByte) {
		this.reportByte = reportByte;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSavedReportName() {
		return savedReportName;
	}

	public void setSavedReportName(String savedReportName) {
		this.savedReportName = savedReportName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReportResult [success=" + success + ", message=" + message + ", reportByte.length="
				+ reportByte.length + ", fileType=" + fileType + ", savedReportName=" + savedReportName + "]";
	}
	
	

}
