package com.webservice.reportController.D0400;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* Bean
* @author Zander KONG
*/
public class Bean_D0400_StockHolding implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8501000032219136076L;
	
	private String account_no_holding ;
	private String exchange_code ;
	private String product_code ;
	private BigDecimal avail_qty ;
	private BigDecimal ledger_qty ;
	private String product_name ;
	private String product_ccy ;
	
	private BigDecimal undue_qty; 
	private BigDecimal on_hold_qty;
	private String invest_class_suspended;

	private String avg_cost;
	private String market_price;
	private BigDecimal ledger_market_val;
	private BigDecimal unrealized_pl ;
	private BigDecimal fx_rate ;

	public BigDecimal getFx_rate() {
		return fx_rate;
	}

	public void setFx_rate(BigDecimal fx_rate) {
		this.fx_rate = fx_rate;
	}

	public BigDecimal getUndue_qty() {
		return undue_qty;
	}

	public void setUndue_qty(BigDecimal undue_qty) {
		this.undue_qty = undue_qty;
	}

	public BigDecimal getOn_hold_qty() {
		return on_hold_qty;
	}

	public void setOn_hold_qty(BigDecimal on_hold_qty) {
		this.on_hold_qty = on_hold_qty;
	}

	public String getInvest_class_suspended() {
		return invest_class_suspended;
	}

	public void setInvest_class_suspended(String invest_class_suspended) {
		this.invest_class_suspended = invest_class_suspended;
	}

	public String getAvg_cost() {
		return avg_cost;
	}

	public void setAvg_cost(String avg_cost) {
		this.avg_cost = avg_cost;
	}

	public String getMarket_price() {
		return market_price;
	}

	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public BigDecimal getLedger_market_val() {
		return ledger_market_val;
	}

	public void setLedger_market_val(BigDecimal ledger_market_val) {
		this.ledger_market_val = ledger_market_val;
	}

	public BigDecimal getUnrealized_pl() {
		return unrealized_pl;
	}

	public void setUnrealized_pl(BigDecimal unrealized_pl) {
		this.unrealized_pl = unrealized_pl;
	}

	public String getExchange_code() {
		return exchange_code;
	}

	public void setExchange_code(String exchange_code) {
		this.exchange_code = exchange_code;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getAccount_no_holding() {
		return account_no_holding;
	}

	public void setAccount_no_holding(String account_no_holding) {
		this.account_no_holding = account_no_holding;
	}

	public BigDecimal getAvail_qty() {
		return avail_qty;
	}

	public void setAvail_qty(BigDecimal avail_qty) {
		this.avail_qty = avail_qty;
	}

	public BigDecimal getLedger_qty() {
		return ledger_qty;
	}

	public void setLedger_qty(BigDecimal ledger_qty) {
		this.ledger_qty = ledger_qty;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_ccy() {
		return product_ccy;
	}

	public void setProduct_ccy(String product_ccy) {
		this.product_ccy = product_ccy;
	}


	public Bean_D0400_StockHolding(String account_no_holding, String exchange_code, String product_code, BigDecimal avail_qty,
			BigDecimal ledger_qty, String product_name, String product_ccy, BigDecimal undue_qty, BigDecimal on_hold_qty,
			String invest_class_suspended, String avg_cost, String market_price, BigDecimal ledger_market_val,
			BigDecimal unrealized_pl, BigDecimal fx_rate) {
		super();
		this.account_no_holding = account_no_holding;
		this.exchange_code = exchange_code;
		this.product_code = product_code;
		this.avail_qty = avail_qty;
		this.ledger_qty = ledger_qty;
		this.product_name = product_name;
		this.product_ccy = product_ccy;
		this.undue_qty = undue_qty;
		this.on_hold_qty = on_hold_qty;
		this.invest_class_suspended = invest_class_suspended;
		this.avg_cost = avg_cost;
		this.market_price = market_price;
		this.ledger_market_val = ledger_market_val;
		this.unrealized_pl = unrealized_pl;
		this.fx_rate = fx_rate;
	}

	public Bean_D0400_StockHolding() {
	}
}
