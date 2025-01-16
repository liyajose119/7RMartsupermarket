package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	
	@Test(description = "Test case used to edit Footer Text details in Manage Footer Text page")
	public void validateIfUserIsAbleToeditFooterTextDetails() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		
		ManageFooterPage managefooter=new ManageFooterPage(driver);
		managefooter.clickMoreInfo();
		managefooter.clickEditButton();
		String enteraddress =ExcelUtilities.readString(1, 0, "ManageFooterPage");
		managefooter.enterAddress(enteraddress);
		String enteremail =ExcelUtilities.readString(1, 1, "ManageFooterPage");
		managefooter.enterEmail(enteremail);
		String enterphonenumber =ExcelUtilities.readNumber(1, 2, "ManageFooterPage");
		managefooter.enterPhoneNumber(enterphonenumber);
		managefooter.clickUpdateButton();
		boolean alertshown=managefooter.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"User is unable to edit footertext details");
		
	}
	@Test(description = "Test case used to ensure that update button is displayed in Manage Footer Text page")
	public void ensureThatUpdateButtonIsDisplayedinFooterPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		ManageFooterPage managefooter=new ManageFooterPage(driver);
		managefooter.clickMoreInfo();
		managefooter.clickEditButton();
		boolean updatebuttonshown=managefooter.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown,"Update button is not displayed");
		
	}
}