package pageOject.jquery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.JQuery.HomePageUIs;
import commons.BasePage;

public class HomePageOject extends BasePage {

	public WebDriver driver;

	public HomePageOject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitforElementVisible(driver, HomePageUIs.HOMEPAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.HOMEPAGE_BY_NUMBER, pageNumber);
		
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitforElementVisible(driver, HomePageUIs.HOMEPAGE_ACTIVE_BY_NUMBER, pageNumber);
		return	isElementDisplayed(driver, HomePageUIs.HOMEPAGE_ACTIVE_BY_NUMBER, pageNumber);
			
	}

	public void inputToHeaderTextboxByLabel(String labelName, String values) {
		waitforElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL_NAME, labelName);
		sendkeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL_NAME, values, labelName);
		sendKeyboardToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, labelName);
	}

	public boolean areRowRecordDisplayed(String femal, String country, String male, String total) {
		waitforElementVisible(driver, HomePageUIs.ROW_VALUE_BY_ALL_FIELD, femal, country, male, total);
		return isElementDisplayed(driver, HomePageUIs.ROW_VALUE_BY_ALL_FIELD, femal, country, male, total);
	}


	public void clickToActionIconByCountryName(String countryName, String actionName) {
		waitforElementClickable(driver, HomePageUIs.ACTINO_ICON_BY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUIs.ACTINO_ICON_BY_NAME, countryName, actionName);
		
	}

	public void inputValueByColumnNameByRowNumber(String columnName, String rowIndex, String values) {
		waitforElementVisible(driver, HomePageUIs.HEADER_NAME_PRECIDING, columnName);
		int columnIndex = getElementNumber(driver, HomePageUIs.HEADER_NAME_PRECIDING, columnName) + 1;
		sendkeyToElement(driver, HomePageUIs.TEXTBOX_BY_COLUMN_AND_ROW_INDEX,values ,rowIndex, String.valueOf(columnIndex));
		
	}

	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, HomePageUIs.LOADED_FILE_NAME, fileName)) {
				status = true;
			}else {
				return status;
			}
		}
		return status;
	}

	public void clickToStartUploadButton() {
		List<WebElement> uploadButton = getListWebElement(driver, HomePageUIs.START_UPLOAD_BUTTON);
		for (WebElement uploadBtn : uploadButton) {
			uploadBtn.click();
			sleepInSecond(2);
		}
		
	}

	public boolean areFileUpLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, HomePageUIs.UPLOADED_FILE_NAME, fileName)) {
				status = true;
			}else {
				return status;
			}
		}
		return status;
	}
	
	
}
