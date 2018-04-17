package com.tcs.ultimatix_page;

import com.tcs.ultimatix.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Driver{
public WebDriver driver;
public static String username_id = "USER";
public static String password_id = "PASSWORD";
public static String submit_id = "login_button";


public LoginPage(WebDriver driver)
{
	this.driver = driver;
}

public WebElement getUsername()
{
	return(driver.findElement(By.id(username_id)));
	
}

public WebElement getPassword()
{
	return(driver.findElement(By.id(password_id)));
}

public WebElement getSubmitButton()
{
	return(driver.findElement(By.id(submit_id)));	
}

}
