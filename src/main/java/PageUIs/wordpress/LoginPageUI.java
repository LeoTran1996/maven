package PageUIs.wordpress;

public class LoginPageUI {
	 
	public static final String USERNAME_EMAIL_TEXTBOX = "//input[@id='usernameOrEmail']";
	public static final String CONTINUE_BUTTON = "//button[@type='submit']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String LOGIN_BUTTON = "//button[@type='submit']";
	public static final String EMPTY_EMAIL_ERR_MSG = "//span[text()='Please enter a username or email address.']";
	public static final String INVALID_EMAIL_ERR_MSG = "//div[@class='form-input-validation is-error']";
	public static final String EMPTY_PASSWORD_ERR_MSG = "//span[text()=\"Don't forget to enter your password.\"]";
	public static final String INVLID_PASSWORD_ERR_MSG = "//span[text()=\"Oops, that's not the right password. Please try again!\"]";
}

