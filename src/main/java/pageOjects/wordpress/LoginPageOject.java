package pageOjects.wordpress;

import org.openqa.selenium.WebDriver;

import PageUIs.wordpress.LoginPageUI;
import commons.BasePage;

public class LoginPageOject extends BasePage {

	WebDriver driver;

	public LoginPageOject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String usernameOrEmail) {
		waitforElementVisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, usernameOrEmail);
	}

	public void clickToContinueButton() {
		waitforElementVisible(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitforElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_ERR_MSG);
	}

	public String getInvalidEmailErrorMessage() {
		waitforElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERR_MSG);
		return getElementTex(driver, LoginPageUI.INVALID_EMAIL_ERR_MSG);
	}

	public void inputEmptyPasswordTextbox(String password) {
		waitforElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitforElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitforElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERR_MSG);

		return isElementDisplayed(driver, LoginPageUI.EMPTY_PASSWORD_ERR_MSG);
	}

	public boolean isInvalidPasswordErrorMessageDisplayed() {
		waitforElementVisible(driver, LoginPageUI.INVLID_PASSWORD_ERR_MSG);

		return isElementDisplayed(driver, LoginPageUI.INVLID_PASSWORD_ERR_MSG);
	}


}
