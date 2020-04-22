package com.learnautomation.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.FileChooserUI;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screeshot,Alerts,Frames,Windows,Sync,issue,Javascriptexecutor
	
	public static String TakeScreenshot(WebDriver driver,String errorpage){
		
		String Screenshotpath="./Screenshots/"+errorpage+"_"+getcurrentDateTime()+".jpeg";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File(Screenshotpath));
			
			
			} catch (Exception e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return Screenshotpath;
		
		
	}
	
	public static String  getcurrentDateTime(){
		
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		
		return customformat.format(currentDate);
	}

}
