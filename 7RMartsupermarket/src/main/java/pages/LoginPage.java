package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	WebDriver driver; 
 	public LoginPage(WebDriver driver) 
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); 
 		 
 	} 
 	//@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
 	
 	@FindBy(name="username")private WebElement name;
 	@FindBy(name="password")private WebElement pass;
 	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
 	@FindBy(xpath="//p[text()='Dashboard']")private WebElement db;
 	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertmessage;
 	public void enterUserName(String usernamevalue) {
 		name.sendKeys(usernamevalue);
 	}
 	public void enterPassWord(String passwordvalue) {
 		pass.sendKeys(passwordvalue);
 	}

 	public void submitclick() {	
//submit.click();
 		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
 		//wait.until(ExpectedConditions.elementToBeClickable(button));
 		WaitUtility wait= new WaitUtility();
 		wait.waitForElementToBeClickable(driver,submit);
 		PageUtility page=new PageUtility();
 		page.javaScriptClick(driver,submit);
}
 	public boolean isDashboardDisplayed() {
 		return db.isDisplayed();
 		
 	}
	public boolean isAlertMessageDisplayed() {
		// TODO Auto-generated method stub
		return alertmessage.isDisplayed();
	}
	
 	
}