package com.tcs.ultimatix;

import org.openqa.selenium.WebDriver;


import application.LoginPage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testApp()
    {
    	try{
    		
    	Driver driver = new Driver();
    	//WebDriver d = driver.NavigateURL("https://westernunion.okta.com");
    	WebDriver d = driver.NavigateURL("https://www.ultimatix.net");
    	LoginPage lp = new LoginPage();
    	Utilities.result = lp.login(d);
    	if(Utilities.result == 1)
         System.out.println("Passed");
    	else 
    		System.out.println("failed");
    	}
    	catch(Exception e)
    	{
    		System.out.println("exception is:" +e);
    	}
    }
}
