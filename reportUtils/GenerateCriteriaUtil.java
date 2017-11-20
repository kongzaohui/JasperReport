package com.webservice.reportUtils;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.FilterCriteria;

public class GenerateCriteriaUtil {
	
	protected static final Log log = LogFactory.getLog(GenerateCriteriaUtil.class.getName());
	
	public String constructWhereClause(FilterCriteria[] filterCriteriaArray) {
		log.info("Jump into GenerateCriteriaUtil to get whereClause from filterCriteriaArray...");
		String whereClause = "";
		if(filterCriteriaArray != null) {
			for(FilterCriteria filterCriteria : filterCriteriaArray) {
				log.info("get the Operator from the client as-->" + filterCriteria.getOperator());
				if( filterCriteria.getOperator().equals("=")  || 
					filterCriteria.getOperator().equals("<>") ||
					filterCriteria.getOperator().equals(">")  ||
					filterCriteria.getOperator().equals("<")  ||
					filterCriteria.getOperator().equals(">=") ||
					filterCriteria.getOperator().equals("<=") ) {
					if(whereClause.isEmpty()) {
						whereClause = whereClause + " AND " ; 
					}else {
						whereClause = whereClause + " "+filterCriteria.getCondition()+" ";
					}
					whereClause = whereClause + " " +filterCriteria.getColumnName()+ " " +filterCriteria.getOperator() + " " + filterCriteria.getFilterValue()+" ";
				}else{
					log.error("why here");
				}
			}
		}
		log.info("GenerateCriteriaUtil获取的whereClause是--->" + whereClause);
		return whereClause;
	}
}