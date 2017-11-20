package com.webservice.reportController.D0400;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* Bean
* @author Zander KONG
*/
public class Bean_D0400_CashBalance implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1723380343172260232L;

	private String account_no_cash;
	
	private String ccy ;
	private BigDecimal avail_bal ;
	private BigDecimal pending_withdrawal;
	private BigDecimal t1_ledger_bal ;	
	private BigDecimal tn_ledger_bal ;
	private BigDecimal accrued_debit_interest;
	private BigDecimal accrued_credit_interest; 
    

	public String getAccount_no_cash() {
		return account_no_cash;
	}


	public void setAccount_no_cash(String account_no_cash) {
		this.account_no_cash = account_no_cash;
	}


	public String getCcy() {
		return ccy;
	}


	public void setCcy(String ccy) {
		this.ccy = ccy;
	}


	public BigDecimal getAvail_bal() {
		return avail_bal;
	}


	public void setAvail_bal(BigDecimal avail_bal) {
		this.avail_bal = avail_bal;
	}


	public BigDecimal getPending_withdrawal() {
		return pending_withdrawal;
	}


	public void setPending_withdrawal(BigDecimal pending_withdrawal) {
		this.pending_withdrawal = pending_withdrawal;
	}


	public BigDecimal getT1_ledger_bal() {
		return t1_ledger_bal;
	}


	public void setT1_ledger_bal(BigDecimal t1_ledger_bal) {
		this.t1_ledger_bal = t1_ledger_bal;
	}


	public BigDecimal getTn_ledger_bal() {
		return tn_ledger_bal;
	}


	public void setTn_ledger_bal(BigDecimal tn_ledger_bal) {
		this.tn_ledger_bal = tn_ledger_bal;
	}


	public BigDecimal getAccrued_debit_interest() {
		return accrued_debit_interest;
	}


	public void setAccrued_debit_interest(BigDecimal accrued_debit_interest) {
		this.accrued_debit_interest = accrued_debit_interest;
	}


	public BigDecimal getAccrued_credit_interest() {
		return accrued_credit_interest;
	}


	public void setAccrued_credit_interest(BigDecimal accrued_credit_interest) {
		this.accrued_credit_interest = accrued_credit_interest;
	}


	public Bean_D0400_CashBalance(String account_no_cash, String ccy, BigDecimal avail_bal, BigDecimal pending_withdrawal,
			BigDecimal t1_ledger_bal, BigDecimal tn_ledger_bal, BigDecimal accrued_debit_interest,
			BigDecimal accrued_credit_interest) {
		super();
		this.account_no_cash = account_no_cash;
		this.ccy = ccy;
		this.avail_bal = avail_bal;
		this.pending_withdrawal = pending_withdrawal;
		this.t1_ledger_bal = t1_ledger_bal;
		this.tn_ledger_bal = tn_ledger_bal;
		this.accrued_debit_interest = accrued_debit_interest;
		this.accrued_credit_interest = accrued_credit_interest;
	}


	public Bean_D0400_CashBalance() {
		super();
	}
}
