package com.webservice.reportController.JS0200;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.FilterCriteria;
import com.webservice.factoryController.ReportResult;
import com.webservice.reportController.JS0100.Bean_HKSBL_MARGIN_OUTSTANDING;
import com.webservice.reportUtils.ColumnReflectionUtil;
import com.webservice.reportUtils.DBConnectionUtil;
import com.webservice.reportUtils.GenerateCriteriaUtil;
import com.webservice.reportUtils.GenerateFileUtil;

public class Controller_JS0200 {

	public static final Log logger = LogFactory.getLog(Controller_JS0200.class.getName());

	public Bean_List_Of_Special_Margin_Ratio_Client[] generateBeanArray() {

		logger.info("Begin generating BeanArray for the report in Controller_JS0200 class...");

		PreparedStatement stmt_BEAN;
		ResultSet rs_BEAN = null;

		String sql_BEAN = "SELECT vbah.account_no  AS accountNo,        main_account_name  AS accountName,        ( p.exchange_code + '-' + p.product_code )        AS productCode,        p.product_type    AS productType,        p.product_name    AS productName,        Cast(Round(vbah.tn_qty, 4) AS DECIMAL(18, 2))  AS tn_Qty,        Cast(Round(p.close_price, 10) AS DECIMAL(18, 4))  AS closePrice,        Cast(Round(vbah.tn_qty * p.close_price, 4) AS DECIMAL(18, 2))   AS marketValue,        Cast(Round(p.margin_rate, 4) AS DECIMAL(18, 2))  AS marginRate,        Cast(Round(Isnull(fm.margin_rate, p.margin_rate), 4) AS DECIMAL(18, 2))  AS specialRate,    Cast(Round(vbah.tn_qty * p.margin_rate / 100 * p.close_price, 4) AS DECIMAL(18, 2))    AS marginableValue,    Cast(Round(vbah.tn_qty * Isnull(fm.margin_rate, p.margin_rate) / 100 * p.close_price, 4) AS DECIMAL(18, 2))  AS marginableValue2,        Cast(Round(( vbah.tn_qty * p.margin_rate / 100 * p.close_price ) - ( vbah.tn_qty * Isnull(fm.margin_rate, p.margin_rate) / 100 * p.close_price ), 4) AS DECIMAL(18, 2)) AS difference FROM   view_bal_account_holding vbah        JOIN mst_product p WITH (nolock)    ON vbah.exchange_code = p.exchange_code    AND vbah.product_code = p.product_code     JOIN mst_main_account mma WITH (nolock)      ON vbah.account_no = mma.main_account_no     AND mma.chk_status = 'A'      AND mma.main_account_type = 'M'    LEFT OUTER JOIN mst_main_account_special_margin fm WITH (nolock)     ON fm.main_account_no = mma.main_account_no    AND fm.exchange_code = vbah.exchange_code      AND fm.product_code = vbah.product_code      AND vbah.exchange_code = 'SEHK'    AND fm.chk_status = 'A' WHERE  vbah.account_no IN (SELECT DISTINCT main_account_no     FROM   mst_main_account_special_margin WITH (nolock)     WHERE  chk_status = 'A')    AND vbah.tn_qty <> 0 ORDER  BY vbah.account_no ";

		logger.info("JS0200完整的查询语句是---->" + sql_BEAN);

		Bean_List_Of_Special_Margin_Ratio_Client[] arrayBEANTotal = null;
		try {
			String connectionCondition = "group1";
			Connection conn = new DBConnectionUtil().getConnection(connectionCondition);

			stmt_BEAN = conn.prepareStatement(sql_BEAN);
			ColumnReflectionUtil columnReflectionUtil = new ColumnReflectionUtil();
			/**
			 * ResultSet executeQuery(String sql) throws SQLException 执行给定的
			 * SQL语句，该语句返回单个 ResultSet 对象
			 */
			rs_BEAN = stmt_BEAN.executeQuery();
			ArrayList<Object> totalBEANList = (ArrayList<Object>) columnReflectionUtil
					.reflect(Bean_List_Of_Special_Margin_Ratio_Client.class, rs_BEAN);

			int BEAN_size = totalBEANList.size();
			logger.info("totalMasterList的总个数是--->" + BEAN_size);
			arrayBEANTotal = totalBEANList.toArray(new Bean_List_Of_Special_Margin_Ratio_Client[BEAN_size]);

			if (rs_BEAN != null) {
				rs_BEAN.close();
				rs_BEAN = null;
			}
			if (stmt_BEAN != null) {
				stmt_BEAN.close();
				stmt_BEAN = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("数据库查询失败");
		}

		logger.info("返回的数组元素个数是：" + arrayBEANTotal.length + "个！");
		return arrayBEANTotal;
	}

	public ReportResult generateFile(String fileType) {
		logger.info("Jump into Controller_JS0200 class......");

		Bean_List_Of_Special_Margin_Ratio_Client[] beanArray = this.generateBeanArray();

		GenerateFileUtil genereateFileUtil = new GenerateFileUtil();
		String[] jrxmlNameArray = { "SPECIAL_MARGIN_RATIO" };
		return genereateFileUtil.generateFile(beanArray, fileType, jrxmlNameArray);
	}

}
