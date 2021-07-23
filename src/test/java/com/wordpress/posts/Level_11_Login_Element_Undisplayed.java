package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageOjects.wordpress.DashboardPageOject;
import pageOjects.wordpress.LoginPageOject;

public class Level_11_Login_Element_Undisplayed extends BaseTest {

	WebDriver driver;
	DashboardPageOject dashboardPage;
	LoginPageOject loginPage;

	@Parameters({"browser" , "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = new LoginPageOject(driver);
		
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("automationfc");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		
		dashboardPage = new DashboardPageOject(driver);
		Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
	}

	@Test
	public void Login_01_Element_Displayed() {
		
		dashboardPage.clickToScreenOptionButton();
		dashboardPage.sleepInSecond(3);
		
		Assert.assertTrue(dashboardPage.isActivityCheckboxDisplayed());
		
		dashboardPage.clickToScreenOptionButton();
		dashboardPage.sleepInSecond(3);
	}
	
	@Test
	public void Login_02_Element_Undisplayed_In_DOM() {
	
		Assert.assertFalse(dashboardPage.isActivityCheckboxUnDisplayed());
	}
	
	@Test
	public void Login_03_Element_Undisplayed_Not_In_DOM() {
		Assert.assertFalse(dashboardPage.isPostSearchTextboxDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
