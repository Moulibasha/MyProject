package TestScripts_21_25;

import org.testng.annotations.Test;

public class SampleTest2 {
	@Test(retryAnalyzer=com.vtiger.genericLib.RetryAnalyzer.class)
	public void retryTest()
	{
		System.out.println(10/0);
	}
}
