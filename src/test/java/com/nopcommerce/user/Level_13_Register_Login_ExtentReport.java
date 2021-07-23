package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageOject.nopComerece.AboutUsPageOject;
import pageOject.nopComerece.CustomerInforPageOject;
import pageOject.nopComerece.NewsPageOject;
import pageOject.nopComerece.PageGeneratorManager;
import pageOject.nopComerece.ShoppingCartPageOject;
import pageOject.nopComerece.SiteMapPageOject;
import reportConfig.ExtentTestManager;

public class Level_13_Register_Login_ExtentReport extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	pageOject.nopComerece.HomePageOject homePage;
	pageOject.nopComerece.LoginPageOject loginPage;
	pageOject.nopComerece.RegisterPageOject registerPage;
	String emailAddress;
	CustomerInforPageOject customerInforPage;
	AboutUsPageOject aboutUsPage;
	ShoppingCartPageOject shoppingCartPage;
	SiteMapPageOject siteMapPage;
	NewsPageOject newsPage;
	PageGeneratorManager pageGenerator;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlName) {
		driver = getBrowserDriver(browserName,urlName);
		//pageGenerator = PageGeneratorManager.getPageGenerator();
		emailAddress = "Messi" + getRandomNumber() + "@barca.com";
		
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Mo trang Homepage");
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 03: Enter to first Textbox");
		registerPage.enterToFirstNameTextbox("Leo");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 04: Enter to Lastname Textbox");
		registerPage.enterToLastNameTextbox("Messi");
	
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 05: Enter to Email Textbox" + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 06: Enter to Password");
		registerPage.enterToPassword("123456");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 07: Enter to Confirm password");
		registerPage.enterToConfirmPassword("123456");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 08: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 09: Verify Success Message Displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 10: Click to Logout Link");
		homePage = registerPage.clickToLogoutLink();
		ExtentTestManager.endTest();
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 01: Click to Login Link");
		loginPage =  homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 03: Enter to Password");
		loginPage.enterToPassword("123456");

		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 05: Verify Myaccount Link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());		
		ExtentTestManager.endTest();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
