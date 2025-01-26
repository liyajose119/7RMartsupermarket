package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserspage;
	
	@Test(description="test case used for adding new user details in Admin user page")
	public void checkIfAdminIsAbleToCreateNewUser() throws Exception
	{
	
	String username =ExcelUtilities.readString(1, 0, "LoginPage");
	String password =ExcelUtilities.readString(1, 1, "LoginPage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserName(username).enterPassWord(password);
	//loginpage.enterPassWord(password);
	//loginpage.submitclick();
	homepage=loginpage.submitclick();
	
	//AdminUsersPage adminuser=new AdminUsersPage(driver);
	//adminuser.clickMoreInfo();
	//adminuser.clickNewButton();
	FakerUtility fakerutility = new FakerUtility();
	String name = fakerutility.generateName(); // Generate a unique name
	String password1 = fakerutility.generateRandomPassword(); // Generate a unique password
	
	//String newusername =ExcelUtilities.readString(1, 0, "AdminUsersPage");
	adminuserspage=homepage.clickMoreInfo().clickNewButton().enterUserName(name).enterPassWord(password1).selectDropDown().clickSaveButton() ;
	//String newpassword =ExcelUtilities.readString(1, 1, "AdminUsersPage");
	//adminuser.enterPassWord(password1);
	//adminuser.selectDropDown();
	//adminuser.clickSaveButton();
	boolean alertshown=adminuserspage.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,Constants.CREATEUSERALERT);
	
	}
	@Test(description="test case used for deleting existing user details in Admin user page")
	public void checkWhetherAdminCanDeleteUserDetails () throws Exception {
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		homepage=loginpage.enterUserName(username).enterPassWord(password).submitclick();
		//loginpage.enterUserName(username);
		//loginpage.enterPassWord(password);
		//loginpage.submitclick();
		//AdminUsersPage adminuser=new AdminUsersPage(driver);
		//adminuser.clickMoreInfo();
		adminuserspage=homepage.clickMoreInfo();
		//adminuser.deleteAdminUser();
		boolean alertshown=adminuserspage.deleteAdminUser().isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,Constants.ALERTMESSAGEADMIN);
}
}