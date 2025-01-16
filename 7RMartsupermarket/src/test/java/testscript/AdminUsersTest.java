package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	@Test(description="test case used for adding new user details in Admin user page")
	public void checkIfAdminIsAbleToCreateNewUser() throws Exception
	{
	
	String username =ExcelUtilities.readString(1, 0, "LoginPage");
	String password =ExcelUtilities.readString(1, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassWord(password);
	loginpage.submitclick();
	
	AdminUsersPage adminuser=new AdminUsersPage(driver);
	adminuser.clickMoreInfo();
	adminuser.clickNewButton();
	
	FakerUtility fakerutility=new FakerUtility();
	String name=fakerutility.generateName();
	String password1 = fakerutility.generateRandomPassword();
	
	//String newusername =ExcelUtilities.readString(1, 0, "AdminUsersPage");
	adminuser.enterUserName(name);
	//String newpassword =ExcelUtilities.readString(1, 1, "AdminUsersPage");
	adminuser.enterPassWord(password1);
	adminuser.selectDropDown();
	adminuser.clickSaveButton();
	boolean alertshown=adminuser.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"Admin unable to create new user");
	
	}
	@Test(description="test case used for deleting existing user details in Admin user page")
	public void checkWhetherAdminCanDeleteUserDetails () throws Exception {
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		AdminUsersPage adminuser=new AdminUsersPage(driver);
		adminuser.clickMoreInfo();
		adminuser.deleteAdminUser();
		boolean alertshown=adminuser.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"Admin unable to delete user details");
}
}