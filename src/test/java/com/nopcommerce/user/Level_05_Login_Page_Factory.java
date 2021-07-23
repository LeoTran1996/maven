package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageOject;
import pageFactory.nopCommerce.LoginPageOject;
import pageFactory.nopCommerce.RegisterPageOject;

public class Level_05_Login_Page_Factory extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageOject homePage;
	LoginPageOject loginPage;
	RegisterPageOject registerPage;
	String emailAddress;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = getBrowserDriver(browserName,urlName);
		emailAddress = "Messi" + getRandomNumber() + "@barca.com";
		homePage = new HomePageOject(driver);
	}

	@Test
	public void User_01_Register() {
		homePage.clickToRegisterLink();
	
		registerPage = new RegisterPageOject(driver);
		
		registerPage.enterToFirstNameTextbox("Leo");
		
		registerPage.enterToLastNameTextbox("Messi");
	
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPassword("123456");
		
		registerPage.enterToConfirmPassword("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageOject(driver);
			
	}
	
	@Test
	public void User_02_Login() {
		
		homePage.clickToLoginLink();
		
		loginPage =  new LoginPageOject(driver);
		
		loginPage.enterToEmailTextbox(emailAddress);
		
		loginPage.enterToPassword("123456");
		
		loginPage.clickToLoginButton();
		
		homePage = new HomePageOject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
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
