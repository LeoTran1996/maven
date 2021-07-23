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

public class Level_10_Upload_File extends BaseTest{

	WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = getBrowserDriver(browserName,urlName);
	
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_One_Time() {
		String[] fileNames = {"cat.jpg"};
		
		homePage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
		
		homePage.clickToStartUploadButton();
		
		Assert.assertTrue(homePage.areFileUpLoadedSuccess(fileNames));
	}
	
	@Test
	public void Upload_02_Multiple_File_One_Time() {
	String[] fileNames = {"cat.jpg", "footballteam.jpg", "MU.PNG"};	
	homePage.refreshPage(driver);
	
	homePage.uploadMultipleFiles(driver, fileNames);
	Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
	
	homePage.clickToStartUploadButton();
	
	Assert.assertTrue(homePage.areFileUpLoadedSuccess(fileNames));
	}
	
	private HomePageOject homePage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
