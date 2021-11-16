package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImp implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String PassedTestCaseName = result.getMethod().getMethodName();
		System.out.println(PassedTestCaseName+ "is PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String failedTestCaseName = result.getMethod().getMethodName();
		String currentDate = new Date().toString().replace(" ", "_").replace(":", "_");
		EventFiringWebDriver ed = new EventFiringWebDriver(BaseTest.driver);
		File src = ed.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+failedTestCaseName+currentDate+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
