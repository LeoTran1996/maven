package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.HomePageUI;
import commons.BasePage;
import io.qameta.allure.Step;

public class HomePageOject extends BasePage {
	
	WebDriver driver;
	PageGeneratorManager pageGenerator;
	
	public HomePageOject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator = PageGeneratorManager.getPageGenerator();
	}

	@Step("Click to Register Link and navigate to Resiter Page")
	public RegisterPageOject clickToRegisterLink() {
		waitforElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return  PageGeneratorManager.getRegisterPageOject(driver);
	}

	@Step("Click to Login Link and navigate to Login page")
	public LoginPageOject clickToLoginLink() {
		waitforElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
		return PageGeneratorManager.getLoginPageOject(driver);
	}
	
	@Step("Verify My Account Link displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitforElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Click to click to My Account Link and navigate to Customer Page")
	public CustomerInforPageOject clickToMyAccountLink() {
		waitforElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);	
		return PageGeneratorManager.getCustomerPageOject(driver);
		
	}

	
}
