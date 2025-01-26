package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
HomePage homepage;
ManageFooterPage managefooterpage;

	@Test(description = "Test case used to edit Footer Text details in Manage Footer Text page")
	public void validateIfUserIsAbleToeditFooterTextDetails() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitclick();

		//ManageFooterPage managefooter = new ManageFooterPage(driver);
		//managefooter.clickMoreInfo();
		//managefooter.clickEditButton();
		String enteraddress = ExcelUtilities.readString(1, 0, "ManageFooterPage");
		String enteremail = ExcelUtilities.readString(1, 1, "ManageFooterPage");
		String enterphonenumber = ExcelUtilities.readInteger(1, 2, "ManageFooterPage");
		managefooterpage=homepage.footerclickMoreInfo().clickEditButton().enterAddress(password).enterEmail(password).enterPhoneNumber(password).clickUpdateButton();
		
		//managefooter.enterAddress(enteraddress);
		
		//managefooter.enterEmail(enteremail);
	
		//managefooter.enterPhoneNumber(enterphonenumber);
		//managefooter.clickUpdateButton();
		boolean alertshown = managefooterpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.EDITFOOTERDETAILSALERT);

	}

	@Test(description = "Test case used to ensure that update button is displayed in Manage Footer Text page")
	public void ensureThatUpdateButtonIsDisplayedinFooterPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		homepage=loginpage.submitclick();
		//ManageFooterPage managefooter = new ManageFooterPage(driver);
		//managefooter.clickMoreInfo();
		//managefooter.clickEditButton();
		managefooterpage=homepage.footerclickMoreInfo().clickEditButton();
		boolean updatebuttonshown = managefooterpage.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown,Constants.FOOTERPAGEUPDATEBUTTONALERT);

	}
}