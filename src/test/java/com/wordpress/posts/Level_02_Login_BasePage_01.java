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

public class Level_02_Login_BasePage_01 {

	WebDriver driver;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = new BasePage();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		basePage.openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin/");
		// driver.get("https://automationfc.wordpress.com/wp-admin/");
	}

	@Test
	public void Login_01_Empty_Email_Username() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");
		// driver.findElement(usernameTextboxBy).sendKeys("");
		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(
				basePage.isElementDisplayed(driver, "//span[text()='Please enter a username or email address.']"));
		// Assert.assertTrue(driver.findElement(emptyEmailErrorMessage).isDisplayed());

	}

	@Test
	public void Login_02_Ivalid_Email_Username() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "anhtran#123.451");
		// driver.findElement(usernameTextboxBy).sendKeys("anhtran#123.45");
		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		String userDoesNotExistMessage = basePage.getElementTex(driver,
				"//div[@class='form-input-validation is-error']");
		// String userDoesNotExistMessage =
		// driver.findElement(By.xpath("//div[@class='form-input-validation
		// is-error']")).getText().trim();

		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");

		Assert.assertTrue(basePage.isElementDisplayed(driver,
				"//div[@class='form-input-validation is-error' and contains(string(),' User does not exist. Would you like to create a new account?')]"));
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-input-validation
		// is-error' and contains(string(),' User does not exist. Would you like to
		// create a new account?')] ")).isDisplayed());

	}

	@Test
	public void Login_03_Username_Not_Exist() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "anhtran" + getRandomNumber());
		// driver.findElement(usernameTextboxBy).sendKeys("anhtran" +
		// getRandomNumber());
		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		String userDoesNotExistMessage = basePage.getElementTex(driver,
				"//div[@class='form-input-validation is-error']");
		// String userDoesNotExistMessage =
		// driver.findElement(By.xpath("//div[@class='form-input-validation
		// is-error']")).getText().trim();

		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");

		Assert.assertTrue(basePage.isElementDisplayed(driver,
				"//div[@class='form-input-validation is-error' and contains(string(),' User does not exist. Would you like to create a new account?')]"));
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-input-validation
		// is-error' and contains(string(),' User does not exist. Would you like to
		// create a new account?')] ")).isDisplayed());

	}

	@Test
	public void Login_04_Empty_Password() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		// driver.findElement(usernameTextboxBy).sendKeys("automationeditor");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		basePage.sendkeyToElement(driver, "//input[@id='password']", "");
		// driver.findElement(passwordTextboxBy).sendKeys("");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(
				basePage.isElementDisplayed(driver, "//span[text()=\"Don't forget to enter your password.\"]"));
		// Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Don't forget
		// to enter your password.\"]")).isDisplayed());

	}

	@Test
	public void Login_05_Invalid_Password() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		// driver.findElement(usernameTextboxBy).sendKeys("automationeditor");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		basePage.sendkeyToElement(driver, "//input[@id='password']", "123");
		// driver.findElement(passwordTextboxBy).sendKeys("123");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(basePage.isElementDisplayed(driver,
				"//span[text()=\"Oops, that's not the right password. Please try again!\"]"));
		// Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's
		// not the right password. Please try again!\"]")).isDisplayed());

	}

	@Test
	public void Login_06_Incorrect_Password() {

		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		// driver.findElement(usernameTextboxBy).sendKeys("automationeditor");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		basePage.sendkeyToElement(driver, "//input[@id='password']", "1996");
		// driver.findElement(passwordTextboxBy).sendKeys("1996");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(basePage.isElementDisplayed(driver,
				"//span[text()=\"Oops, that's not the right password. Please try again!\"]"));
		// Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's
		// not the right password. Please try again!\"]")).isDisplayed());

	}

	@Test
	public void Login_07_Valid_Email_Password() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		// driver.findElement(usernameTextboxBy).sendKeys("automationeditor");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		basePage.sendkeyToElement(driver, "//input[@id='password']", "automationfc");
		// driver.findElement(passwordTextboxBy).sendKeys("automationfc");

		basePage.clickToElement(driver, "//button[@type='submit']");
		// driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(basePage.isElementDisplayed(driver, "//h1[text()='Dashboard']"));
		// Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());

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
