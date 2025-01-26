package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.util.Assert;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}
 
//img[@class='img-circle']
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement adminbutton;
//contains+indexing-(//a[contains(@href, '/admin/logout')])[1]
	@FindBy(xpath = "(//a[contains(@href, '/admin/logout')])[1]")
	private WebElement logoutbutton;
//p[text()='Sign in to start your session']
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	private WebElement signinpage;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manage;
	@FindBy(xpath = "(//div[@class='col-lg-3 col-6']//following::i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement moreinfobutton;
	//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']/self::a[@class='small-box-footer'] choose self node
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']/self::a[@class='small-box-footer']")
		private WebElement moreinfobuttoncontact;
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//following-sibling::i[@class='fas fa-arrow-circle-right']")
		private WebElement footermoreinfobutton;
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::i[@class='fas fa-arrow-circle-right']")
		private WebElement productmoreinfobutton;
		//indexing(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]
		@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]")
		private WebElement subcategorybutton;
		
		//subcategory
		public SubCategoryPage subCategoryMoreInfo() {
			subcategorybutton.click();
			return new SubCategoryPage(driver);
		}
		
		//manageproduct
		public ManageProductPage manageProductTab() {
			productmoreinfobutton.click();
			return new ManageProductPage(driver);
		}
		
	//footer page
		public ManageFooterPage footerclickMoreInfo() {
			footermoreinfobutton.click();
			return new ManageFooterPage(driver) ;
		}

		//contact page
	public ManageContactPage clickMoreInfoContact() {
		moreinfobuttoncontact.click();
		return new ManageContactPage(driver);
		
	}

	//admin users
	public AdminUsersPage clickMoreInfo() {
		moreinfobutton.click();
		return new AdminUsersPage(driver);
	}
	
	//managenews
	 public ManageNewsPage manageNewsTab() {
		 manage.click();
		 return new ManageNewsPage(driver);
	 }
	 
	 //homepage
	public HomePage clickAdminTab() {
		adminbutton.click();
		return new HomePage(driver);
	}
	 //homepage
	public HomePage clickLogoutTab() {
		logoutbutton.click();
		return new HomePage(driver);
	}

	public boolean isSigninPageDisplayed() {
		return signinpage.isDisplayed();
	}
}
