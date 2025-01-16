package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	
	@Test(description = "Test case used to check whether user is able to create news in Manage News page")
public void checkWhetherUserIsAbleToCreateNews()  throws Exception {
String username =ExcelUtilities.readString(1, 0, "LoginPage");
String password =ExcelUtilities.readString(1, 1, "LoginPage");
LoginPage loginpage=new LoginPage(driver);
loginpage.enterUserName(username);
loginpage.enterPassWord(password);
loginpage.submitclick();
	
	//create object for manage news page
	//call each method of manage news page
	
	// Perform "Manage News" actions
    ManageNewsPage manage = new ManageNewsPage(driver);
    manage.manageNewsTab();
    manage.newButton();
    String news="test news";
    manage.enterNews(news);
    manage.clickSaveButton();
  //String username =ExcelUtilities.readString(1, 0, "ManageNewsPage");// for username
  		//String password =ExcelUtilities.readString(1, 1, "ManageNewsPage");
    boolean alertshown=manage.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"User is unable to create news");
}
}

