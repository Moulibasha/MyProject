package com.vtiger.genericLib;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {

	@Test
	public static int generateRandomNumber()
	{
		Random r=new Random();
		int number = r.nextInt(500);
		return number;
	}
	
	
}
