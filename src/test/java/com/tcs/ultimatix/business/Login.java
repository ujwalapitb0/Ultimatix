package com.tcs.ultimatix.business;

import org.openqa.selenium.WebDriver;

import com.tcs.ultimatix_page.LoginPage;

public class Login extends LoginPage {

	public Login(WebDriver driver)
	{
		super(driver);
	}
	
	public void FillLoginForm(String Username, String Password)
	{
		getUsername().clear();
		getUsername().sendKeys(Username);
		
		getPassword().clear();
		getPassword().sendKeys(Password);
		
	}
	
	public void Submit()
	{
		getSubmitButton().click();
	}
	
}
