package com.webservice.reportUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

public class DBConnectionUtil {
	
	protected static final Log log = LogFactory.getLog(DBConnectionUtil.class.getName());
	
	public Connection getConnection(String connectionCondition) {
		
		Connection conn = null;
		
		try {
			
			String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			//int num = t.indexOf(".metadata");
			int num = t.indexOf("WebServiceForReport");
			log.info("server��ȡ���ݿ��t��------>" + t + num);
			String configPath = t.substring(1, num).replace('/', '\\')
					+ "WebServiceForReport\\WebContent\\config.properties";
			log.info("server��ȡ���ݿ��configPath��------>" + configPath);

			Properties properties = new Properties();
			//InputStream in = DBConnectionUtil.class.getClassLoader().getResourceAsStream("config.properties");
			InputStream in = new FileInputStream(configPath);
			properties.load(in);

			String dbDriver = properties.getProperty("dbDriver");
			String dbUrl = null;
			String dbName = null;
			String dbPassword = null;
			
			if (connectionCondition.equals("group1")) {
			    dbUrl = properties.getProperty("dbUrl");
				dbName = properties.getProperty("dbName");
				dbPassword = properties.getProperty("dbPassword");
				
			} else if (connectionCondition.equals("group2")) {
				dbUrl = properties.getProperty("dbUrl2");
				dbName = properties.getProperty("dbName2");
				dbPassword = properties.getProperty("dbPassword2");
			}
			
			log.info("dbDriver-->" + dbDriver + "--dbUrl-->" + dbUrl+"--dbName-->" + dbName+"--dbPassword-->" + dbPassword);

			Class.forName(dbDriver);
			// �������ݿ�
			conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
			
			}
		catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			log.error("���ݿ��ѯʧ��");
		}
		return conn;	
	}
}
