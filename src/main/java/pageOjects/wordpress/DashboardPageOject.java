package pageOjects.wordpress;

import org.openqa.selenium.WebDriver;

import PageUIs.wordpress.DashboardPageUI;
import commons.BasePage;

public class DashboardPageOject extends BasePage{
	
WebDriver driver;
	
	public DashboardPageOject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderTextDisplayed() {
		waitforElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
	}

	public void clickToScreenOptionButton() {
		waitforElementClickable(driver, DashboardPageUI.SCREEN_OPTIONS_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTIONS_BUTTON);	
	}

	public boolean isActivityCheckboxDisplayed() {
		
		return isElementUndisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);	
	}
	
	public boolean isActivityCheckboxUnDisplayed() {
		
		return isElementUndisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);	
	}
	
	public boolean isPostSearchTextboxDisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.SEARCH_TEXT_BOX);
		
	}
}
