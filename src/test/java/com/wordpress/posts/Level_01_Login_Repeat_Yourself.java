package com.wordpress.posts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Login_Repeat_Yourself {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By usernameTextboxBy = By.xpath("//input[@id='usernameOrEmail']");
	By continueButtonBy = By.xpath("//button[@type='submit']");
	By passwordTextboxBy = By.xpath("//input[@id='password']");
	By loginButtonBy = By.xpath("//button[@type='submit']");

	By emptyEmailErrorMessage = By.xpath("//span[text()='Please enter a username or email address.']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://automationfc.wordpress.com/wp-admin/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin/");
	}

	@Test
	public void Login_01_Empty_Email_Username() {
		driver.findElement(usernameTextboxBy).sendKeys("");
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);
		Assert.assertTrue(driver.findElement(emptyEmailErrorMessage).isDisplayed());

	}

	@Test
	public void Login_02_Ivalid_Email_Username() {
		driver.findElement(usernameTextboxBy).sendKeys("anhtran#123.45");
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		String userDoesNotExistMessage = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']")).getText().trim();
		Assert.assertEquals(userDoesNotExistMessage,"User does not exist. Would you like to create a new account?");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-input-validation is-error' and contains(string(),' User does not exist. Would you like to create a new account?')] ")).isDisplayed());

	}

	@Test
	public void Login_03_Username_Not_Exist() {
		driver.findElement(usernameTextboxBy).sendKeys("anhtran" + getRandomNumber());
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		String userDoesNotExistMessage = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']")).getText().trim();
		Assert.assertEquals(userDoesNotExistMessage, "User does not exist. Would you like to create a new account?");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-input-validation is-error' and contains(string(),' User does not exist. Would you like to create a new account?')] ")).isDisplayed());

	}

	@Test
	public void Login_04_Empty_Password() {
		driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);
		driver.findElement(passwordTextboxBy).sendKeys("");
		driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Don't forget to enter your password.\"]")).isDisplayed());

	}

	@Test
	public void Login_05_Invalid_Password() {

		driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);
		driver.findElement(passwordTextboxBy).sendKeys("123");
		driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]")).isDisplayed());

	}

	@Test
	public void Login_06_Incorrect_Password() {

		driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		driver.findElement(passwordTextboxBy).sendKeys("1996");
		driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]")).isDisplayed());

	}

	@Test
	public void Login_07_Valid_Email_Password() {
		driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
		driver.findElement(continueButtonBy).click();
		sleepInSeconds(2);

		driver.findElement(passwordTextboxBy).sendKeys("automationfc");
		driver.findElement(loginButtonBy).click();
		sleepInSeconds(2);

		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());

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
