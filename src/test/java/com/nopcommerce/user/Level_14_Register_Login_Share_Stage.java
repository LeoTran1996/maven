package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

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
public class Level_14_Register_Login_Share_Stage extends BaseTest{

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
		log.info("Pre-condition - Step 01: Open Browser: '" + browserName + "' and navigate to '" + urlName + "'");
		driver = getBrowserDriver(browserName,urlName);
		//pageGenerator = PageGeneratorManager.getPageGenerator();
		emailAddress = "Messi" + getRandomNumber() + "@barca.com";
		
		homePage=PageGeneratorManager.getHomePageOject(driver);
		
		log.info("Pre-condition  - Step 02: Click to Login Link");
		loginPage =  homePage.clickToLoginLink();
		
		log.info("Pre-condition  - Step 03: Set login page cookies");
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
	
		loginPage.sleepInSecond(5);
		loginPage.refreshPage(driver);
		
		log.info("Pre-condition  - Step 04: Click to HomePage logo");
		homePage = loginPage.openHomePage();
		
		log.info("Pre-condition  - Step 04: Verify Homepage is displayed");
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		
	}
	@Test
	public void User_01_Login() {
		
	}
	@Test
	public void User_02_Login() {
		
	}
	
	@Parameters("browser")
	@AfterClass
	public void clearBrowser(String browserName) {
		log.info("Post-condition - Step 01: Close browser/driver+ " + browserName);
		closeBrowserAndDriver(driver);
	}

}
