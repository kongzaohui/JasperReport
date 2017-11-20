package com.webservice.reportUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.components.logger.LogFactory;
import org.apache.commons.logging.Log;

public class ColumnReflectionUtil {
	
	protected static final Log log = LogFactory.getLog(ColumnReflectionUtil.class.getName());

	// passClass是pass bean class
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	public List<Object> reflect(Class passClass,ResultSet resultSet){
		log.info("Jump into <ColumnReflectionUtil> to generate beans from the ResultSet...");

		//returnList类似ArrayList<Object> totalMasterList = new ArrayList<Object>();
		List<Object> returnList = null;
		
		try{
	        //no paramater
	    	Class noparams[] = {};
	    	
	        //String parameter
	    	Class[] paramString = new Class[1];
	    	paramString[0] = String.class;
	    	
	    	//int parameter
	    	Class[] paramInt = new Class[1];
	    	paramInt[0] = Integer.class;
	    	
	    	//BigDecimal parameter
	    	Class[] paramBigDecimal = new Class[1];
	    	paramBigDecimal[0] = BigDecimal.class;
	    	
	    	//pass in the class
	    	Class cls = passClass;
	    	String passClassName = passClass.getName();

	    	Method method = null;

			//collect the methods in the passed bean Class
	    	//String是setter的名字，class是返回的类型，即成员的类�?
	        Map<String,Class> methodTypeMap = new HashMap<String,Class>();
	        Class type = null;

	        Date nullDate = null;
	        
	        //获取�?有的methods in the passed Class parameter
	    	Method[] methodArray = cls.getMethods();
	    	
	    	for(Method methodObj : methodArray){
	    		//System.out.println("method name:"+methodObj.getName());
	    		//String：setCompany_name；Class：String
	    		if(methodObj.getName().startsWith("set")){
	    			type = methodObj.getParameterTypes()[0];
	    			methodTypeMap.put(methodObj.getName(), type);
	    		}else{
	    			//getter do later
	    		}
	    	}
	    	
	    	ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); //获得列集
            int colCount = resultSetMetaData.getColumnCount();  //获得列的个数
            log.info(passClassName + "的resultSetMetaData列的个数，即此类中的元素个数是--->" + colCount);

	    	//List<Map<String,Object>> src = resultSet.;
            //keyList放入各栏的名�?
	    	List<String> keyList = new ArrayList<String>();
	    	for (int j = 1; j <= colCount; j++) {
				String columnName = resultSetMetaData.getColumnLabel(j);
				//System.out.println("获得的列名是--->" + columnName);
				keyList.add(columnName);
			}

	    	Object classObj = null;
	    	Class setterClass = null;
	        String setterFuncName = null;

	        //New object
    		if(returnList == null){
    			returnList = new ArrayList<Object>();
    		}

	        while (resultSet.next()){

	        	//新建passedClass对象，即新建bean对象,即new Bean_D0400_TotalMaster()
				classObj = cls.newInstance();
		      	//得到�?个row
		      	try{

		        	for(String columnName : keyList){
						//先得到列名所对应的类型columnName
				
						//获取列名对应的setter,是String,即setCompany_name
						setterFuncName = "set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1);
						//System.out.println("funciton name:"+setterFuncName);
						//获取此方法返回的类型，即Class是String
						setterClass = methodTypeMap.get(setterFuncName);
						//System.out.println("what is class:"+setterClass.getName());
		
						if( setterClass.isInstance(int.class)){
							//System.out.println( "is int class");
							//method是Method对象实例，即setCompany_name，paramInt是参数数组Class[]，里面只有Integer.class
							method = cls.getDeclaredMethod(setterFuncName, paramInt);
							//method.invoke返回int�?
							method.invoke(classObj, resultSet.getInt(columnName));
						}
						else if(setterClass.getName().equals("java.math.BigDecimal")){
							//System.out.println( "is java.math.BigDecimal class");
							method = cls.getDeclaredMethod(setterFuncName, paramBigDecimal);
							method.invoke(classObj, resultSet.getBigDecimal(columnName));
						}
						else {
							//System.out.println( "is Default string class");
							method = cls.getDeclaredMethod(setterFuncName, paramString);
							method.invoke(classObj, resultSet.getString(columnName));
						} 
			        }
						
					returnList.add(classObj);
			        	
		        	}catch(Exception ex){
		        		log.error("Exception for : "+setterFuncName);
		        		ex.printStackTrace();
		    		}
	        	
	        }
	        
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			return returnList;
	}
}
}
