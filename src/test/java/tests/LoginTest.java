package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pages.LoginPage;

public class LoginTest extends baseTest {
		
	@Test(priority=1)
	public void testsuccessfulllogin()
	{
		LoginPage login=new LoginPage(driver);	
		
		//checking for the successfull login
		login.enterusername("tomsmith");
		login.enterpassword("SuperSecretPassword!");
		login.clickSubmit();
		
		//check for the /secure in url
		Assert.assertTrue(driver.getCurrentUrl().contains("/secure"));
		
		//checking for the flashed message
		Assert.assertTrue(login.getFlashMsg().contains("You logged into a secure area!"));
		
		// Checking for the 
		Assert.assertTrue(login.logoutButtonDisplay());		
	}
	@Test(priority=2)
	public void testInvalidUsername()
	{
		LoginPage login=new LoginPage(driver);
		login.enterusername("Wrongusername");
		login.enterpassword("SuperSecretPassword!");
		login.clickSubmit();
		Assert.assertTrue(login.getFlashMsg().contains("username is invalid!"));
	}
	@Test(priority=3)
	public void testInvalidPassword()
	{
		LoginPage login=new LoginPage(driver);
		login.enterusername("practice");
		login.enterpassword("InvalidPassword!");
		login.clickSubmit();
		Assert.assertTrue(login.getFlashMsg().contains("password is invalid!"));
	}

}
