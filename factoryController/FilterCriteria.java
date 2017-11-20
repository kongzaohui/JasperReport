package com.webservice.factoryController;

public class FilterCriteria {
	
	private String columnName;
	private String operator;
	private String filterValue;
	private String condition;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public FilterCriteria(String columnName, String operator, String filterValue, String condition) {
		super();
		this.columnName = columnName;
		this.operator = operator;
		this.filterValue = filterValue;
		this.condition = condition;
	}
	
	public FilterCriteria() {
	}
	
}
