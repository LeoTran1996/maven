package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageOject.nopComerece.HomePageOject;
import pageOject.nopComerece.LoginPageOject;
import pageOject.nopComerece.RegisterPageOject;

public class Level_03_Login_Page_Oject {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageOject homePage;
	LoginPageOject loginPage;
	RegisterPageOject registerPage;
	String emailAddress;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
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
