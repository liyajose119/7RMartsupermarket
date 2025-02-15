package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.FileUploadUtility;

public class SubCategoryPage {
	WebDriver driver;
	HomePage homepage;
	
	public SubCategoryPage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

//indexing(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]")
	private WebElement subcategorybutton;
//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add'])")
	private WebElement newbutton;
//select[@class='form-control selectpicker']
	@FindBy(xpath = "(//select[@class='form-control selectpicker'])")
	private WebElement selectbutton;
//input[@type='text']
	@FindBy(xpath = "//input[@type='text']")
	private WebElement entercategorybutton;
//input[@type='file']
	@FindBy(xpath = "//input[@type='file']")
	private WebElement imagebutton;
//button[@type='submit']
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
//div[@class='alert alert-success alert-dismissible']
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	//public void subCategoryMoreInfo() {
		//subcategorybutton.click();
	//}

	public SubCategoryPage createNew() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage chooseCategory(String enterCategory) {
		selectbutton.sendKeys(enterCategory);
		return this;
	}

	public SubCategoryPage entersubCategory(String entersubCategory) {
		entercategorybutton.sendKeys(entersubCategory);
		return this;
	}

	public SubCategoryPage fileUpload() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imagebutton, Constants.STUDENTIMAGE);
		return this;
	}

	public SubCategoryPage chooseSave() {
		savebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
}