package com.webservice.reportController.JS0100;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

public class Controller_JS0100Test {
	
	public static final Log logger = LogFactory.getLog(Controller_JS0100Test.class.getName());

	@Ignore
	@Test
	public void testGenerateBeanArray() {
		logger.info("Begin jUnit test for the report in Controller_JS0100 class...");
		Controller_JS0100 controller_JS0100 = new Controller_JS0100();
		controller_JS0100.generateBeanArray();
	}
	
	@Test
	public void testGenerateFile() {
		logger.info("Begin jUnit test for the report in Controller_JS0100 class...");
		Controller_JS0100 controller_JS0100 = new Controller_JS0100();
		controller_JS0100.generateFile("pdf");
	}

}
