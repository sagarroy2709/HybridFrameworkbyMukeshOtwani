package com.learnautomation.pages;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider exeldata;
	public ConfigDataProvider confdata;
	public ExtentReports reports;
	public ExtentTest logger;
	
	
	
	@BeforeSuite///All the TestNG Annotation being used and its importance
	public void SetupSuite(){
		
		Reporter.log("Setting up the reports and test is getting ready", true);//This is for our reference
		
		 exeldata=new ExcelDataProvider();
		 confdata=new ConfigDataProvider();
		 
		 ExtentHtmlReporter extent=new ExtentHtmlReporter("./Reports/PrimusBank_"+Helper.getcurrentDateTime()+".html");
		 reports=new ExtentReports();
		 reports.attachReporter(extent);
		 
		 Reporter.log("Settup completed and Test can be started", true);
	}
	
	
	
	
	@BeforeClass
	public void setup(){
		
		Reporter.log("Starting the browser and application is getting ready", true);
		
		driver=BrowserFactory.start_application(driver,confdata.getBrowser(),confdata.getStagingurl());
		
		Reporter.log("Browser and Application is up and running", true);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException{
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.TakeScreenshot(driver,result.getName());
			try {
				logger.fail(result.getName()+" Testcase is failed",
						MediaEntityBuilder.createScreenCaptureFromPath("."+Helper.TakeScreenshot(driver, result.getName())).build());
			} catch (Exception e) {
				
				System.out.println("The screenshot is not available"+e.getMessage());
			}
		}else
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass(result.getName()+" Test is Passed ");
		}else
			if(result.getStatus()==ITestResult.SKIP)
			{
				logger.skip(result.getName()+" For somereason the testcase skipped ");
			}
		reports.flush();
		
		Reporter.log("Test completed and reports are generated ", true);
	}
	@AfterClass
public void teartown(){
		BrowserFactory.stop_application(driver);
}
}
