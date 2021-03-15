package com.vtiger.genericutility;

import java.io.IOException;

import org.apache.xmlbeans.impl.regex.REUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListenerIMP implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getMethod().getMethodName());
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName());
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
	}
	
	
	public void onStart(ITestContext context)
	{
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter("./Extentreport.html");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setDocumentTitle("Vtiger app");
		
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("OS", "Windows 10 Home");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Reporter", "Arvind");
	}
	
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL,result.getThrowable());
		String date=new Javautility().getcurrentsystemdate().replace(" ", "_").replace(":","_");

		Webdriverutility wb=new Webdriverutility();
	try
		{
		String path = wb.takescreenshot(result.getMethod().getMethodName()+date);
		test.addScreenCaptureFromPath(path);
		}
	catch(IOException e)
		{
		e.printStackTrace();
		
		}
	}
	
	/**
	 * public void onTestFailure(ITestResult result)
	{
		String date=new Javautility().getcurrentsystemdate().replace(" ", "_").replace(":","_");
	try
	{
		Webdriverutility wb=new Webdriverutility();
		wb.takescreenshot(result.getMethod().getMethodName()+date);
	}
	catch(IOException e)
	{
		e.printStackTrace();
		
	}
	}
	**/
	 
}
