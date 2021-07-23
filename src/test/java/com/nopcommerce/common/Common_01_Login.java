package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageOject.nopComerece.AboutUsPageOject;
import pageOject.nopComerece.CustomerInforPageOject;
import pageOject.nopComerece.NewsPageOject;
import pageOject.nopComerece.PageGeneratorManager;
import pageOject.nopComerece.ShoppingCartPageOject;
import pageOject.nopComerece.SiteMapPageOject;


@Epic("Web")
@Feature("User")
public class Common_01_Login extends BaseTest{

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
	public static Set<Cookie> loginPageCookie;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeClass(String browserName, String urlName) {
		log.info("Pre-condition - Step 1: Open Browser: '" + browserName + "' and navigate to '" + urlName + "'");
		driver = getBrowserDriver(browserName,urlName);
		//pageGenerator = PageGeneratorManager.getPageGenerator();
		emailAddress = "Messi" + getRandomNumber() + "@barca.com";
		
		log.info("Common_01 - Step 01: Mo trang Homepage");
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		log.info("Common_01 - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Common_01 - Step 03: Enter to first Textbox");
		registerPage.enterToFirstNameTextbox("Leo");
		
		log.info("Common_01 - Step 04: Enter to Lastname Textbox");
		registerPage.enterToLastNameTextbox("Messi");
	
		log.info("Common_01 - Step 05: Enter to Email Textbox" + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 06: Enter to Password");
		registerPage.enterToPassword("123456");
		
		log.info("Common_01 - Step 07: Enter to Confirm password");
		registerPage.enterToConfirmPassword("123456");
		
		log.info("Common_01 - Step 08: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 09: Verify Success Message Displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Common_01 - Step 10: Click to Logout Link");
		homePage = registerPage.clickToLogoutLink();
			
		log.info("Common_01 - Step 11: Click to Login Link");
		loginPage =  homePage.clickToLoginLink();
		
		log.info("Common_01 - Step 12: Enter to Email textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 13: Enter to Password");
		loginPage.enterToPassword("123456");

		log.info("Common_01 - Step 14: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common_01 - Step 15: Verify Myaccount Link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());	
		
		log.info("Common_01 - Step 16: Get all login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		
		log.info("Post-condition - Step 01: Close browser/driver+ " + browserName);
		closeBrowserAndDriver(driver);
	}

}
