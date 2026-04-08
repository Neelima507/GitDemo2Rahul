package stepDefs;
import io.cucumber.java.en.*;
import pageObjects.FlightBookPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContext;

public class FlightBookPageSteps {
	public TestContext context;
	private FlightBookPage flightBookPage;

	public FlightBookPageSteps(TestContext context) {
		this.context=context;
		this.flightBookPage =context.pageObjectManager.getFlightBookPage();
	}

@When("selects country click on search button")
public void selects_country_click_on_search_button() {
	
	switchToFlightPage();
	flightBookPage.clickSearchdropdown();
	flightBookPage.clickSearchButton();
}
@Then("it should display the error")
public void it_should_display_the_error() {
	String error=flightBookPage.errorMessages();
	System.out.println(error);
}
public void switchToFlightPage() {
	
	LandingPage landingPage=context.pageObjectManager.getLandingPage();
	landingPage.selectFlightPage();
	context.genericUtils.switchWindowToChild("Flight Booking");
	System.out.println("Current window after switch: " + context.genericUtils.driver.getTitle());}

@When("User gives {string} and wait for auto suggestion")
public void user_gives_and_wait_for_auto_suggestion(String string) {
	System.out.println("Current window after switch: " + context.genericUtils.driver.getTitle());
   	flightBookPage.enterAutoSuggestText(string);
}

@When("select {string} option")
public void select_option(String string) {
   flightBookPage.selectAutoSuggestionByText(string);
}

@Then("validate the selected value text")
public void validate_the_selected_value_text() {
    String selectedText = flightBookPage.getSelectedAutoSuggestText();
   System.out.println("Selected auto-suggest text: " + selectedText);
   System.out.println("Current window after switch: " + context.genericUtils.driver.getTitle());
}
}
