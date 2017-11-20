package com.webservice.reportUtils;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SendEmailUtilTest {

	@Test
	public void testSendEmail() {
		String returnFileName = "C:\\Users\\zanderkong\\Desktop\\clientReport_jasper_report_template_total_master_report_TueNov07100050CST2017.pdf";
		SendEmailUtil sendEmailUtil =  new SendEmailUtil();
		try {
			sendEmailUtil.sendEmail(returnFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testCreateMimeMessage() {
		fail("Not yet implemented");
	}

}
