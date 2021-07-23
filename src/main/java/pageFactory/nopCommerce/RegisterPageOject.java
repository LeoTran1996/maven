package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;

public class RegisterPageOject extends pageFactory.nopCommerce.BasePage {
	
	WebDriver driver;
	
	public RegisterPageOject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
//	
//	public static final String LASTTNAME_TEXTBOX = "//input[@id='LastName']";
//	
//	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
//	
//	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
//
//	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
//	
//	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
//	
//	public static final String REGISTER_SUCCESSMESSAGE = "//div[@class='result' and text()='Your registration completed']";
//	
//	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	private WebElement registerSuccessMessage;
	
	@FindBy(css = ".ico-logout")
	private WebElement logoutLink;
	

	public void enterToFirstNameTextbox(String firstname) {
		
		waitforElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstname);
	}

	public void enterToLastNameTextbox(String lastname) {
		waitforElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastname);
	}
	
	public void enterToEmailTextbox(String emailAdress) {
		
		waitforElementClickable(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAdress);
		
	}

	public void enterToPassword(String password) {
		waitforElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPassword(String confirmPassword) {
		
		waitforElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitforElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplayed() {
		waitforElementVisible(driver, registerSuccessMessage);
		return isElementDisplayed(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitforElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	
	}
}
