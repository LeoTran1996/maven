package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.LoginPageOject;
import pageFactory.nopCommerce.RegisterPageOject;
import pageOject.nopComerece.CustomerInforPageOject;
import pageOject.nopComerece.HomePageOject;

public class Level_06_Login_Page_Generator_Manager_Part_I extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	pageOject.nopComerece.HomePageOject homePage;
	LoginPageOject loginPage;
	RegisterPageOject registerPage;
	String emailAddress;
	CustomerInforPageOject customerInforPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = getBrowserDriver(browserName,urlName);
		emailAddress = "Messi" + getRandomNumber() + "@barca.com";
		
		//(1)
		homePage = new HomePageOject(driver);
	}

	@Test
	public void User_01_Register() {
		homePage.clickToRegisterLink();
		
		//(2)
		registerPage = new RegisterPageOject(driver);
		
		registerPage.enterToFirstNameTextbox("Leo");
		
		registerPage.enterToLastNameTextbox("Messi");
	
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPassword("123456");
		
		registerPage.enterToConfirmPassword("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
		
		//(3)
		homePage = new HomePageOject(driver);
			
	}
	
	@Test
	public void User_02_Login() {
		//(4)
		homePage.clickToLoginLink();
		
		loginPage =  new LoginPageOject(driver);
		
		loginPage.enterToEmailTextbox(emailAddress);
		
		loginPage.enterToPassword("123456");
		
		loginPage.clickToLoginButton();
		
		//(5)
		homePage = new HomePageOject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}
	@Test
	public void User_03_Customer_Infor() {
		
		homePage.clickToMyAccountLink();
		
		//(6)
		customerInforPage = new CustomerInforPageOject(driver);
		
		Assert.assertEquals(customerInforPage.getFirstnameTextBoxValue(), "Leo");
		
		Assert.assertEquals(customerInforPage.getLastnameTextBoxValue(), "Messi");
		
		Assert.assertEquals(customerInforPage.getEmailTextBoxValue(), emailAddress);
			
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
