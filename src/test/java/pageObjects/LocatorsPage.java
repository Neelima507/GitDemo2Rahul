package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsPage {
	public WebDriver driver;
	public utils.WaitUtils wait;
	
	public LocatorsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new utils.WaitUtils(driver);
	}
	@FindBy(id = "inputUsername") WebElement email;
    @FindBy(css = "input[placeholder='Password']") WebElement password;
@FindBy(xpath = "//button[@type='submit']") WebElement signIn;
@FindBy(css = "p.error") WebElement errorMessage;
		@FindBy(id = "chkboxOne") WebElement checkBox;
@FindBy(id = "chkboxTwo") WebElement checkBox2;
 @FindBy(xpath = "//*[@class='overlay-panel overlay-right']//h1") WebElement text;
 @FindBy(linkText = "Forgot your password?") WebElement forgotPassword;
 @FindBy(css = "input[placeholder='Name']")  WebElement username;
 @FindBy(css = "input[placeholder='Email']") WebElement email2;
 @FindBy(css = "input[placeholder='Phone Number']") WebElement phoneNumber;
 @FindBy(xpath = "//button[text()='Reset Login']") WebElement resetLogin;
  @FindBy(xpath = "//button[text()='Cancel']") WebElement cancelButton;
  @FindBy(css = "form p") WebElement passwordText;
  @FindBy(xpath = "//button[text()='Go to Login']")  public WebElement goToLoginButton;
  @FindBy(xpath="//p[contains(text(),'You are successfully logged in')]") WebElement successMessage;
   public void enterUsername(String user) {
	   wait.waitForElementVisible(email).clear();
	   email.clear();
	   email.sendKeys(user);
   }
   public void enterPassword(String pass) {
	   password.clear();
	   password.sendKeys(pass);
   }
   public void clickSignInButton() {
	  wait.waitForElementToBeClickable(signIn).click();
   }
   public String getErrorMessageText() {
	   return errorMessage.getText();
   }
   public void clickCheckBoxOne() {
	   if(!checkBox.isSelected()) {
		   checkBox.click();}
   }
    	public void clickCheckBoxTwo() {
    			if(!checkBox2.isSelected()) {
			   checkBox2.click();}
    	}
    	public String getTextOfRahul() {
				return text.getText();
		}
    	public void clickForgotPasswordLink() {
    						forgotPassword.click();
    	}
    	public void enterName(String name) {
							username.clear();
							username.sendKeys(name);
		}
    	public void enterEmail(String email) {
							email2.clear();
							email2.sendKeys(email);
		}
		public void enterPhoneNumber(String phone) {
							phoneNumber.clear();
							phoneNumber.sendKeys(phone);
		}
		public void clickResetLoginButton() {
							wait.waitForElementToBeClickable(resetLogin).click();
		}
		
		public String getPasswordText() {
							wait.waitForElementVisible(passwordText);
							return passwordText.getText();
						
		}
		public void clickGoToLoginButton() {
							wait.waitForElementToBeClickable(goToLoginButton).click();
		}
		public String getSuccessMessage() {
							return successMessage.getText();
		}
		public boolean isLoginSuccessful() {
			return successMessage.isDisplayed();
		}
}