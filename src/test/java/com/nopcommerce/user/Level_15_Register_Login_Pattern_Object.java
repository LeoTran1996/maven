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

public class Level_15_Register_Login_Pattern_Object extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	pageOject.nopComerece.HomePageOject homePage;
	pageOject.nopComerece.LoginPageOject loginPage;
	pageOject.nopComerece.RegisterPageOject registerPage;
	String emailAddress, date, month,year;
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
		date = "8";
		month = "March";
		year = "2000";
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Mo trang Homepage");
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 02: Click to Register Link");
		homePage.openHeaderPageName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPageOject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 03: Enter to first Textbox");
		registerPage.enterToTextBoxByID(driver, "FirstName", "Leo");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 04: Enter to Lastname Textbox");
		registerPage.enterToTextBoxByID(driver, "LastName", "Messi");
	
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 05: Enter to Email Textbox" + emailAddress);
		registerPage.enterToTextBoxByID(driver, "Email", emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 06: Enter to Password");
		registerPage.enterToTextBoxByID(driver, "Password", "123456");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 07: Enter to Confirm password");
		registerPage.enterToTextBoxByID(driver, "ConfirmPassword", "123456");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 08: Select Item in Date dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 09: Click to Register Button");
		registerPage.clickToButtonByText(driver, "Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 10: Verify Success Message Displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 11: Click to Logout Link");
		registerPage.openHeaderPageName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePageOject(driver);
		ExtentTestManager.endTest();
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 01: Click to Login Link");
		
		homePage.openHeaderPageName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPageOject(driver);
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 03: Enter to Password");
		loginPage.enterToPassword("123456");

		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 04: Click to Login button");
		registerPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 05: Verify Myaccount Link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());		
		ExtentTestManager.endTest();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
