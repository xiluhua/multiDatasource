package com.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.test.dao.TestDao;

public class Main {
	
	private final static Log logger = LogFactory.getLog(Main.class.getName());
	
	public static void main(String[] args)
	{
		long a = System.currentTimeMillis();
		//初始化配置
		Configuration.getInstance();
		logger.info("测试开始。。。。");
		//初始化基础数据
		TestDao test = (TestDao)SpringApplicationContext.getBean("testDao");
		List<TestModel> result1 = test.findTest1();
		logger.info("result1："+result1);
		List<TestModel> result2 = test.findTest2();
		logger.info("result2："+result2);
		
		long z = System.currentTimeMillis();
		z = (z-a);
		logger.info("测试结束。。。。用时："+z+"毫秒");
	}
	
}



