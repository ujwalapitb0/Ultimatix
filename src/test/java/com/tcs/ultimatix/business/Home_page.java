package com.tcs.ultimatix.business;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.ultimatix_page.HomePage;

public class Home_page extends HomePage {

	 public Home_page(WebDriver driver)
	 {
		super(driver);
	 }
	
	 public boolean VerifyLogout()
	 {
		 return(Logout_ID().isDisplayed());
		 
	 }
	 public boolean VerifyNavigateMyAlloctionandDeployment()
	 {
		 WebElement tableRow = getMyAllocationandUtilizationlink();
		if(tableRow != null)
		{
			tableRow.click();		
			
			 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1));
			    String text = driver.findElement(By.id("uam_modal")).getText();
			    System.out.println(text);
			    // Verifying the page content of My allocationa and Utilization page.
			    if(text.equalsIgnoreCase("Logout"))
			    
			    	System.out.println("success");
			    			    
			    
			    driver.close();
			    driver.switchTo().window(tabs.get(0));
			    return true;
		}
		return false;
	 }
	 
	 public boolean VerifyLeaveRequest()
	 {
		 
		 
		 return false;
	 }
}
