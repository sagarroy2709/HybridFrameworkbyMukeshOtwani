package com.learnautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
	
	
	@FindBy(name="txtuId") WebElement usrname;
	@FindBy(name="txtPword") WebElement pwd;
	@FindBy(name="login") WebElement loginbutton;

	
	public void logintoprimusbank(String username,String password){
		
		usrname.sendKeys(username);
		pwd.sendKeys(password);
		loginbutton.click();
		
		
	
	}

}
