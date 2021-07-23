package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageOjects.wordpress.DashboardPageOject;
import pageOjects.wordpress.LoginPageOject;

public class Level_03_Login_Page_Oject {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	DashboardPageOject dashboardPage;
	LoginPageOject loginPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin/");
		
		loginPage = new LoginPageOject(driver);
	}

	@Test
	public void Login_01_Empty_Email_Username() {
		loginPage.inputToEmailTextbox("");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	}

	@Test
	public void Login_02_Ivalid_Email_Username() {
		loginPage.inputToEmailTextbox("anhtran1996#<>");
		loginPage.clickToContinueButton();		
		loginPage.sleepInSecond(2);
		String userDoesNotExistMessage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");	
	}

	@Test
	public void Login_03_Username_Not_Exist() {
		loginPage.inputToEmailTextbox("anhtran" + getRandomNumber());
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		String userDoesNotExistMessage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");

	}

	@Test
	public void Login_04_Empty_Password() {
		
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());

	}

	@Test
	public void Login_05_Invalid_Password() {
		loginPage.inputToEmailTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		loginPage.inputEmptyPasswordTextbox("123");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());
	}

	@Test
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
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
