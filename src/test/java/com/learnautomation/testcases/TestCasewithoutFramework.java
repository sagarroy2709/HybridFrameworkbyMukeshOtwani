package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class TestCasewithoutFramework {
	
	

	@Test
	public void testcase1() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");		
		WebDriver driver=new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
		
		

	}

}
