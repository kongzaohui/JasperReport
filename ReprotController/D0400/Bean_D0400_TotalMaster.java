package com.webservice.reportController.D0400;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Bean_D0400_TotalMaster implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5102739049858960925L;
	
	private String account_no;
	private String account_name;
	private String ae_code;
	private String ae_name;
	private String company_name;
	private String ae_team_id;
	private String ae_team_name;
	
	private String account_type_basic;
	private String bank_acct_no;
	private String bank_acct_name;
	
	private String invest_suit_en;
	private String invest_suit_tc;
	private String invest_suit_remark;
	
	private String account_tel1;
    private String account_tel2;
    private String account_mobile;
    
    private BigDecimal trade_limit;
    private String trade_ccy;
    
    private BigDecimal credit_limit;
    private String credit_ccy;
    
    private BigDecimal exposure_limit;
    private String exposure_ccy;
	   
	private List<Bean_D0400_CashBalance> cashBalanceBeanList;
	private List<Bean_D0400_StockHolding> stockHoldingBeanList;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAe_code() {
		return ae_code;
	}

	public void setAe_code(String ae_code) {
		this.ae_code = ae_code;
	}

	public String getAe_team_id() {
		return ae_team_id;
	}

	public void setAe_team_id(String ae_team_id) {
		this.ae_team_id = ae_team_id;
	}

	public String getAe_team_name() {
		return ae_team_name;
	}

	public void setAe_team_name(String ae_team_name) {
		this.ae_team_name = ae_team_name;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
  
public List<Bean_D0400_CashBalance> getCashBalanceBeanList() {
		return cashBalanceBeanList;
	}

	public void setCashBalanceBeanList(List<Bean_D0400_CashBalance> cashBalanceBeanList) {
		this.cashBalanceBeanList = cashBalanceBeanList;
	}

	public List<Bean_D0400_StockHolding> getStockHoldingBeanList() {
		return stockHoldingBeanList;
	}

	public void setStockHoldingBeanList(List<Bean_D0400_StockHolding> stockHoldingBeanList) {
		this.stockHoldingBeanList = stockHoldingBeanList;
	}

public Bean_D0400_TotalMaster() {
	super();
}

public String getAccount_type_basic() {
	return account_type_basic;
}

public void setAccount_type_basic(String account_type_basic) {
	this.account_type_basic = account_type_basic;
}

public String getBank_acct_no() {
	return bank_acct_no;
}

public void setBank_acct_no(String bank_acct_no) {
	this.bank_acct_no = bank_acct_no;
}

public String getBank_acct_name() {
	return bank_acct_name;
}

public void setBank_acct_name(String bank_acct_name) {
	this.bank_acct_name = bank_acct_name;
}

public String getInvest_suit_en() {
	return invest_suit_en;
}

public void setInvest_suit_en(String invest_suit_en) {
	this.invest_suit_en = invest_suit_en;
}

public String getInvest_suit_tc() {
	return invest_suit_tc;
}

public void setInvest_suit_tc(String invest_suit_tc) {
	this.invest_suit_tc = invest_suit_tc;
}

public String getInvest_suit_remark() {
	return invest_suit_remark;
}

public void setInvest_suit_remark(String invest_suit_remark) {
	this.invest_suit_remark = invest_suit_remark;
}

public String getAccount_tel1() {
	return account_tel1;
}

public void setAccount_tel1(String account_tel1) {
	this.account_tel1 = account_tel1;
}

public String getAccount_tel2() {
	return account_tel2;
}

public void setAccount_tel2(String account_tel2) {
	this.account_tel2 = account_tel2;
}

public String getAccount_mobile() {
	return account_mobile;
}

public void setAccount_mobile(String account_mobile) {
	this.account_mobile = account_mobile;
}

public BigDecimal getTrade_limit() {
	return trade_limit;
}

public void setTrade_limit(BigDecimal trade_limit) {
	this.trade_limit = trade_limit;
}

public String getTrade_ccy() {
	return trade_ccy;
}

public void setTrade_ccy(String trade_ccy) {
	this.trade_ccy = trade_ccy;
}

public BigDecimal getCredit_limit() {
	return credit_limit;
}

public void setCredit_limit(BigDecimal credit_limit) {
	this.credit_limit = credit_limit;
}

public String getCredit_ccy() {
	return credit_ccy;
}

public void setCredit_ccy(String credit_ccy) {
	this.credit_ccy = credit_ccy;
}

public BigDecimal getExposure_limit() {
	return exposure_limit;
}

public void setExposure_limit(BigDecimal exposure_limit) {
	this.exposure_limit = exposure_limit;
}

public String getExposure_ccy() {
	return exposure_ccy;
}

public void setExposure_ccy(String exposure_ccy) {
	this.exposure_ccy = exposure_ccy;
}

public String getAe_name() {
	return ae_name;
}

public void setAe_name(String ae_name) {
	this.ae_name = ae_name;
}

public Bean_D0400_TotalMaster(String account_no, String account_name, String ae_code, String ae_name, String company_name,
		String ae_team_id, String ae_team_name, String account_type_basic, String bank_acct_no, String bank_acct_name,
		String invest_suit_en, String invest_suit_tc, String invest_suit_remark, String account_tel1,
		String account_tel2, String account_mobile, BigDecimal trade_limit, String trade_ccy, BigDecimal credit_limit,
		String credit_ccy, BigDecimal exposure_limit, String exposure_ccy, List<Bean_D0400_CashBalance> cashBalanceBeanList,
		List<Bean_D0400_StockHolding> stockHoldingBeanList) {
	super();
	this.account_no = account_no;
	this.account_name = account_name;
	this.ae_code = ae_code;
	this.ae_name = ae_name;
	this.company_name = company_name;
	this.ae_team_id = ae_team_id;
	this.ae_team_name = ae_team_name;
	this.account_type_basic = account_type_basic;
	this.bank_acct_no = bank_acct_no;
	this.bank_acct_name = bank_acct_name;
	this.invest_suit_en = invest_suit_en;
	this.invest_suit_tc = invest_suit_tc;
	this.invest_suit_remark = invest_suit_remark;
	this.account_tel1 = account_tel1;
	this.account_tel2 = account_tel2;
	this.account_mobile = account_mobile;
	this.trade_limit = trade_limit;
	this.trade_ccy = trade_ccy;
	this.credit_limit = credit_limit;
	this.credit_ccy = credit_ccy;
	this.exposure_limit = exposure_limit;
	this.exposure_ccy = exposure_ccy;
	this.cashBalanceBeanList = cashBalanceBeanList;
	this.stockHoldingBeanList = stockHoldingBeanList;
}

public Bean_D0400_TotalMaster(String account_no, String account_name, String ae_code, String ae_name, String company_name,
		String ae_team_id, String ae_team_name, String account_type_basic, String bank_acct_no, String bank_acct_name,
		String invest_suit_en, String invest_suit_tc, String invest_suit_remark, String account_tel1,
		String account_tel2, String account_mobile, BigDecimal trade_limit, String trade_ccy, BigDecimal credit_limit,
		String credit_ccy, BigDecimal exposure_limit, String exposure_ccy) {
	super();
	this.account_no = account_no;
	this.account_name = account_name;
	this.ae_code = ae_code;
	this.ae_name = ae_name;
	this.company_name = company_name;
	this.ae_team_id = ae_team_id;
	this.ae_team_name = ae_team_name;
	this.account_type_basic = account_type_basic;
	this.bank_acct_no = bank_acct_no;
	this.bank_acct_name = bank_acct_name;
	this.invest_suit_en = invest_suit_en;
	this.invest_suit_tc = invest_suit_tc;
	this.invest_suit_remark = invest_suit_remark;
	this.account_tel1 = account_tel1;
	this.account_tel2 = account_tel2;
	this.account_mobile = account_mobile;
	this.trade_limit = trade_limit;
	this.trade_ccy = trade_ccy;
	this.credit_limit = credit_limit;
	this.credit_ccy = credit_ccy;
	this.exposure_limit = exposure_limit;
	this.exposure_ccy = exposure_ccy;
}
}
