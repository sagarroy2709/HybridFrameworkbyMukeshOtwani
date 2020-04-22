package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	 XSSFWorkbook wb;
	
	//****************Contructor***********************************************
	public  ExcelDataProvider(){
		
		File src=new File("./TestData/TestData.xlsx");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
		 catch (Exception e) {
			
			System.out.println("Unable to read the excel file"+e.getMessage());
		}
	}
	//*********************************************************************
	//**************Method Overloading *******************************
	public String getStringData(String Sheetname,int row,int col){
			
			return wb.getSheet(Sheetname).getRow(row).getCell(col).getStringCellValue();
			
			
		}
	public String getStringData(int Sheetnum,int row,int col){
			
	return wb.getSheetAt(Sheetnum).getRow(row).getCell(col).getStringCellValue();
			
			
		}
	public double getNumData(String Sheetname,int row,int col){
	
	return wb.getSheet(Sheetname).getRow(row).getCell(col).getNumericCellValue();
	
	
}
		
	}

