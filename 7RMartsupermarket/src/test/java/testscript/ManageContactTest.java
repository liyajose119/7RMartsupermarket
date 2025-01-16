package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;

import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test(description = "Test case used to edit contact details in Manage Contact page")
public void ensureWhetherUserIsAbleToEditContactDetails() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickMoreInfo();
		managecontact.clickEditButton();
		String phonenumber =ExcelUtilities.readNumber(1, 0, "ManageContactPage");
		managecontact.enterPhoneNumber(phonenumber);
		String email =ExcelUtilities.readString(1, 1, "ManageContactPage");
		managecontact.enterEmail(email);
		String address =ExcelUtilities.readString(1, 2, "ManageContactPage");
		managecontact.enterAddress(address);
		String deliverytime=ExcelUtilities.readNumber(1, 3, "ManageContactPage");
		managecontact.enterDeliveryTime(deliverytime);
		String chargelimit=ExcelUtilities.readNumber(1, 4, "ManageContactPage");
		managecontact.enterDeliveryChargeLimit(chargelimit);
	
		managecontact.clickUpdateButton();
		boolean alertshown=managecontact.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"User is unable to edit contact details");
	}

	@Test(description = "Test case used to determine whether update button is displayed in Manage Contact page")
	public void validateWhetherUpdateButtonIsDisplayedInContactPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickMoreInfo();
		managecontact.clickEditButton();
		boolean updatebuttonshown=managecontact.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown,"Update button is not displayed");
		
	}

}