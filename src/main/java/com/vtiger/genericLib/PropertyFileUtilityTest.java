package com.vtiger.genericLib;

import java.io.FileInputStream;

import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFileUtilityTest {

	@Test
	public String propertyFileUtilityTest(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConsts.PROP_PATH);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
}
