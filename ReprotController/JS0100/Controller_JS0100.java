package com.webservice.reportController.JS0100;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.ReportResult;
import com.webservice.reportUtils.ColumnReflectionUtil;
import com.webservice.reportUtils.DBConnectionUtil;
import com.webservice.reportUtils.GenerateFileUtil;

public class Controller_JS0100 {

	public static final Log logger = LogFactory.getLog(Controller_JS0100.class.getName());

	public Bean_HKSBL_MARGIN_OUTSTANDING[] generateBeanArray() {

		logger.info("Begin generating BeanArray for the report in Controller_JS0100 class...");

		PreparedStatement stmt_BEAN;
		ResultSet rs_BEAN = null;

		String sql_BEAN = "SELECT sbl.exchange_code                             AS exchangeCode,        sbl.product_code                              AS productCode,        p.product_name                                AS productName,        Cast(Round(h.t_qty, 0) AS DECIMAL(18, 0))     AS t_Qty,        Cast(Round(h.t1_qty, 0) AS DECIMAL(18, 0))    AS t1_Qty,        Cast(Round(h.t2_qty, 0) AS DECIMAL(18, 0))    AS t2_Qty,        Cast(Round(Sum(os_qty), 0) AS DECIMAL(18, 0)) AS qtyLent FROM   iboss_sub.dbo.view_sbl_all_trans sbl WITH (nolock),        (SELECT vbah.exchange_code,                vbah.product_code,                Sum(vbah.t_qty)  AS t_qty,                Sum(vbah.t1_qty) AS t1_qty,                Sum(vbah.t2_qty) AS t2_qty         FROM   mst_main_account ma WITH (nolock)                INNER JOIN mst_account a WITH (nolock)                        ON ma.chk_status = 'A'                           AND ma.main_account_type = 'M'                           AND a.chk_status = 'A'                           AND a.main_account_no = ma.main_account_no                INNER JOIN view_bal_account_holding vbah WITH (nolock)                        ON vbah.exchange_code = 'SEHK'                           AND vbah.account_no = a.account_no         GROUP  BY vbah.exchange_code,                   vbah.product_code) AS h,        iboss2.dbo.mst_product p WITH (nolock)  WHERE  sbl.counterparty = 'HOUSE'        AND sbl.os_qty > 0        AND sbl.chk_status <> 'D'        AND h.exchange_code = sbl.exchange_code        AND h.product_code = sbl.product_code        AND p.exchange_code = sbl.exchange_code        AND p.product_code = sbl.product_code        AND p.chk_status = 'A'  and 1=1"
				+ "GROUP  BY sbl.exchange_code,           sbl.product_code,           p.product_name,           h.t_qty,           h.t1_qty,           h.t2_qty ORDER  BY sbl.product_code";
		logger.info("JS0100完整的查询语句是---->" + sql_BEAN);

		Bean_HKSBL_MARGIN_OUTSTANDING[] arrayBEANTotal = null;
		try {
			Connection conn = new DBConnectionUtil().getConnection("group2");

			stmt_BEAN = conn.prepareStatement(sql_BEAN);
			ColumnReflectionUtil columnReflectionUtil = new ColumnReflectionUtil();
			/**
			 * ResultSet executeQuery(String sql) throws SQLException 执行给定的
			 * SQL语句，该语句返回单个 ResultSet 对象
			 */
			rs_BEAN = stmt_BEAN.executeQuery();
			ArrayList<Object> totalBEANList = (ArrayList<Object>) columnReflectionUtil
					.reflect(Bean_HKSBL_MARGIN_OUTSTANDING.class, rs_BEAN);

			int BEAN_size = totalBEANList.size();
			logger.info("totalMasterList的总个数是--->" + BEAN_size);
			
			arrayBEANTotal = totalBEANList.toArray(new Bean_HKSBL_MARGIN_OUTSTANDING[BEAN_size]);

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
		logger.info("Jump into Controller_JS0100 class......");

		Bean_HKSBL_MARGIN_OUTSTANDING[] beanArray = this.generateBeanArray();

		GenerateFileUtil genereateFileUtil = new GenerateFileUtil();
		String[] jrxmlNameArray = {"HKSBL_MARGIN_OUTSTANDING"};
		return genereateFileUtil.generateFile(beanArray,fileType,jrxmlNameArray);
	}
}