package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class SubCategoryTest extends Base { 

	@Test(description = "Test case used to check whether user is able to create new sub category in Sub category page")
	public void ensureWhetherUserIsAbleToAddNewSubCategory() throws Exception {
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitclick();

	SubCategoryPage subcategory=new SubCategoryPage(driver);
	subcategory.subCategoryMoreInfo();
	subcategory.createNew();
	
	FakerUtility fakerutility=new FakerUtility();
	String categoryName = fakerutility.generateName();  
    String subCategoryName = fakerutility.generateName();
	
	//String CategoryName = ExcelUtilities.readString(1, 0, "SubCategoryPage");
	subcategory.chooseCategory(categoryName);
	//String subCategoryName = ExcelUtilities.readString(1, 1, "SubCategoryPage");
	subcategory.entersubCategory(subCategoryName);
	subcategory.fileUpload();
	subcategory.chooseSave();
	boolean alertshown=subcategory.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"Admin unable to create new sub category in sub category page");
}
}