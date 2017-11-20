package com.webservice.reportUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

import com.webservice.factoryController.ReportResult;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

public class GenerateFileUtil {

	protected static final Log log = LogFactory.getLog(GenerateFileUtil.class.getName());

	public ReportResult generateFile(Object[] beanObject, String fileType, String[] jrxmlNameArray) {

		log.info("Jump into GenerateFileUtil class to generate PDF or CSV files for the report...");

		JRBeanArrayDataSource beanArrayDataSource = new JRBeanArrayDataSource(beanObject);

		String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		log.info("得到的t相关资源的路径是------>" + t);
		int num = t.indexOf(".metadata");
		//int num = t.indexOf("WebServiceForReport");
		String jasperResourePath = t.substring(1, num).replace('/', '\\')
				+ "WebServiceForReport\\WebContent\\jasperResource\\";
		log.info("得到的jasperResoure相关资源的路径是------>" + jasperResourePath + "截取的index是----->" + num);

		log.info("Start Compiling the Report Designed by iReport in the JasperResoure Path...");
		String sourceFileName = jasperResourePath + jrxmlNameArray[0] + ".jasper";
		int jrxmlNameArrayLength = jrxmlNameArray.length;

		String mainReportName = jasperResourePath + jrxmlNameArray[0] + ".jrxml";

		try {
			if (jrxmlNameArrayLength == 1) {
				/**
				 * Compile the report to a file name same as the JRXML file name
				 */
				JasperCompileManager.compileReportToFile(mainReportName);
			}

			else {
				String subreportName1 = jasperResourePath + jrxmlNameArray[1] + ".jrxml";
				String subreportName2 = jasperResourePath + jrxmlNameArray[2] + ".jrxml";

				JasperCompileManager.compileReportToFile(mainReportName);
				JasperCompileManager.compileReportToFile(subreportName1);
				JasperCompileManager.compileReportToFile(subreportName2);
			}
		} catch (JRException e) {
			e.printStackTrace();
		}

		log.info("Done compiling...Start getting data from database！！！");

		ReportResult reportResult = new ReportResult();
		Map pdfParameters = new HashMap();
		String printFileName = null;
		String returnFileName = null;

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = dateFormat.format(date);
		dateString = dateString.replace(" ", "");
		dateString = dateString.replace(":", "");
		dateString = dateString.replace("-", "");
		log.info("为pdf或csv文件准备的时间后缀是------>" + dateString);

		String filePrefix = "C:\\Users\\zanderkong\\Desktop\\server_" + jrxmlNameArray[0] + "_";

		try {
			printFileName = JasperFillManager.fillReportToFile(sourceFileName, pdfParameters, beanArrayDataSource);
			log.info("printFileName-------->" + printFileName);

			if (printFileName != null && (fileType.equals("PDF") || fileType.equals("pdf"))) {
				// JasperPrintManager.printReport( printFileName, true);
				/** 1- export to PDF */
				String pdfFileSuffix = ".pdf";
				String pdfOutputFileName = filePrefix + dateString + pdfFileSuffix;
				JasperExportManager.exportReportToPdfFile(printFileName, pdfOutputFileName);
				log.info("pdf文件输出完毕！");

				returnFileName = pdfOutputFileName;

				/** 2- export to Excel sheet */
				/*
				 * JRXlsExporter xlsExporter = new JRXlsExporter();
				 * xlsExporter.setExporterInput(new
				 * SimpleExporterInput(printFileName));
				 * xlsExporter.setExporterOutput(new
				 * SimpleOutputStreamExporterOutput(
				 * "C://Users/zanderkong/Desktop/sample_total_master_report.xls"
				 * )); SimpleXlsReportConfiguration xlsConfiguration = new
				 * SimpleXlsReportConfiguration();
				 * 
				 * xlsConfiguration.setOnePagePerSheet(false);
				 * xlsConfiguration.setDetectCellType(true);
				 * xlsConfiguration.setCollapseRowSpan(false);
				 * xlsConfiguration.setWhitePageBackground(false);
				 * xlsConfiguration.setRemoveEmptySpaceBetweenRows(true);
				 * xlsConfiguration.setRemoveEmptySpaceBetweenColumns(true);
				 * //xlsConfiguration.setExporterFilter(filter);
				 * xlsExporter.setConfiguration(xlsConfiguration);
				 * xlsExporter.exportReport();
				 */

			} else if (printFileName != null && (fileType.equals("csv") || fileType.equals("CSV"))) {
				String csvFileSuffix = ".csv";
				String csvOutputFileName = filePrefix + dateString + csvFileSuffix;

				/** 3- export to CSV sheet */
				JRCsvExporter csvExporter = new JRCsvExporter();
				csvExporter.setExporterInput(new SimpleExporterInput(printFileName));
				csvExporter.setExporterOutput(new SimpleWriterExporterOutput(csvOutputFileName));
				SimpleCsvExporterConfiguration csvConfiguration = new SimpleCsvExporterConfiguration();
				csvConfiguration.setRecordDelimiter("\r\n");
				csvConfiguration.setFieldDelimiter(",");
				csvExporter.setConfiguration(csvConfiguration);
				csvExporter.exportReport();

				log.info("csv文件输出完毕！");
				returnFileName = csvOutputFileName;
			} else {
				return null;
			}
		} catch (JRException e) {
			e.printStackTrace();
		}

		log.info("returnFileName------>" + returnFileName);
		Path path = Paths.get(returnFileName);
		byte[] returnFileBytes = null;
		try {
			returnFileBytes = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String message = "Transfer is completed";
		boolean success = true;
		String savedReportName = "C:\\Users\\zanderkong\\Desktop\\client_" + jrxmlNameArray[0] + "_" + dateString
				+ "." + fileType.toLowerCase();

		reportResult.setReportByte(returnFileBytes);
		reportResult.setMessage(message);
		reportResult.setSuccess(success);
		reportResult.setFileType(fileType);
		reportResult.setSavedReportName(savedReportName);

		log.info("reportResult的详细信息是--->" + reportResult.toString());

		log.info("自动发送邮件的附件地址是--->" + returnFileName);

		return reportResult;
	}
}
