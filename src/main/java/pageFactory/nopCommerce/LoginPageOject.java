package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOject extends BasePage {
	
	WebDriver driver;
	
	public LoginPageOject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(css = ".login-button")
	private WebElement loginButton;
	
	public void enterToEmailTextbox(String emailAdress) {
		waitforElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAdress);	
	}

	public void enterToPassword(String password) {
		waitforElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);	
	}

	public void clickToLoginButton() {
		waitforElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
			
	}
}
