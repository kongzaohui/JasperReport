package com.webservice.factoryController;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ReportScheduler {
	
	private String enable;
	private String preCheck;
	private String preCheckSql;
	
	private String reportName;
	private String reportPath;
	private String outputPath;
	private String outputType;
	
	private String emailAddress;
	private String emailSubject;
	
	private String weekdayList;
	private String intervals;
	private String dbName;
	private String serverName;
	
	private Time startTime;
	private Time endTime;
	
	private int repeatNumber;
	
	public int getRepeatNumber() {
		return repeatNumber;
	}
	public void setRepeatNumber(int repeatNumber) {
		this.repeatNumber = repeatNumber;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getPreCheckSql() {
		return preCheckSql;
	}
	public void setPreCheckSql(String preCheckSql) {
		this.preCheckSql = preCheckSql;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportPath() {
		return reportPath;
	}
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	public String getOutputPath() {
		return outputPath;
	}
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	public String getOutputType() {
		return outputType;
	}
	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getWeekdayList() {
		return weekdayList;
	}
	public void setWeekdayList(String weekdayList) {
		this.weekdayList = weekdayList;
	}
	public String getIntervals() {
		return intervals;
	}
	public void setIntervals(String intervals) {
		this.intervals = intervals;
	}
	
	
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getPreCheck() {
		return preCheck;
	}
	public void setPreCheck(String preCheck) {
		this.preCheck = preCheck;
	}
	public ReportScheduler() {
	}
	@Override
	public String toString() {
		return "ReportScheduler [enable=" + enable + ", preCheck=" + preCheck + ", preCheckSql=" + preCheckSql
				+ ", reportName=" + reportName + ", reportPath=" + reportPath + ", outputPath=" + outputPath
				+ ", outputType=" + outputType + ", emailAddress=" + emailAddress + ", emailSubject=" + emailSubject
				+ ", weekdayList=" + weekdayList + ", intervals=" + intervals + ", dbName=" + dbName + ", serverName="
				+ serverName + ", startTime=" + startTime + ", endTime=" + endTime + ", repeatNumber=" + repeatNumber
				+ "]";
	}
	
}
