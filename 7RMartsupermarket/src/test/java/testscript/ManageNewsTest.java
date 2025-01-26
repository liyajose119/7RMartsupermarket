package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;

	@Test(description = "Test case used to check whether user is able to create news in Manage News page")
	public void checkWhetherUserIsAbleToCreateNews() throws Exception {
		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		//loginpage.submitclick();
		homepage=loginpage.submitclick();

		// create object for manage news page
		// call each method of manage news page

		// Perform "Manage News" actions
		//ManageNewsPage manage = new ManageNewsPage(driver);
		//manage.manageNewsTab();
		String news = ExcelUtilities.readString(1, 0, "ManageNewsPage");;
		managenewspage=homepage.manageNewsTab().newButton().enterNews(news).clickSaveButton();
		//manage.newButton();
		
		//manage.enterNews(news);
		//manage.clickSaveButton();
		boolean alertshown = managenewspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.CREATENEWSALERT);
	}
}
