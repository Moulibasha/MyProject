package com.vtiger.genericLib;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class JSONFileUtility {

	@Test
	public String jsonFileUtility(String key) throws Throwable
	{
		FileReader fir=new FileReader(IPathConsts.JSON_PATH);
		JSONParser parser = new JSONParser();
		Object jObj = parser.parse(fir);
		@SuppressWarnings("rawtypes")
		HashMap obj=(HashMap)jObj;
		Object value = obj.get(key);
		return (String) value;
		
	}
}
