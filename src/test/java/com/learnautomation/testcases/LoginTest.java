package com.learnautomation.testcases;

import java.util.logging.Logger;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	public LoginPage loginpage;
	
	
		
	@Test(priority=1)
	public void logintest(){
		
		logger=reports.createTest("THe Primus Bank Application started");
		
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		String Username=exeldata.getStringData("LoginDetails", 0, 0);
		String Password=exeldata.getStringData("LoginDetails", 0, 1);
		
		logger.info("Login to PrimusBank Applciation");
		
		loginpage.logintoprimusbank(Username,Password);
		String Adminurl=driver.getTitle();
		if(Adminurl.equalsIgnoreCase("Primus Bank"))
		{
			Assert.assertTrue(true);
			
		}else
		{
			Assert.assertTrue(false);
			
		}
		
		
	}
	
	@Test(priority=2)
	public void logouttest(){
		
		logger=reports.createTest("THe Primus Bank Application started");
		logger.info("Logout to PrimusBank Application");
		Assert.assertTrue(true);
		
		
		
	}
	@Test(priority=3)
	public void refreshtest(){
		
		logger=reports.createTest("THe Primus Bank Application started");
		logger.info("Refresh to PrimusBank Application");
		throw new SkipException("For somereason the testcase skipped");
		
		
		
	}
	
	

}
