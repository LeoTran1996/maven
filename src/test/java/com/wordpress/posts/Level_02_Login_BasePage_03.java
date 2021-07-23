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

import commons.BasePage;

public class Level_02_Login_BasePage_03 extends BasePage{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	

	@BeforeMethod
	public void beforeMethod() {
		openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin/");
	}

	@Test
	public void Login_01_Empty_Email_Username() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");

		clickToElement(driver, "//button[@type='submit']");

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()='Please enter a username or email address.']"));

	}

	@Test
	public void Login_02_Ivalid_Email_Username() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "anhtran#123.451");
		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		String userDoesNotExistMessage = getElementTex(driver, "//div[@class='form-input-validation is-error']");

		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");

		Assert.assertTrue(isElementDisplayed(driver, "//div[@class='form-input-validation is-error' and contains(string(),' User does not exist. Would you like to create a new account?')]"));

	}

	@Test
	public void Login_03_Username_Not_Exist() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "anhtran" + getRandomNumber());

		clickToElement(driver, "//button[@type='submit']");

		sleepInSeconds(2);

		String userDoesNotExistMessage = getElementTex(driver, "//div[@class='form-input-validation is-error']");

		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");

		Assert.assertTrue(isElementDisplayed(driver, "//div[@class='form-input-validation is-error' and contains(string(),' User does not exist. Would you like to create a new account?')]"));

	}

	@Test
	public void Login_04_Empty_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		sendkeyToElement(driver, "//input[@id='password']", "");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Don't forget to enter your password.\"]"));

	}

	@Test
	public void Login_05_Invalid_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		sendkeyToElement(driver, "//input[@id='password']", "123");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));

	}

	@Test
	public void Login_06_Incorrect_Password() {

		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		sendkeyToElement(driver, "//input[@id='password']", "1996");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));

	}

	@Test
	public void Login_07_Valid_Email_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		sendkeyToElement(driver, "//input[@id='password']", "automationfc");

		clickToElement(driver, "//button[@type='submit']");
		sleepInSeconds(2);

		Assert.assertTrue(isElementDisplayed(driver, "//h1[text()='Dashboard']"));

	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	public void sleepInSeconds(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
