package com.tcs.ultimatix;


import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class Driver extends Utilities {
	
	public static Properties prop = new Properties();
	public static Workbook wb;
	public static Sheet Testplan;
	public static Sheet TestData;
	public static void KillDriver()
	{
		
		 String pName_IEdriver = "IEDriverServer.exe";
	        String pName_Chromedriver = "chromedriver.exe";
	        //String pName_Geckodriver = "geckodriver.exe";
	        try {
	               if (browserType.equalsIgnoreCase("InternetExplorer")) {
	                     Runtime.getRuntime().exec("TASKKILL /F /IM " + pName_IEdriver);
	                     Thread.sleep(1000);
	                     System.out.println("Killed IE Driver's");
	               } else if (browserType.equalsIgnoreCase("GoogleChrome")) {
	                     Runtime.getRuntime().exec("TASKKILL /F /IM " + pName_Chromedriver);
	                     Thread.sleep(1000);
	                     System.out.println("Killed Chrome Driver's");
	               }

	        } catch (Exception e) {
	        	e.getMessage();
	            System.out.println("File Not present/Incorrect File at location");
	        }
	        
	}
	
	public static void BrowserValue()
	{	
		try{
		InputStream config = new FileInputStream(ConfigFilePath);
		prop.load(config);
		browserType = prop.getProperty("browsername");
		}
		catch(Exception ex)
		{
			System.out.println("Exception:" + ex);
		}
		
	}
	
	public static void GetSanitySheet()
	{				
		File SanitySheet = new File(SanitySheetPath);
		try{
			WorkbookSettings ws = new WorkbookSettings();
			ws.setEncoding("ISO-8859-1");
			wb = Workbook.getWorkbook(SanitySheet, ws);
			Testplan = wb.getSheet("Testplan");
			TestData= wb.getSheet("TestData");
		}
		catch(Exception ex)
		{
			System.out.println("Exception is:" + ex);
		}		
			
		
	}
	
	
	public static void ReadSheet()
	{
		GetSanitySheet();
		// Test plan sheet details retrieval.
			Cell RunMode_cellvalue = Testplan.getCell(1,0);
			BrowserRunMode = RunMode_cellvalue.getContents();
			
			Cell TestcaseName_cellvalue = Testplan.getCell(2,0);
			TestcaseName = TestcaseName_cellvalue.getContents();
			
			Cell iteration_cellvalue = Testplan.getCell(3,0);
			iterationCount = iteration_cellvalue.getContents();
			
			Cell browser_cellvalue = Testplan.getCell(4,0);
			BrowserValue = browser_cellvalue.getContents();
			
			
			//Test data sheet details retrieval.
			Cell Testcase_testdatacell = Testplan.getCell(0,0);
			Testdata_TestcaseName = Testcase_testdatacell.getContents();
			
			Cell gbUsername_cellvalue = Testplan.getCell(1,0);
			gbUsername = gbUsername_cellvalue.getContents();
			
			Cell gbPassword_cellvalue = Testplan.getCell(2,0);
			gbPassword = gbPassword_cellvalue.getContents();
		
	}
	
	public static int GetIterationCount(String testname)
	{
		GetSanitySheet();
		int totalRows= Testplan.getRows();
		int totalColumns = Testplan.getColumns();
		int iterationRow=0;
		int iterationColumn=0;
		
		for (int i=0; i < totalRows; i++)
		{
			for(int j=0; j <totalColumns; j++)
			{
				if(testname.equalsIgnoreCase(Testplan.getCell(j,i).getContents()))
					iterationRow = i;
			}
		}
		
		for (int i=0; i < totalRows; i++)
		{
			for(int j=0; j < totalColumns; j++)
			{
				if((Testplan.getCell(j,i).getContents()).equalsIgnoreCase("iteration"))
					iterationColumn = j;
			}
		}
		
		//retrieving the iteration value for the test case.	
		gbiterationCount = Integer.parseInt((Testplan.getCell(iterationColumn, iterationRow).getContents())); 
		return  gbiterationCount;
	}
	
	public static HashMap<String, String > GetTestInputData(String testname, int iterationCount)
	{
		int totalRows = TestData.getRows();
		String columnHeader = null;
		String columnData = null;
		HashMap<String, String> dataMap = new HashMap<String, String>();		
		
		List<Integer> availableRows = new ArrayList<Integer>();
		int columnValue = GetColumn_TestData(testname);
		for(int i=0; i < totalRows; i++)
		{
			Cell cell_testcasevalue = TestData.getCell(columnValue, i);
		if(testname.equalsIgnoreCase(cell_testcasevalue.getContents()))
			availableRows.add(i);
		}
		
		
		//get data from the column based on the available rows.
		
		
		int availablerow= availableRows.get(iterationCount-1);
			for(int j = (columnValue+1) ; j< TestData.getColumns(); j++)
			{
				 columnHeader = TestData.getCell(j,0).getContents();
				 columnData = TestData.getCell(j,availablerow).getContents();
				 dataMap.put(columnHeader, columnData);
			}
			
		
		
		return dataMap;
	}
	
	public static int GetColumn_TestData(String name)
	{
		int totalRows= TestData.getRows();
		int totalColumns = TestData.getColumns();
		//int testcase_ColumnValue = 0;
		
		for (int i=0; i < totalRows; i++)
		{
			for(int j=0; j <totalColumns; j++)
			{
				if(name.equalsIgnoreCase(TestData.getCell(j,i).getContents()))
				{
					return j;
					//testcase_ColumnValue = i;
					//break;	
				}
				
			}
		}
		return -1;
	}
	
	public static WebDriver NavigateURL(String URL) 
	{
	BrowserValue();
	//	ReadSheet();
		KillDriver();
		
		switch (Browser.valueOf(browserType)) {
		case GoogleChrome:		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches", "--disable-extensions");
			options.addArguments("--start-maximized");
			File cdriverpath = new File(BaseDIR + "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", cdriverpath.getAbsolutePath());
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
			driver.manage().window().maximize();			
			break;
			
		case InternetExplorer:
			break;
			
		case Firefox:
			break;
			

		default:
			break;
		}
		
		return driver;
	}
	
	

}
