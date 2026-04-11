package utils;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
 WebDriver driver;

	    public WaitUtils(WebDriver driver) {
	        this.driver = driver;
	    }
	    // Wait for visibility
	    public WebElement waitForElementVisible(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    public WebElement waitForElementVisible(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    // Wait for clickability
	    public WebElement waitForElementClickable(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
	    public WebElement waitForElementToBeClickable(WebElement option) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.elementToBeClickable(option));
	    }
	    // Wait for presence
	    public WebElement waitForElementPresence(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	    public List<WebElement> waitForAllElementsVisible(By locator) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	    }
}
