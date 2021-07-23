package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.RegisterPageUI;
import commons.BasePage;
import io.qameta.allure.Step;

public class RegisterPageOject extends BasePage {
	
	WebDriver driver;
	PageGeneratorManager pageGenerator;
	
	public RegisterPageOject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator = PageGeneratorManager.getPageGenerator();
	}
	
	@Step("Enter to Firstname textbox with value {0}")
	public void enterToFirstNameTextbox(String firstname) {
		waitforElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}
	@Step("Enter to Lastname textbox with value {0}")
	public void enterToLastNameTextbox(String lastname) {
		waitforElementVisible(driver, RegisterPageUI.LASTTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTTNAME_TEXTBOX, lastname);
		
	}
	@Step("Enter to Firstname textbox with value {0}")
	public void enterToEmailTextbox(String emailAdress) {
		waitforElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAdress);
		
	}
	@Step("Enter to Password with value {0}")
	public void enterToPassword(String password) {
		waitforElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}
	@Step("Enter to Confirm Password with value {0}")
	public void enterToConfirmPassword(String confirmPassword) {
		waitforElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitforElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	@Step("Verify Success Message displayed")
	public boolean isSuccessMessageDisplayed() {
		waitforElementVisible(driver, RegisterPageUI.REGISTER_SUCCESSMESSAGE);	
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESSMESSAGE);
	}
	@Step("Click to Logout Link and navigate to Homepage")
	public HomePageOject clickToLogoutLink() {
		waitforElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageOject(driver);
	}
}
