package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base {
	HomePage homepage;
	ManageProductPage manageproductpage;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "Test case used to delete product details in Manage Product page")
	public void validateWhetherUserIsAbleToDeleteProductDetails() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitclick();
		{
			//ManageProductPage manageproduct = new ManageProductPage(driver);
			//manageproduct.manageProductTab();
			//manageproduct.deleteProduct();
			manageproductpage=homepage.manageProductTab().deleteProduct();
			//manageproduct.isAlertMessageDisplayed();
			boolean alertshown = manageproductpage.isAlertMessageDisplayed();
			Assert.assertTrue(alertshown,Constants.DELETEPRODUCTDETAILSALERT);
		}
	}
}
