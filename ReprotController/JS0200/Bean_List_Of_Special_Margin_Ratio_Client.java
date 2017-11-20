package com.webservice.reportController.JS0200;

import java.math.BigDecimal;

public class Bean_List_Of_Special_Margin_Ratio_Client {
	
	private String accountNo;
	private String accountName;
	
	private String productCode;
	private String productType;
	private String productName;

	private BigDecimal tn_Qty;
	private BigDecimal closePrice;
	private BigDecimal marketValue;
	
	private BigDecimal marginRate;
	private BigDecimal specialRate;
	private BigDecimal marginableValue;
	private BigDecimal marginableValue2;
	private BigDecimal difference;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getTn_Qty() {
		return tn_Qty;
	}
	public void setTn_Qty(BigDecimal tn_Qty) {
		this.tn_Qty = tn_Qty;
	}
	public BigDecimal getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	public BigDecimal getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
	}
	public BigDecimal getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(BigDecimal marginRate) {
		this.marginRate = marginRate;
	}
	public BigDecimal getSpecialRate() {
		return specialRate;
	}
	public void setSpecialRate(BigDecimal specialRate) {
		this.specialRate = specialRate;
	}
	public BigDecimal getMarginableValue() {
		return marginableValue;
	}
	public void setMarginableValue(BigDecimal marginableValue) {
		this.marginableValue = marginableValue;
	}
	public BigDecimal getMarginableValue2() {
		return marginableValue2;
	}
	public void setMarginableValue2(BigDecimal marginableValue2) {
		this.marginableValue2 = marginableValue2;
	}
	public BigDecimal getDifference() {
		return difference;
	}
	public void setDifference(BigDecimal difference) {
		this.difference = difference;
	}
	@Override
	public String toString() {
		return "Bean_List_Of_Special_Margin_Ratio_Client [accountNo=" + accountNo + ", accountName=" + accountName
				+ ", productCode=" + productCode + ", productType=" + productType + ", productName=" + productName
				+ ", tn_Qty=" + tn_Qty + ", closePrice=" + closePrice + ", marketValue=" + marketValue + ", marginRate="
				+ marginRate + ", specialRate=" + specialRate + ", marginableValue=" + marginableValue
				+ ", marginableValue2=" + marginableValue2 + ", difference=" + difference + "]";
	}
	public Bean_List_Of_Special_Margin_Ratio_Client() {
		super();
	}
}
