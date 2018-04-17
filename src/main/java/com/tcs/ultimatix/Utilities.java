package com.tcs.ultimatix;

import org.openqa.selenium.WebDriver;

public class Utilities {
	
	public enum Browser {
		InternetExplorer, GoogleChrome, Opera, Firefox, Safari;
	}

	
	//config.properties file.
	
	//Excel paths.
	public static WebDriver driver = null;
	public static String browserType =null;
	public static String BaseDIR = System.getProperty("user.dir") + "\\";
	public static String ConfigFilePath = BaseDIR + "config.properties";
	public static String SanitySheetPath = BaseDIR + "SanitySheet.xls";
	
	
	public static String BrowserRunMode;
	public static String BrowserValue;
	public static String iterationCount;
	public static String TestcaseName;	
	
	public static int gbiterationCount;
	public static String gb_UserName="gbUsername";
	public static String gb_Password="gbPassword";
	
	public static String gbUsername;
	public static String gbPassword;
	public static String Testdata_TestcaseName;
	
	public static int pass;
	public static int fail;
	public static int result;
}
