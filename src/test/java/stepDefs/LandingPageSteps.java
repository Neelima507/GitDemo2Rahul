package stepDefs;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContext;

public class LandingPageSteps {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	public TestContext context;
	public LandingPage landingPage;

	public LandingPageSteps(TestContext context) {
		this.context=context;
		this.landingPage =context.pageObjectManager.getLandingPage();
	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() {
		System.out.println("am on Greencart page");
		 //System.out.println("Title is: " + landingPage.getcurrentTitle());
		   // Assert.assertFalse(landingPage.getcurrentTitle().contains("GreenKart"), "Page title mismatch");
		Assert.assertTrue(landingPage.getcurrentTitle().contains("GreenKart"));
		
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(3000); 
		context.landingPageproductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println(context.landingPageproductName + " is extracted from Home page");}
	@When("^user added (.+) items of the selected product to the cart$")
	public void user_added_items(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.selectAddToCart();
		
	}
	@Given("User is on home page")
	public void user_is_on_home_page() {
		System.out.println("user is on Home page");
		Assert.assertTrue(landingPage.getcurrentTitle().contains("GreenK"));
	}
	@Given("User landed on home page")
	public void user_landed_on_home_page() {
	   System.out.println("User landed on home page------------flight page going to land");
	   System.out.println("Title is: " + landingPage.getcurrentTitle());
	}

	@When("user clicks on flight link")
	public void user_clicks_on_flight_link() {
		landingPage.selectFlightPage();
		context.genericUtils.switchWindowToChild("Flight Booking");
		System.out.println(landingPage.getcurrentTitle());
	}


	

}
