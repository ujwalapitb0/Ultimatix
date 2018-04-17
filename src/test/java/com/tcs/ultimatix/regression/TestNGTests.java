package com.tcs.ultimatix.regression;

import static org.testng.Assert.assertTrue;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.tcs.ultimatix.Driver;
import com.tcs.ultimatix.business.Home_page;
import com.tcs.ultimatix.business.Login;

import com.tcs.ultimatix.Utilities;


public class TestNGTests {
	public String testname;	
	
	@BeforeMethod
	public void StartSession(Method method)
	{
		testname = method.getName();
	}
		
	@Test
	public void LoginTest()
	{
		
		//String testname = result.getMethod().getMethodName();
		int iterationCount = Driver.GetIterationCount(testname);
		try{			
		
		for(int i=1; i <= iterationCount; i++)
		{
		WebDriver driver = Driver.NavigateURL("https://www.ultimatix.net");
		Login login_page = PageFactory.initElements(driver, Login.class);
		HashMap<String, String> map = Driver.GetTestInputData(testname,i);
		String username = map.get(Utilities.gb_UserName);
		String password = map.get(Utilities.gb_Password);
		login_page.FillLoginForm(username, password);
		login_page.Submit();
		
		//verify login functionality.
		Home_page homepage = PageFactory.initElements(driver, Home_page.class);
		System.out.println("login status:" +homepage.VerifyLogout());
		assertTrue(homepage.VerifyLogout()," login successful");
		driver.close();
		}
		}
		catch(Exception ex)
		{
			System.out.println("error is:" + ex);
		}		
	
		}
	
	@BeforeMethod
	public void StartSession1(Method method)
	{
		testname = method.getName();
	}
	
	@Test
	public void MyAllocationandUtilization()
	{
		//String testname = result.getMethod().getMethodName();
				int iterationCount = Driver.GetIterationCount(testname);
				try{			
				
				for(int i=1; i <= iterationCount; i++)
				{
				WebDriver driver = Driver.NavigateURL("https://www.ultimatix.net");
				Login login_page = PageFactory.initElements(driver, Login.class);
				HashMap<String, String> map = Driver.GetTestInputData("LoginTest",i);
				String username = map.get(Utilities.gb_UserName);
				String password = map.get(Utilities.gb_Password);
				login_page.FillLoginForm(username, password);
				login_page.Submit();
				
				//verify login functionality.
				Home_page homepage = PageFactory.initElements(driver, Home_page.class);
				System.out.println("login status:" +homepage.VerifyLogout());
				assertTrue(homepage.VerifyLogout()," login successful");
				
				// Verifying the allocation and utilization tab in Ultimatix portal.
				assertTrue(homepage.VerifyNavigateMyAlloctionandDeployment()," Navigated to My allocation and Utilization page");
				driver.close();
				}
				}
				catch(Exception ex)
				{
					System.out.println("error is:" + ex);
				}

	}
	
	@BeforeMethod
	public void StartSession2(Method method)
	{
		testname = method.getName();
	}
	
	@Test
	public void LeaveRequests()
	{
		int iterationCount = Driver.GetIterationCount(testname);
		try{			
		
		for(int i=1; i <= iterationCount; i++)
		{
		WebDriver driver = Driver.NavigateURL("https://www.ultimatix.net");
		Login login_page = PageFactory.initElements(driver, Login.class);
		HashMap<String, String> map = Driver.GetTestInputData(testname,i);
		String username = map.get(Utilities.gb_UserName);
		String password = map.get(Utilities.gb_Password);
		login_page.FillLoginForm(username, password);
		login_page.Submit();
		
		Home_page homepage = PageFactory.initElements(driver, Home_page.class);
		System.out.println("login status:" +homepage.VerifyLogout());
		assertTrue(homepage.VerifyLogout()," login successful");
		
		//Verifying LeaveRequest list.
		
	}
	
	}
		catch (Exception ex)
		{
			System.out.println("Exception is" + ex);
		}
	}
	
}
	
	
	
	
	

