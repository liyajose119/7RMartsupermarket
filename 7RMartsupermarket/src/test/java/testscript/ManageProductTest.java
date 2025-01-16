package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base{
	
@Test(retryAnalyzer=retry.Retry.class,description = "Test case used to delete product details in Manage Product page")
public void validateWhetherUserIsAbleToDeleteProductDetails () throws Exception {
	String username =ExcelUtilities.readString(1, 0, "LoginPage");
	String password =ExcelUtilities.readString(1, 1, "LoginPage");

LoginPage loginpage=new LoginPage(driver);
loginpage.enterUserName(username);
loginpage.enterPassWord(password);
loginpage.submitclick();
{
	ManageProductPage manageproduct=new ManageProductPage (driver);
	manageproduct.manageProductTab();
	manageproduct.deleteProduct();
	manageproduct.isAlertMessageDisplayed();
	boolean alertshown=manageproduct.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"User is unable to delete product details in product page");
	}
}
}
