package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage{
	WebDriver driver;
	By username=By.id("username");
	By password=By.id("password");
	By subbtn=By.id("submit-login");
	By flashMsg = By.id("flash");
    By logoutBtn = By.cssSelector("a.button");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterusername(String user)
	{
		driver.findElement(username).sendKeys(user);
		
	}
	public void enterpassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
		
	}
	public void clickSubmit()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Wait until clickable
		    wait.until(ExpectedConditions.elementToBeClickable(subbtn));

		    // Scroll into view (important)
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", 
		                     driver.findElement(subbtn));

		    // Click
		    driver.findElement(subbtn).click();
	}
	public String getFlashMsg()
	{
		return driver.findElement(flashMsg).getText();
	}
	public boolean logoutButtonDisplay()
	{
		return driver.findElement(logoutBtn).isDisplayed();
	}
}
