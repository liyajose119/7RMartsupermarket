package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(description = "test case used to ensure whether user can logout from admin site")

	public void ensureThatUserIsAbleToLogoutFromAdminSite() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitclick();

		//HomePage adminuser = new HomePage(driver);
		//adminuser.clickAdminTab();
		//adminuser.clickLogoutTab();
		homepage.clickAdminTab().clickLogoutTab();
		boolean alertshown = homepage.isSigninPageDisplayed();
		Assert.assertTrue(alertshown,Constants.LOGOUTHOMEPAGEALERT);
	}
}
