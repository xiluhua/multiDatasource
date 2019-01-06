package com.test;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Configuration {

	private Properties confProps = new Properties();

	private static Configuration instance = null;

	private final static Logger logger = Logger.getLogger(Configuration.class.getName()); 

	public static ApplicationContext ctx;
		
	public synchronized static Configuration getInstance()
	{
		if (instance == null)
		{
			instance = new Configuration();
		}
		return instance;
	}

	/**
	 * Constructor
	 */
	private Configuration()
	{
		initLog4j();
		initApplicationContext();
	}
	
	
	/**
	 * 初始化log4j
	 */
	private void initLog4j()
	{
		PropertyConfigurator.configureAndWatch(ConfigConstant.CONFIG_LOG4J_PROPERTIES, ConfigConstant.INTERVAL_LOG4J_WATCH);
	}
	
	/**
	 * 初始化spring
	 */
	@SuppressWarnings("resource")
	private void initApplicationContext(){
		new FileSystemXmlApplicationContext("file:"+ConfigConstant.CONFIG_SPRING_XML);
	}

	/**
	 * 获取property的值
	 * @param key
	 * @return
	 */
	public String getStringValue(String key){
		String val = "0";
		try
		{
			val = confProps.getProperty(key);
		}
		catch (Exception e)
		{
			val = "-1";
			logger.error(key + "获取失败", e);
		}
		return val;
	}
	
//	/**
//	 * 获取property的值
//	 * @param key
//	 * @return
//	 */
//	public int getIntValue(String key){
//
//		String value = getStringValue(key);
//		return Integer.parseInt(value);
//	}
//
//	/**
//	 * 获取property的值
//	 * @param key
//	 * @return
//	 */
//	public boolean getBooleanValue(String key){
//
//		String value = getStringValue(key);
//		return Boolean.parseBoolean(value);
//	}
}
