package com.webservice.reportUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		Date datetime = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String presentString = df.format(datetime);
		presentString = presentString.replace(" ", "");
		presentString = presentString.replace(":", "");
		presentString = presentString.replace("-", "");
		System.out.println("Ϊpdf��csv�ļ�׼����ʱ���׺��------>" + presentString);

	}

}
