package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class FlightBookPage {
	public WebDriver driver;
	public  WaitUtils waitUtils;
	By autosuggest = By.xpath("//input[@id='autosuggest']");
	By searchButton=By.id("ctl00_mainContent_btn_FindFlights");
	By errorMsg=By.id("view-origin-station");
	By autosuggestOptions = By.xpath("//ul[@id='ui-id-1']//li//a");
	
	 public FlightBookPage(WebDriver driver, WaitUtils waitUtils) {
	        this.driver = driver;
	        this.waitUtils = waitUtils;
	    }
//	 public void clickSearchdropdown() {
//		   // WebElement autoSuggest = waitUtils.waitForElementVisible(autosuggest);
//		 
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", autoSuggest);
//		    autoSuggest.sendKeys("India");
//		} 

		public void clickSearchButton() {
		    waitUtils.waitForElementClickable(searchButton).click();
		}

		public boolean errorMessage() {
		    return waitUtils.waitForElementVisible(errorMsg).isDisplayed();
		}

		public String errorMessages() {
		    return waitUtils.waitForElementVisible(errorMsg).getText();
		}
		public void enterAutoSuggestText(String string) {
		    WebElement input = waitUtils.waitForElementVisible(autosuggest);
		    input.sendKeys(string);
		}
		public void selectAutoSuggestionByText(String expectedText) {

			List<WebElement> options = waitUtils.waitForAllElementsVisible(autosuggestOptions);

		    for (WebElement option : options) {

		        if (option.getText().equalsIgnoreCase(expectedText)) {

		            // ✅ Step 1: Scroll element into view
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            js.executeScript("arguments[0].scrollIntoView(true);", option);

		            // ✅ Step 2: Small wait (stabilize UI)
		            try {
		                Thread.sleep(500);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }

		            // ✅ Step 3: JS click (bypass overlay issue)
		            js.executeScript("arguments[0].click();", option);

		            break;
		        }
		    }
		}
		public String getSelectedAutoSuggestText() {
		    return waitUtils.waitForElementVisible(autosuggest).getAttribute("value");
		}
		

}
