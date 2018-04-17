package com.tcs.ultimatix_page;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.ultimatix.SeleniumFunctions;


public class HomePage {
public WebDriver driver;
public String logout_id= "logoutText";
public String trendingTagCloud = "trendingApps_table";
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement Logout_ID()
	{
		return(driver.findElement(By.id(logout_id)));
	}
	
	public WebElement getMyAllocationandUtilizationlink()
	{
		//WebElement tablerow1;
		//WebElement table = driver.findElement(By.xpath(".//table[@class='trendingApps_table']"));
		WebElement table = driver.findElement(By.xpath("//*[@class='trendingApps_table']"));
		SeleniumFunctions.highLightElement(driver, table );
		
		
		List<WebElement> tableRows = table.findElements(By.xpath(".//tr[@id='trendindDiv']//td/a[@class='trendApps']"));
		System.out.println(table);
		for(WebElement tableRow : tableRows)
		{
			//tablerow1 = tableRow.findElement(By.xpath("//td/a[]"));
			if(tableRow.getText().equalsIgnoreCase("My Allocation & Utilization"))
			{
				SeleniumFunctions.highLightElement(driver, tableRow);
				System.out.println(tableRow.getText());
				return tableRow;
				
			}
		}
		//System.out.println(tableRows);
		return null;
	}
	
	public WebElement getMyLeaveRequest()
	{
		
		return null;
	}
	
}
