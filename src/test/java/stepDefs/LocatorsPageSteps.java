package stepDefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import utils.TestContext;

public class LocatorsPageSteps {
	public TestContext context;
	public String extractedPassword;
	private pageObjects.LocatorsPage locatorsPage;
	
	public LocatorsPageSteps(TestContext context) {
		this.context=context;
		this.locatorsPage=context.pageObjectManager.getlocatorsPage();
	}


	@Given("user landed on locators practice page")
	public void user_landed_on_locators_practice_page() {
	    System.out.println("Current URL: " + context.genericUtils.driver.getCurrentUrl());
	    Assert.assertTrue(context.genericUtils.driver.getCurrentUrl().contains("locatorspractice"));
	}

	@When("user enters {string} as username")
	public void user_enters_gmail(String email) {
	   locatorsPage.enterEmail(email);
	}

	@When("user enters password as extracted password")
	public void user_enters_password() {
	    locatorsPage.enterPassword(context.extractedPassword);
	   
	}
	@When("user enters {string} as valid username")
		public void user_enters_gmail2(String email2) {
		   locatorsPage.enterUsername(email2);
		}

		@When("user enters {string} as password")
		public void user_enters_password2(String password2) {
		    locatorsPage.enterPassword(password2);
	}

	@When("click on sign in button")
	public void click_on_sign_in_button() {
	    locatorsPage.clickSignInButton();
	}
	@When("user checks check boxes and get text")
	public void user_checks_check_boxes_and_get_text() {
		locatorsPage.wait.waitForElementVisible(locatorsPage.checkBox);
		locatorsPage.wait.waitForElementVisible(locatorsPage.checkBox2);
		   String rahulText=locatorsPage.getTextOfRahul();
		   System.out.println("Text displayed: " + rahulText);
		   Assert.assertTrue(rahulText.contains("Rahul"));
		   System.out.println("Text contains 'Rahul'.");
	}

	@Then("verify user is able to sign in successfully or not")
	public void verify_user_is_able_to_sign_in_successfully() {
	    String errorMessage = locatorsPage.getErrorMessageText();
	    System.out.println("Error Message: " + errorMessage);
	    //Assert.assertEquals(errorMessage, "Incorrect username or password.");
	    Assert.assertTrue(errorMessage.contains("Incorrect username or password"));
	}
	
	@When("user clicks on forgot password link")
	public void user_clicks_on_forgot_password_link() {
	    locatorsPage.clickForgotPasswordLink();
	}

	@When("user enters {string} as name")
	public void user_enters_as_name(String name) {
	    locatorsPage.enterName(name);
	}

	@When("user enters {string} as Email")
	public void user_enters_as_email(String Email) {
	    locatorsPage.enterEmail(Email);
	}

	@When("user enters {string} as phone number")
	public void user_enters_as_phone_number(String string) {
	    locatorsPage.enterPhoneNumber(string);
	}
	
	@When("user clicks on reset login button")
	public void user_clicks_reset_button() throws InterruptedException {
	    locatorsPage.clickResetLoginButton();
	}
    @When("user gets the password text")
	public void user_gets_the_password_text() {
    	String fullText = locatorsPage.getPasswordText();
        System.out.println("Full Text: " + fullText);

        context.extractedPassword = fullText.split("'")[1];

        System.out.println("Password extracted: " + context.extractedPassword);
	}

	@When("user clicks on got ot Login button")
	public void user_clicks_on_got_ot_login_button() {
	    locatorsPage.clickGoToLoginButton();
	}

	@Then("verify user is able to sign in successfully with valid credentials")
	public void verify_user_is_able_to_sign_in_successfully_with_valid_credentials() {
	   	   String successMessage=locatorsPage.getSuccessMessage();
	   	   System.out.println("Success Message: " + successMessage);
	   	   Assert.assertTrue(successMessage.contains("You are successfully logged in"));
	   	   System.out.println("User logged in successfully with valid credentials.");
	   	   
	}




}
