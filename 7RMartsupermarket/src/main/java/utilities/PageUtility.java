package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageUtility {
	 // Click an element using JavaScript
	public void javaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Scroll to the bottom of the page
	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	// Generate the current date and time in a specific format
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		return formatter.format(date);
	}
	// Scroll to the top of the page
    public void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
}
    // Capture the URL of the current page
    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    // Get the title of the current page
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
 // Maximize the browser window
    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
 // Clear input field and enter new text
    public void clearAndEnterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
}
 // Scroll to a specific element on the page
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
 // Get the attribute value of an element
    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }
}  
