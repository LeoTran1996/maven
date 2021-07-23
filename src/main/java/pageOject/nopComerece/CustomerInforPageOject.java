package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.CustomerPageUI;
import PageUIs.nopCommerce.HomePageUI;
import PageUIs.nopCommerce.SiteMapPageUI;
import commons.BasePage;

public class CustomerInforPageOject extends BasePage {
	
	WebDriver driver;
	
	public CustomerInforPageOject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstnameTextBoxValue() {
		waitforElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastnameTextBoxValue() {
		waitforElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerPageUI.LASTNAME_TEXTBOX);
	}
	
	public String getEmailTextBoxValue() {
		waitforElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, CustomerPageUI.EMAIL_TEXTBOX);
	}
	
	public CustomerInforPageOject clickToMyAccountLink() {
		waitforElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPageOject(driver);
	}

}
