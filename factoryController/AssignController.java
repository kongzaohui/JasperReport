package com.webservice.factoryController;

import com.webservice.reportController.D0400.Controller_D0400;
import com.webservice.reportController.JS0100.Controller_JS0100;
import com.webservice.reportController.JS0200.Controller_JS0200;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

public class AssignController {
	
	protected static final Log log = LogFactory.getLog(AssignController.class.getName());
	
	public ReportResult assignReportController(String reportID,FilterCriteria[] filterCriteriaArray,String fileType) {
		log.info("This is the assignReportController entry point...");
		try{
			if (reportID.equals("D0400")) {
				log.info("Jump into D0400...");
				Controller_D0400 D0400Controller = new Controller_D0400();
				return D0400Controller.generateFile(filterCriteriaArray,fileType);
			}
			else if (reportID.equals("JS0100")) {
				log.info("Jump into JS0100...");
				Controller_JS0100 JS0100Controller = new Controller_JS0100();
				return JS0100Controller.generateFile(fileType);
			}
			else if (reportID.equals("JS0200")) {
				log.info("Jump into JS0200...");
				Controller_JS0200 JS0200Controller = new Controller_JS0200();
				return JS0200Controller.generateFile(fileType);
			}
			else {
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}