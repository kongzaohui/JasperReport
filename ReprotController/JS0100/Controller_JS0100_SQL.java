package com.webservice.reportController.JS0100;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.ReportResult;
import com.webservice.reportUtils.ColumnReflectionUtil;
import com.webservice.reportUtils.DBConnectionUtil;
import com.webservice.reportUtils.GenerateFileUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

public class Controller_JS0100_SQL {

	public static final Log logger = LogFactory.getLog(Controller_JS0100_SQL.class.getName());

	public void generateFile() {

		logger.info("Begin generating BeanArray for the report in Controller_JS0100 class...");

		String sql_BEAN = "SELECT sbl.exchange_code                             AS exchangeCode,        sbl.product_code                              AS productCode,        p.product_name                                AS productName,        Cast(Round(h.t_qty, 0) AS DECIMAL(18, 0))     AS t_Qty,        Cast(Round(h.t1_qty, 0) AS DECIMAL(18, 0))    AS t1_Qty,        Cast(Round(h.t2_qty, 0) AS DECIMAL(18, 0))    AS t2_Qty,        Cast(Round(Sum(os_qty), 0) AS DECIMAL(18, 0)) AS qtyLent FROM   iboss_sub.dbo.view_sbl_all_trans sbl WITH (nolock),        (SELECT vbah.exchange_code,                vbah.product_code,                Sum(vbah.t_qty)  AS t_qty,                Sum(vbah.t1_qty) AS t1_qty,                Sum(vbah.t2_qty) AS t2_qty         FROM   mst_main_account ma WITH (nolock)                INNER JOIN mst_account a WITH (nolock)                        ON ma.chk_status = 'A'                           AND ma.main_account_type = 'M'                           AND a.chk_status = 'A'                           AND a.main_account_no = ma.main_account_no                INNER JOIN view_bal_account_holding vbah WITH (nolock)                        ON vbah.exchange_code = 'SEHK'                           AND vbah.account_no = a.account_no         GROUP  BY vbah.exchange_code,                   vbah.product_code) AS h,        iboss2.dbo.mst_product p WITH (nolock)  WHERE  sbl.counterparty = 'HOUSE'        AND sbl.os_qty > 0        AND sbl.chk_status <> 'D'        AND h.exchange_code = sbl.exchange_code        AND h.product_code = sbl.product_code        AND p.exchange_code = sbl.exchange_code        AND p.product_code = sbl.product_code        AND p.chk_status = 'A'  and 1=1"
				+ "GROUP  BY sbl.exchange_code,           sbl.product_code,           p.product_name,           h.t_qty,           h.t1_qty,           h.t2_qty ORDER  BY sbl.product_code";
		logger.info("JS0100完整的查询语句是---->" + sql_BEAN);

		try {
			String reportName = "myreport";
			Map<String, Object> parameters = new HashMap<String, Object>();

			Connection conn = new DBConnectionUtil().getConnection("group2");

			String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			logger.info("得到的t相关资源的路径是------>" + t);
			// int num = t.indexOf(".metadata");
			int num = t.indexOf("WebServiceForReport");
			String jasperResourePath = t.substring(1, num).replace('/', '\\')
					+ "WebServiceForReport\\WebContent\\jasperResource\\";

			JasperReport report = JasperCompileManager
					.compileReport(jasperResourePath + "HKSBL_MARGIN_OUTSTANDING_2.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(report, parameters, conn);
			JasperViewer.viewReport(jp, false);

			// exports report to pdf
			JasperCompileManager.compileReportToFile(jasperResourePath + "HKSBL_MARGIN_OUTSTANDING_2.jrxml");
			String sourceFileName = jasperResourePath + "HKSBL_MARGIN_OUTSTANDING_2.jasper";
			String printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameters, conn);
			logger.info("printFileName-------->" + printFileName);

			if (printFileName != null) {
				// JasperPrintManager.printReport( printFileName, true);
				/** 1- export to PDF */
				String pdfFileSuffix = ".pdf";
				String pdfOutputFileName = "C:\\Users\\zanderkong\\Desktop\\HKSBL_MARGIN_OUTSTANDING_2" + pdfFileSuffix;
				JasperExportManager.exportReportToPdfFile(printFileName, pdfOutputFileName);
				logger.info("pdf文件输出完毕！");
				}

		} catch (JRException e) {
			e.printStackTrace();
			logger.error("数据库查询失败");
		}
	}
}
