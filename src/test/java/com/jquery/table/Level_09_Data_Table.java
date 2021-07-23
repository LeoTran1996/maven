package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageOject.jquery.HomePageOject;
import pageOject.jquery.PageGeneratorManager;

public class Level_09_Data_Table extends BaseTest{

	WebDriver driver;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = getBrowserDriver(browserName,urlName);
	
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	public void Table_01_Paging() {
		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		
		homePage.openPageByNumber("5");	
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
	}
	
	public void Table_02_Search() {

		homePage.inputToHeaderTextboxByLabel("Country","Algeria");
		Assert.assertTrue(homePage.areRowRecordDisplayed("283821","Algeria","295140","578961"));
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderTextboxByLabel("Females","283821");
		Assert.assertTrue(homePage.areRowRecordDisplayed("283821","Algeria","295140","578961"));
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderTextboxByLabel("Males","295140");
		Assert.assertTrue(homePage.areRowRecordDisplayed("283821","Algeria","295140","578961"));
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderTextboxByLabel("Total","578961");
		Assert.assertTrue(homePage.areRowRecordDisplayed("283821","Algeria","295140","578961"));
		
	
			
	}
	
	
	public void Table_03_Edit_Delete() {
		homePage.clickToActionIconByCountryName("Argentina","remove");
		
		homePage.clickToActionIconByCountryName("AFRICA","remove");
		
		homePage.clickToActionIconByCountryName("Antigua and Barbuda","remove");
		
		homePage.refreshPage(driver);
		
		homePage.clickToActionIconByCountryName("Argentina","edit");
		homePage.refreshPage(driver);
		
		homePage.clickToActionIconByCountryName("AFRICA","edit");
		homePage.refreshPage(driver);
		
		homePage.clickToActionIconByCountryName("Antigua and Barbuda","edit");
					
			
	}
	
	@Test
	public void Table_04_Edit_Delete() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputValueByColumnNameByRowNumber("Contact Person","3","Anh Tran");
		
		homePage.inputValueByColumnNameByRowNumber("Company","1","1996");
		
	
		
	}
	
	private HomePageOject homePage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
