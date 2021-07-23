package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageOject extends BasePage{
	
	WebDriver driver;
	
	public HomePageOject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".ico-register")
	private WebElement registerLink;
	
	@FindBy(css = ".ico-login")
	private WebElement loginLink;
	
	@FindBy(css = ".ico-account")
	@CacheLookup
	private WebElement myAccountLink;
	
	
	public void clickToRegisterLink() {
		waitforElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitforElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitforElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}
 

}
