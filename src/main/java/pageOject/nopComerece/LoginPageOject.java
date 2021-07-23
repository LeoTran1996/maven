package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.LoginPageUI;
import commons.BasePage;
import io.qameta.allure.Step;

public class LoginPageOject extends BasePage {
	
	WebDriver driver;
	PageGeneratorManager pageGenerator;
	
	public LoginPageOject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator = PageGeneratorManager.getPageGenerator();
	}

	@Step("Enter to Email textbox with value {0}")
	public void enterToEmailTextbox(String emailAdress) {
		waitforElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}
	
	@Step("Enter to Password textbox with value {0}")
	public void enterToPassword(String password) {
		waitforElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	@Step("Click to Login Button and navigate to Homepage")
	public HomePageOject clickToLoginButton() {
		waitforElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
		return PageGeneratorManager.getHomePageOject(driver);
	}

	public HomePageOject openHomePage() {
		waitforElementClickable(driver, LoginPageUI.HOMPAGE_LOGO);
		clickToElement(driver, LoginPageUI.HOMPAGE_LOGO);	
		return PageGeneratorManager.getHomePageOject(driver);
	}
}
