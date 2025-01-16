package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.util.Assert;

public class HomePage {
		WebDriver driver; 
	 	public HomePage(WebDriver driver) //parameterized constructor
	 	{ 
	 		this.driver=driver; 
	 		PageFactory.initElements(driver , this); //to initialize webElements
	 		 
	 	} 
	 	
//img[@class='img-circle']
@FindBy(xpath="//img[@class='img-circle']")private WebElement adminbutton;
//contains+indexing-(//a[contains(@href, '/admin/logout')])[1]
@FindBy(xpath="(//a[contains(@href, '/admin/logout')])[1]")private WebElement logoutbutton;
//p[text()='Sign in to start your session']
@FindBy(xpath="//p[text()='Sign in to start your session']")private WebElement signinpage; 	
public void clickAdminTab() {
	adminbutton.click();	}

public void clickLogoutTab() {
	logoutbutton.click();	
}

public boolean isSigninPageDisplayed() {
return signinpage.isDisplayed();
 }
}
