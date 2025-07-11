package com.Test_Merchant_Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Test_Merchant_TestCases.Base_Class;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManagar implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	String reportName;

	public void onStart(ITestContext testcontext) {

		String timestamp = new SimpleDateFormat("yyyy.mmmm.dd.hh.mm.ss").format(new Date());
		reportName = "Test_Reports -" + timestamp + ".html";

		// Configuration to change look and feel of reports:

		htmlReporter = new ExtentSparkReporter(".\\Reports\\" + reportName);

		htmlReporter.config().setDocumentTitle("Webplat_Team_Assignment Reports : ");
		htmlReporter.config().setReportName("Webplat_Team_ Testing Reports");
		htmlReporter.config().setTheme(Theme.DARK);

		// Add System Information / Environment information to reports:

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Application", "Webplat_Team_Assignment");
		reports.setSystemInfo("Machine", "TestPc1");

		// reports.setSystemInfo("Os", "Windows 11"); Or
		String os = testcontext.getCurrentXmlTest().getParameter("os");
		reports.setSystemInfo("Operating Sysytem", os);

		// reports.setSystemInfo("Browser","Chrome"); Other Option
		String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("Browser", browser);

		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		reports.setSystemInfo("Environment", "QA");

		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			reports.setSystemInfo("Groups", includedGroups.toString());
		}

	}

	// When test Case get Passed this method is called.
	public void onTestSuccess(ITestResult result) {

		test = reports.createTest(result.getTestClass().getName()); // Create Entry in HTML reports;
		test.assignCategory(result.getMethod().getGroups()); // To display Groups in report
		test.log(Status.PASS, result.getName() + " Got succuessfully Executed ");

	}

	// When test Case get Filed this method is called.
	public void onTestFailure(ITestResult result) {

		// Create Entry in HTML reports;
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName() + " Got Failed ");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgpath = new Base_Class().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgpath);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// When test Case get Skipped this method is called.
	public void onTestSkipped(ITestResult result) {

		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.SKIP, result.getName() + " Got_Skipped ");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	
	// Its Called After All Test case are executed
	public void onFinish(ITestContext testContext) {

		reports.flush();
		String pathOfExtentReport = System.getProperty("user.dir") + "\\Reports\\" + reportName;
		File extentReport = new File(pathOfExtentReport);

		// This below code is used to open Extent Report Automatically :
		try {
			Desktop.getDesktop().browse(extentReport.toURI());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		// The Below code used for Send email of extent Report Automatically :
		 try {
			 URL urlOfReport =new URL("file:///"+System.getProperty("user.dir") + "\\Reports\\" + reportName);
			 
			 // Create the email Message:
			 
			 ImageHtmlEmail email=new ImageHtmlEmail();
			 email.setDataSourceResolver(new DataSourceUrlResolver(url));
			 email.setHostName("smtp.googlegmail.com");  // This only Used for gmail_id It will change according requirement:
			 email.setSmtpPort(465);
			 email.setAuthenticator(new DefaultAuthenticator("   ","     "));  // sender email id and password
			 email.setSSLOnConnect(true);
			 email.setFrom(" ");  // sender Email Id
			 email.setSubject("Test Result");
			 email.setMsg("Please Find The Attached Report.......");
			 email.addTo(""); 			// Receiver Email_Id:
			 email.attach(urlOfReport," extent report","Please Check The Report:");
			 email.send();             // Send The Email
			 
		 }

		  catch(Exception e) {
						e.printStackTrace();
		}
		*/
		
		
		
	}
	

// When test Case get Start this method is called.

	public void onTestStart(ITestResult Result) {

		System.out.println("Name Of Test Mehtod Started : " + Result.getName());

	}

	
	

}
