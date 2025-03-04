package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	HomePage homepage;
	
	public AdminUsersPage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private
	// WebElement moreinfobutton;

	@FindBy(xpath = "(//div[@class='col-lg-3 col-6']//following::i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement moreinfobutton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement enternewusername;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement enternewpassword;

	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropdown;

	@FindBy(xpath = "//button[@name='Create']")
	private WebElement clicksave;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	// indexing-(//i[@class='fas fa-trash-alt'])[1]
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	private WebElement deleteuser;

	//public AdminUsersPage clickMoreInfo() {

		//moreinfobutton.click();
		//return new AdminUsersPage(driver);
	//}

	public AdminUsersPage clickNewButton() {
	    newbutton.click();
	    return this;
	}

	public AdminUsersPage enterUserName(String newusername) {
	    enternewusername.sendKeys(newusername);
	    return this;
	}

	public AdminUsersPage enterPassWord(String newpassword) {
	    enternewpassword.sendKeys(newpassword);
	    return this;
	}

	public AdminUsersPage selectDropDown() {
	    Select text = new Select(dropdown);
	    text.selectByVisibleText("Staff");
	    return this;
	}

	public AdminUsersPage clickSaveButton() {
	    clicksave.click();
	    return this;
	}

	public AdminUsersPage deleteAdminUser() {
		WaitUtility wait=new WaitUtility();
		wait.waitForElementToBeClickable(driver, deleteuser);
		deleteuser.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
}