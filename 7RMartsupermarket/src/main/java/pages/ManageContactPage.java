package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;
	HomePage homepage;
	
	public ManageContactPage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']/self::a[@class='small-box-footer'] choose self node
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']/self::a[@class='small-box-footer']")
	private WebElement moreinfobuttoncontact;
//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	private WebElement editbutton;
//input[@id='phone']
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement enterphonenumber;
//input[@id='email']
	@FindBy(xpath = "//input[@id='email']")
	private WebElement enteremail;
//textarea[@placeholder='Enter the Address']
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	private WebElement enteraddress;
//textarea[@name='del_time']
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement enterdeliverytime;
//input[@id='del_limit']
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement enterdeliverychargelimit;
//button[@name='Update']
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement update;
//div[@class='alert alert-success alert-dismissible']
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	//public void clickMoreInfoContact() {
		//moreinfobuttoncontact.click();
	//}

	public ManageContactPage clickEditButton() {
		editbutton.click();
		return this;
	}

	public ManageContactPage enterPhoneNumber(String phonenumber) {
		enterphonenumber.clear();
		enterphonenumber.sendKeys(phonenumber);
		return this;
	}

	public ManageContactPage enterEmail(String email) {
		enteremail.clear();
		enteremail.sendKeys(email);
		return this;
	}

	public ManageContactPage enterAddress(String address) {
		enteraddress.clear();
		enteraddress.sendKeys(address);
		return this;
	}

	public ManageContactPage enterDeliveryTime(String time) {
		enterdeliverytime.clear();
		enterdeliverytime.sendKeys(time);
		return this;
	}

	public ManageContactPage enterDeliveryChargeLimit(String chargelimit) {
		enterdeliverychargelimit.clear();
		enterdeliverychargelimit.sendKeys(chargelimit);
		return this;
	}

	public ManageContactPage clickUpdateButton() {

		PageUtility page = new PageUtility();
		page.javaScriptClick(driver, update);

		// updatebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return update.isDisplayed();
	}

}