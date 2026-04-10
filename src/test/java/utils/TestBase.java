package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException{
		// read data from the file "config.properties".
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop=new Properties();//this line has ability to read properties in .properties file(global.properties)
		prop.load(fis);
		String url=prop.getProperty("LoginUrl");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		
		String browser = browser_maven != null ? browser_maven : browser_properties;
		
		 if (driver == null) {
			 if(browser.equalsIgnoreCase("Chrome")) {
		 driver=new ChromeDriver();
			 }
			 else
				 if(browser.equalsIgnoreCase("firefox")) {
					 driver=new FirefoxDriver();
				 }
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		 driver.get(url);
		 }
		 return driver;
	}
	

}
