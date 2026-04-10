package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContext {
	public WebDriver driver;
	public String landingPageproductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public WaitUtils waitUtils;
	public String extractedPassword;
	
	public TestContext() throws IOException {
		
		testBase=new TestBase();
		driver = testBase.WebDriverManager();   // ✅ ONLY ONCE

        waitUtils = new WaitUtils(driver);
        genericUtils = new GenericUtils(driver);

        // ✅ Pass both driver + waitUtils
        pageObjectManager = new PageObjectManager(driver, waitUtils);
        
    }
}
