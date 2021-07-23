package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageOjects.wordpress.DashboardPageOject;
import pageOjects.wordpress.LoginPageOject;

public class Level_04_Login_Multi_Browser extends BaseTest {

	WebDriver driver;
	DashboardPageOject dashboardPage;
	LoginPageOject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	}

	@Parameters("url")
	@BeforeMethod
	public void beforeMethod(String appUrl) {
		driver.get(appUrl);

		loginPage = new LoginPageOject(driver);
	}

	@Test
	public void Login_01_Empty_Email_Username() {
		loginPage.inputToEmailTextbox("");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	}

	public void Login_02_Ivalid_Email_Username() {
		loginPage.inputToEmailTextbox("anhtran1996#<>");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		String userDoesNotExistMessage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");
	}

	public void Login_03_Username_Not_Exist() {
		loginPage.inputToEmailTextbox("anhtran" + getRandomNumber());
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		String userDoesNotExistMessage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");

	}

	public void Login_04_Empty_Password() {

		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());

	}

	public void Login_05_Invalid_Password() {
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("123");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());
	}

	public void Login_06_Incorrect_Password() {

		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("anhtran@123");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());

	}

	@Test
	public void Login_07_Valid_Email_Password() {
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("automationfc");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		dashboardPage = new DashboardPageOject(driver);
		Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
