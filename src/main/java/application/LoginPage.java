package application;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tcs.ultimatix.Utilities;

public  class LoginPage {

	public int login(WebDriver webdriver)
	{
		//username details.
		Utilities.pass = 1;
		WebElement obj_username = webdriver.findElement(By.id(OREP.Login.loginUsername));
		obj_username.isDisplayed();
		obj_username.clear();
		obj_username.click();
		
		obj_username.sendKeys("49967655");
		
		//password details.
		WebElement obj_password = webdriver.findElement(By.id(OREP.Login.loginPassword));
		obj_password.clear();
		obj_password.click();
		
		obj_password.sendKeys("Welcome77");
		
		//Click Sign in button.
		WebElement obj_Signin = webdriver.findElement(By.id(OREP.Login.Sign_in));
		obj_Signin.click();
		
		return Utilities.pass;
		
	}
}
