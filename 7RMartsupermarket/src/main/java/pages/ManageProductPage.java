package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	WebDriver driver;
	HomePage homepage;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement productmoreinfobutton;
	@FindBy(xpath = "(((//tbody//descendant::tr)[1]//td)[9]//a[@class='btn btn-sm btn btn-danger btncss'])")
	private WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	//public void manageProductTab() {
		//productmoreinfobutton.click();
	//}

	public ManageProductPage deleteProduct() {
		deletebutton.click();
		driver.switchTo().alert().accept();
		return this;
		
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
}
