package com.webservice.reportController.D0400;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.FilterCriteria;

public class Controller_D0400Test {
	
	public static final Log logger = LogFactory.getLog(Controller_D0400Test.class.getName());

	@Ignore
	@Test
	public void testGenerateBeanArray() {
		logger.info("Begin jUnit test for the report in Controller_D0400Test class...");
		Controller_D0400 controller_D0400 = new Controller_D0400();
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
		controller_D0400.generateBeanArray(filterCriteriaArray);
	}
	

	@Test
	public void testGenerateFile() {
		logger.info("Begin jUnit test for the report in Controller_D0400Test class...");
		Controller_D0400 controller_D0400 = new Controller_D0400();
		
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
		controller_D0400.generateFile(filterCriteriaArray, "pdf");
	}

}
