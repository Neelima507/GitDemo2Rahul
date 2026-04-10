package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

//responsible for handling all page OBJECTS
public class PageObjectManager {
	public WebDriver driver;
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckOutpage checkOutPage;
	public FlightBookPage flightBookPage;
	public WaitUtils waitUtils;
	public LocatorsPage locatorsPage;
	
	public PageObjectManager(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.waitUtils = waitUtils;
    }

	public LandingPage getLandingPage() {
		landingPage=new LandingPage(driver);
		return landingPage;
	}
	public OffersPage getOffersPage() {
		offersPage=new OffersPage(driver);
		return offersPage;
	}
	public CheckOutpage getCheckOutPage() {
		checkOutPage=new CheckOutpage(driver);
		return checkOutPage;
	}
	public FlightBookPage getFlightBookPage() {
		 return (flightBookPage == null) ? flightBookPage = new FlightBookPage(driver, waitUtils) : flightBookPage;
	}
	public WaitUtils getWaitUtilsPage() {
		waitUtils=new WaitUtils(driver);
		return waitUtils;
	}
	public LocatorsPage getlocatorsPage() {
		locatorsPage=new LocatorsPage(driver);
		return locatorsPage;
	}
	
}

