package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver; 
	public ManageNewsPage(WebDriver driver) 
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); 
}
 	//@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
 	//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//following-sibling::i
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//following-sibling::i")private WebElement moreinfobutton;
 	//p[text()='Manage News']
		
	//xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']"
 	@FindBy(xpath="//p[text()='Manage News']")private WebElement manage ;
 	//a[@class='btn btn-rounded btn-danger']
 	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement create ;
 	//textarea[@id='news']
 	@FindBy(xpath="//textarea[@id='news']")private WebElement news ;
 	//button[@type='submit']
 	@FindBy(xpath="//button[@type='submit']")private WebElement save ;
 	//div[@class='alert alert-success alert-dismissible']
 	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement success ;
//more info method
	//new button method
	//enter news (get from test class) method
	//click save method
	//chck whthr ter is alert method
	
	 public void manageNewsTab() {
		 manage.click();
	 }
	 
		    public void newButton() {
		    	create.click();
		    }
		    	public void enterNews(String comment) {
		    		news.sendKeys(comment);
		    	}
		    		 public void clickSaveButton() {
		    			 save.click();
		    		 }
		    		 public boolean isAlertMessageDisplayed() {
		    			 return success.isDisplayed(); 
		    			}
		    	}
		    
	 
	

