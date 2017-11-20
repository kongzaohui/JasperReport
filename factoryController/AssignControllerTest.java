package com.webservice.factoryController;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

public class AssignControllerTest {
	
	public static final Log logger = LogFactory.getLog(AssignControllerTest.class.getName());

	@Test
	public void testAssignReportController() {
		logger.info("Begin jUnit test for the report in testAssignReportController class...");
		AssignController assignController = new AssignController();
		//assignController.assignReportController("JS0100", null,"pdf");
		
		//assignController.assignReportController("JS0200", null,"pdf");
		
		
		FilterCriteria filterCriteria1 = new FilterCriteria();
		FilterCriteria filterCriteria2 = new FilterCriteria();
		
		filterCriteria1.setColumnName("ae_code");
		filterCriteria1.setCondition("AND");
		filterCriteria1.setFilterValue("'820220'");
		filterCriteria1.setOperator(">=");

		filterCriteria2.setColumnName("ae_code");
		filterCriteria2.setCondition("AND");
		filterCriteria2.setFilterValue("'820230'");
		filterCriteria2.setOperator("<=");
		FilterCriteria[] filterCriteriaArray = {filterCriteria1,filterCriteria2};
		assignController.assignReportController("D0400",filterCriteriaArray,"pdf");
	}
}
