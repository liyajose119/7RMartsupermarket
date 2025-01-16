package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	
	@DataProvider(name="credentials")
	public Object[][] testData() {
		Object data[][]= { {"admin","admin"},{"admin","hello"},{"gm","admin"}};
		return data;
	}
	@Test(dataProvider = "credentials", description = "Test case used to login into admin site using valid credentials",groups= {"regression"})
	public void verifyTheUserIsAbleToLoginUsingValidCredentials(String username,String password) throws Exception {

		//String username="admin";
		//String password="admin";
		//String username =ExcelUtilities.readString(1, 0, "LoginPage");// for username
		//String password =ExcelUtilities.readString(1, 1, "LoginPage");// for password
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		boolean ishomepageloaded=loginpage.isDashboardDisplayed();
		Assert.assertTrue(ishomepageloaded,"User is able to login using valid details");
	}
	@Test(description = "Test case used to login into admin site using invalid user name")
	@Parameters({"username","password"})
	public void verifyTheUserUnableToLoginUsingInvalidUserName(String username,String password ) throws Exception {
		//String username="adminhello";
		//String password="admin";
		//String username =ExcelUtilities.readString(2, 0, "LoginPage");
		//String password =ExcelUtilities.readString(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		boolean isalertmessageshown=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isalertmessageshown,"User is unable to login using invalid credentials");
	}
	@Test(description = "Test case used to login into admin site using invalid password",groups= {"regression"})
	public void verifyTheUserUnableToLoginUsingInvalidPassword() throws Exception {
		//String username="admin";
		//String password="adminhello";
		String username =ExcelUtilities.readString(3, 0, "LoginPage");
		String password =ExcelUtilities.readString(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		boolean isalertmessageshown=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isalertmessageshown,"User is unable to login using invalid credentials");
	}
	@Test(description = "Test case used to login into admin site using invalid username and password")
	public void verifyTheUserUnableToLoginUsingInvalidUsernameAndPassword() throws Exception {
		//String username="adminxx";
		//String password="adminhello";
		String username =ExcelUtilities.readString(4, 0, "LoginPage");
		String password =ExcelUtilities.readString(4, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();
		boolean isalertmessageshown=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isalertmessageshown,"User is unable to login using invalid credentials");
	}
}