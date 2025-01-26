package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontactpage;
	
	@Test(description = "Test case used to edit contact details in Manage Contact page")
	public void ensureWhetherUserIsAbleToEditContactDetails() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitclick();

		//ManageContactPage managecontact = new ManageContactPage(driver);
		//managecontact.clickMoreInfo();
managecontactpage=homepage.clickMoreInfoContact().clickEditButton().enterEmail(password).enterDeliveryTime(password).enterDeliveryChargeLimit(password).clickUpdateButton();
			//managecontactpage.clickEditButton();
		String phonenumber = ExcelUtilities.readInteger(1, 0, "ManageContactPage");
		//managecontactpage.enterPhoneNumber(phonenumber);
		String email = ExcelUtilities.readString(1, 1, "ManageContactPage");
		//managecontactpage.enterEmail(email);
		String address = ExcelUtilities.readString(1, 2, "ManageContactPage");
		//managecontactpage.enterAddress(address);
		String deliverytime = ExcelUtilities.readInteger(1, 3, "ManageContactPage");
		//managecontactpage.enterDeliveryTime(deliverytime);
		String chargelimit = ExcelUtilities.readInteger(1, 4, "ManageContactPage");
		//managecontactpage.enterDeliveryChargeLimit(chargelimit);

		//managecontactpage.clickUpdateButton();
		boolean alertshown = managecontactpage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.EDITCONTACTDETAILSALERT);
	}

	@Test(description = "Test case used to determine whether update button is displayed in Manage Contact page")
	public void validateWhetherUpdateButtonIsDisplayedInContactPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		homepage=loginpage.submitclick();
		//ManageContactPage managecontactpage = new ManageContactPage(driver);
		//managecontactpage.clickMoreInfo();
		managecontactpage=homepage.clickMoreInfoContact().clickEditButton();
		//managecontactpage.clickEditButton();
		boolean updatebuttonshown = managecontactpage.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown,Constants.CONTACTPAGEUPDATEBUTTONALERT);

	}

}