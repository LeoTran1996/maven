package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageOject.nopComerece.CustomerInforPageOject;
import pageOject.nopComerece.PageGeneratorManager;

public class Level_06_Login_Page_Generator_Manager_Part_III extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	pageOject.nopComerece.HomePageOject homePage;
	pageOject.nopComerece.LoginPageOject loginPage;
	pageOject.nopComerece.RegisterPageOject registerPage;
	String emailAddress;
	CustomerInforPageOject customerInforPage;
	PageGeneratorManager pageGenerator;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = getBrowserDriver(browserName,urlName);
		//pageGenerator = PageGeneratorManager.getPageGenerator();
		emailAddress = "Messi" + getRandomNumber() + "@barca.com";
		
		//(1)
		homePage = PageGeneratorManager.getHomePageOject(driver);
	}

	@Test
	public void User_01_Register() {
		//(2)
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("Leo");
		
		registerPage.enterToLastNameTextbox("Messi");
	
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPassword("123456");
		
		registerPage.enterToConfirmPassword("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		
		
		//(3)
		homePage = registerPage.clickToLogoutLink();
			
	}
	
	@Test
	public void User_02_Login() {
		//(4)
		
		loginPage =  homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailAddress);
		
		loginPage.enterToPassword("123456");
		
		//(5)
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}
	@Test
	public void User_03_Customer_Infor() {
		
		//(6)
		customerInforPage = homePage.clickToMyAccountLink();
		
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
