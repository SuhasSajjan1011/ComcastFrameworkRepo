package com.comcast.crm.generic.listenerutility1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.baseutility.BaseClass;

public class ListImpClass1 implements ITestListener, ISuiteListener
{
	public void onStart(ISuite suite)
	{
		System.out.println("Report configuration");
	}
	
	public void onFinish(ISuite suite)
	{
		System.out.println("Report backup");
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("========= =========>"+result.getMethod().getMethodName()+">====START=====");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("========= =========>"+result.getMethod().getMethodName()+">====END=====");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getMethod().getMethodName();
		
		String time = new Date().toString().replace(":","_").replace(" ","_");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File("./Screenshot/"+testName+".png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}
	public void onStart(ITestContext context)
	{
	}
		
}


