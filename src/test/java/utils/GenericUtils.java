package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	public void switchWindowToChild(String expectedTitle) {
	    Set<String> windows = driver.getWindowHandles();

	    for (String window : windows) {
	        driver.switchTo().window(window);
	        System.out.println("Checking window: " + driver.getTitle());

	        if (driver.getTitle().contains(expectedTitle)) {
	            System.out.println("Switched to correct window: " + driver.getTitle());
	            break;
	        }
	    }
	}
	
	

}
