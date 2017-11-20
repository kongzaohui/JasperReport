package com.webservice.reportController.D0400;

import java.util.ArrayList;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.FilterCriteria;
import com.webservice.factoryController.ReportResult;
import com.webservice.reportUtils.ColumnReflectionUtil;
import com.webservice.reportUtils.DBConnectionUtil;
import com.webservice.reportUtils.GenerateFileUtil;
import com.webservice.reportUtils.GenerateCriteriaUtil;

import java.sql.*;

public class Controller_D0400 {

	protected static final Log log = LogFactory.getLog(Controller_D0400.class.getName());

	public Bean_D0400_TotalMaster[] generateBeanArray(FilterCriteria[] filterCriteriaArray) {
		
		log.info("Begin generating BeanArray for the report in Controller_D0400 class...");

		PreparedStatement stmt_totalmasterbean, stmt_subreportbeans_cash, stmt_subreportbeans_holding;
		ResultSet rs_totalmasterbean = null, rs_subreportbeans_cash = null, rs_subreportbeans_holding = null;

		GenerateCriteriaUtil reportCommonUtil = new GenerateCriteriaUtil();
		String totalCondition = reportCommonUtil.constructWhereClause(filterCriteriaArray);
		log.info("D0400添加上的whereClause是---->" + totalCondition);
		
		String sql_totalmasterbean = "select * from  ( SELECT distinct MA.account_no AS account_no, MA.account_name AS account_name, MA.ae_code AS ae_code, mae.ae_name AS ae_name, AC.company_name AS company_name, Isnull(maet.ae_team_id, '') AS ae_team_id, Isnull(maet.ae_team_name, '') AS ae_team_name, CASE MMA.main_account_type WHEN 'C' THEN 'Cash' WHEN 'M' THEN 'Margin' WHEN 'H' THEN 'House' ELSE '' END AS account_type_basic, Isnull(BANK_ACCT.bank_acct_no, '') AS bank_acct_no, Isnull(BANK_ACCT.bank_acct_name, '') AS bank_acct_name, SST.display_en AS invest_suit_en, SST.display_tc AS invest_suit_tc, SST.remark AS invest_suit_remark, Isnull(ACO.idd_code, '') + MMAC.tel AS account_tel1, Isnull(ACO.idd_code, '') + MMAC.tel2 AS account_tel2, Isnull(ACO.idd_code, '') + MMAC.mobile AS account_mobile, Isnull(CONVERT(DECIMAL(18, 2), VMS.trade_limit), 0.00) AS trade_limit, MA.trade_ccy AS trade_ccy, Isnull(CONVERT(DECIMAL(18, 2), VMS.credit_limit), 0.00) AS credit_limit, MA.credit_ccy AS credit_ccy, Isnull(CONVERT(DECIMAL(18, 2), VMS.exposure_limit), 0.00) AS exposure_limit, MA.exposure_ccy AS exposure_ccy FROM MST_ACCOUNT MA INNER JOIN MST_MAIN_ACCOUNT MMA ON MA.main_account_no = MMA.main_account_no AND MA.chk_status = 'A' and MMA.chk_status = 'A' and MMA.main_account_status = 'A' INNER JOIN mst_ae mae ON mae.ae_code = ma.ae_code LEFT JOIN mst_ae_team maet ON maet.ae_team_id = mae.ae_team_id AND maet.company_code = mae.company_code CROSS JOIN ADM_COMPANY AC INNER JOIN VIEW_MARGIN_SUMMARY VMS ON VMS.account_no = MA.account_no AND AC.company_code = VMS.company_code LEFT JOIN SYS_SYSTEM_TYPE SST ON SST.type_status = 'A' AND SST.sys_type = 'client_invest_suit' AND SST.type_value = MA.invest_suitability_class LEFT JOIN (SELECT MMAC1.* FROM MST_MAIN_ACCOUNT_CONTACT MMAC1 INNER JOIN (SELECT main_account_no, Min(row_no) AS row_no FROM MST_MAIN_ACCOUNT_CONTACT GROUP BY main_account_no) AS MMAC2 ON MMAC1.main_account_no = MMAC2.main_account_no AND MMAC1.row_no = MMAC2.row_no) AS MMAC ON MMA.main_account_no = MMAC.main_account_no LEFT JOIN ADM_COUNTRY ACO(NOLOCK) ON MMAC.country_code = ACO.country_code LEFT JOIN (SELECT MMABA1.* FROM MST_MAIN_ACCOUNT_BANK_ACCT MMABA1 INNER JOIN (SELECT Min(row_no) AS row_no, main_account_no FROM MST_MAIN_ACCOUNT_BANK_ACCT WHERE is_default = 'Y' GROUP BY main_account_no) as MMABA2 ON MMABA1.row_no = MMABA2.row_no AND MMABA1.main_account_no = MMABA2.main_account_no) as BANK_ACCT ON BANK_ACCT.main_account_no = MMA.main_account_no ) as result where 1=1" + totalCondition;
		String sql_subreportbeans_cash = "SELECT MA.account_no AS account_no_cash, Isnull(VBAB.ccy, '') AS ccy, Isnull(CONVERT(DECIMAL(18, 2), VBAB.t_avail_bal), 0.00) AS avail_bal, Isnull(CONVERT(DECIMAL(18, 2), SC.pending_withdrawal), 0.00) AS pending_withdrawal, Isnull(CONVERT(DECIMAL(18, 2), VBAB.t1_ledger_bal), 0.00) AS t1_ledger_bal, Isnull(CONVERT(DECIMAL(18, 2), VBAB.tn_ledger_bal), 0.00) AS tn_ledger_bal, Isnull(CONVERT(DECIMAL(18, 2), VBAB.accrued_int), 0.00) AS accrued_debit_interest, Isnull(CONVERT(DECIMAL(18, 2), VBAB.real_accrued_cr_int), 0.00) AS accrued_credit_interest FROM VIEW_BAL_ACCOUNT_BALANCE VBAB INNER JOIN MST_MAIN_ACCOUNT MMA ON VBAB.account_no = MMA.main_account_no AND MMA.chk_status = 'A' and MMA.main_account_status = 'A' INNER JOIN MST_ACCOUNT MA ON MA.account_no = VBAB.account_no AND MA.chk_status = 'A' CROSS JOIN ADM_COMPANY AC INNER JOIN VIEW_MARGIN_SUMMARY VMS ON VMS.account_no = MA.account_no AND AC.company_code = VMS.company_code LEFT JOIN SYS_SYSTEM_TYPE SST ON SST.type_status = 'A' AND SST.sys_type = 'client_invest_suit' AND SST.type_value = MA.invest_suitability_class LEFT JOIN (SELECT MMAC1.* FROM MST_MAIN_ACCOUNT_CONTACT MMAC1 INNER JOIN (SELECT main_account_no, Min(row_no) AS row_no FROM MST_MAIN_ACCOUNT_CONTACT GROUP BY main_account_no) AS MMAC2 ON MMAC1.main_account_no = MMAC2.main_account_no AND MMAC1.row_no = MMAC2.row_no) AS MMAC ON MMA.main_account_no = MMAC.main_account_no LEFT JOIN ADM_COUNTRY ACO(NOLOCK) ON MMAC.country_code = ACO.country_code LEFT JOIN (SELECT account_no, ccy, Sum(Isnull(TCI.amount, 0)) AS pending_withdrawal FROM TRN_CASH_IO TCI(NOLOCK) WHERE TCI.io_type = 'W' AND TCI.chk_status = 'U' GROUP BY account_no, ccy) SC ON SC.account_no = VBAB.account_no AND SC.ccy = Isnull(VBAB.ccy, SC.ccy) WHERE 1=1"+ totalCondition;
		String sql_subreportbeans_holding = "SELECT MA.account_no AS account_no_holding, VWBAH.exchange_code AS exchange_code, VWBAH.product_code AS product_code, CONVERT(DECIMAL(18, 0), VWBAH.t_qty) AS avail_qty, CONVERT(DECIMAL(18, 0), VWBAH.tn_qty) AS ledger_qty, VHMP.product_name AS product_name, VHMP.ccy AS product_ccy, CONVERT(DECIMAL(18, 0), VWBAH.tn_qty - VWBAH.t_qty) AS undue_qty, CONVERT(DECIMAL(18, 0), VWBAH.on_hold_qty) AS on_hold_qty, Isnull(SST.display_en, '') AS invest_class_suspended, CONVERT(DECIMAL(18, 6), CASE WHEN VWBAH.tn_qty <> 0 THEN VWBAH.total_cost / VWBAH.tn_qty ELSE 0 END) AS avg_cost, CONVERT(DECIMAL(18, 6), VWBAMD.close_price) AS market_price, CONVERT(DECIMAL(18, 2), VWBAMD.tn_mkt_val) AS ledger_market_val, CONVERT(DECIMAL(18, 2), VWBAMD.tn_mkt_val - VWBAH.total_cost) AS unrealized_pl, CONVERT(DECIMAL(18, 6), VWBAMD.fx_rate) AS fx_rate FROM VIEW_WH_BAL_ACCOUNT_HOLDING VWBAH INNER JOIN VIEW_WH_MST_PRODUCT VHMP ON VHMP.product_code = VWBAH.product_code AND VHMP.exchange_code = VWBAH.exchange_code INNER JOIN VIEW_WH_BAL_ACCOUNT_MKTVAL_DTL VWBAMD ON VWBAMD.product_code = VWBAH.product_code AND VWBAMD.exchange_code = VWBAH.exchange_code AND VWBAMD.account_no = VWBAH.account_no AND VWBAMD.company_code = VWBAH.company_code INNER JOIN MST_ACCOUNT MA ON MA.account_no = VWBAH.account_no AND MA.chk_status = 'A' INNER JOIN MST_MAIN_ACCOUNT MMA ON MA.main_account_no = MMA.main_account_no AND MMA.chk_status = 'A' LEFT JOIN SYS_SYSTEM_TYPE SST ON SST.type_status = 'A' AND SST.sys_type = 'invest_suit_type' AND SST.type_value = VHMP.invest_suitability_class WHERE ( VWBAH.t_qty <> 0 OR VWBAH.tn_qty <> 0 OR VWBAH.on_hold_qty <> 0 OR VWBAH.tn_qty <> 0 ) AND 1=1"+ totalCondition;

		ArrayList<Bean_D0400_TotalMaster> totalMasterBeanList = new ArrayList<Bean_D0400_TotalMaster>();
		Bean_D0400_TotalMaster[] arrayBEANTotal = null;
		try {
			Connection conn = new DBConnectionUtil().getConnection("group1");

			// 建立Statement对象
			stmt_subreportbeans_cash = conn.prepareStatement(sql_subreportbeans_cash);
			stmt_subreportbeans_holding = conn.prepareStatement(sql_subreportbeans_holding);
			stmt_totalmasterbean = conn.prepareStatement(sql_totalmasterbean);
			
			ColumnReflectionUtil columnReflectionUtil = new ColumnReflectionUtil();
			/**
			 * ResultSet executeQuery(String sql) throws SQLException 执行给定的
			 * SQL语句，该语句返回单个 ResultSet 对象
			 */
			rs_totalmasterbean = stmt_totalmasterbean.executeQuery();
			ArrayList<Object> totalMasterList = (ArrayList<Object>) columnReflectionUtil.reflect(Bean_D0400_TotalMaster.class, rs_totalmasterbean);

			rs_subreportbeans_cash = stmt_subreportbeans_cash.executeQuery();
			ArrayList<Object> cashBalanceList = (ArrayList<Object>) columnReflectionUtil.reflect(Bean_D0400_CashBalance.class, rs_subreportbeans_cash);

			rs_subreportbeans_holding = stmt_subreportbeans_holding.executeQuery();
			ArrayList<Object> stockHoldingList = (ArrayList<Object>) columnReflectionUtil.reflect(Bean_D0400_StockHolding.class, rs_subreportbeans_holding);

			int total_size = totalMasterList.size();
			int cash_size = cashBalanceList.size();
			int stock_size = stockHoldingList.size();
			log.info("totalMasterList的总个数是--->" + total_size + "---cashBalanceList的总个数是--->" + cash_size+ "---stockHoldingList的总个数是--->" + stock_size);

			for (int i = 0; i < total_size; i++) {
				Bean_D0400_TotalMaster bean_D0400_TotalMaster = (Bean_D0400_TotalMaster) totalMasterList.get(i);
				String account_no = bean_D0400_TotalMaster.getAccount_no();

				ArrayList<Bean_D0400_CashBalance> cashBalanceBeanList = new ArrayList<Bean_D0400_CashBalance>();
				for (int j = 0; j < cash_size; j++) {
					Bean_D0400_CashBalance cashBalanceBean = (Bean_D0400_CashBalance) cashBalanceList.get(j);
					String account_no_cash = cashBalanceBean.getAccount_no_cash(); 

					if (account_no_cash.equals(account_no) && account_no_cash != null && account_no_cash != "") {
						cashBalanceBeanList.add(cashBalanceBean);
					}
				}

				ArrayList<Bean_D0400_StockHolding> stockHoldingBeanList = new ArrayList<Bean_D0400_StockHolding>();
				for (int k = 0; k < stock_size; k++) {
					Bean_D0400_StockHolding stockHoldingBean = (Bean_D0400_StockHolding) stockHoldingList.get(k);
					String account_no_holding = stockHoldingBean.getAccount_no_holding(); 

					if (account_no_holding.equals(account_no) && account_no_holding != null && account_no_holding != "") {
						stockHoldingBeanList.add(stockHoldingBean);
					}
				}

				if (stockHoldingBeanList != null || cashBalanceBeanList != null) {
					bean_D0400_TotalMaster.setStockHoldingBeanList(stockHoldingBeanList);
					bean_D0400_TotalMaster.setCashBalanceBeanList(cashBalanceBeanList);
					totalMasterBeanList.add(bean_D0400_TotalMaster);
				}
			}
			
			if (rs_totalmasterbean != null || rs_subreportbeans_holding != null || rs_subreportbeans_cash != null) {
				rs_totalmasterbean.close();
				rs_totalmasterbean = null;
				rs_subreportbeans_cash.close();
				rs_subreportbeans_cash = null;
				rs_subreportbeans_holding.close();
				rs_subreportbeans_holding = null;
			}
			if (stmt_totalmasterbean != null || stmt_subreportbeans_cash != null || stmt_subreportbeans_holding != null) {
				stmt_totalmasterbean.close();
				stmt_totalmasterbean = null;
				stmt_subreportbeans_cash.close();
				stmt_subreportbeans_cash = null;
				stmt_subreportbeans_holding.close();
				stmt_subreportbeans_holding = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("数据库查询失败");
		}

		int toatlBEANSize = totalMasterBeanList.size();
		arrayBEANTotal = totalMasterBeanList.toArray(new Bean_D0400_TotalMaster[toatlBEANSize]);

		log.info("返回的数组元素个数是：" + arrayBEANTotal.length + "个！");
		return arrayBEANTotal;
	}

	public ReportResult generateFile(FilterCriteria[] filterCriteriaArray, String fileType) {
		log.info("Jump into Controller_D0400 class......");

		Bean_D0400_TotalMaster[] beanArray = this.generateBeanArray(filterCriteriaArray);

		GenerateFileUtil genereateFileUtil = new GenerateFileUtil();

		String[] jrxml = {"mainreport","subreport_cashbalance","subreport_stockholding"};
		return genereateFileUtil.generateFile(beanArray, fileType, jrxml);
	}
}