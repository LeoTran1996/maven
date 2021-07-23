package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageOject.nopComerece.AboutUsPageOject;
import pageOject.nopComerece.CustomerInforPageOject;
import pageOject.nopComerece.NewsPageOject;
import pageOject.nopComerece.PageGeneratorManager;
import pageOject.nopComerece.ShoppingCartPageOject;
import pageOject.nopComerece.SiteMapPageOject;

public class Level_08_Login_Page_Dynamic_Locator extends BaseTest{

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
		
		homePage = PageGeneratorManager.getHomePageOject(driver);
	}

	@Test
	public void User_01_Register() {
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("Leo");
		
		registerPage.enterToLastNameTextbox("Messi");
	
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPassword("123456");
		
		registerPage.enterToConfirmPassword("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		homePage = registerPage.clickToLogoutLink();
			
	}
	
	@Test
	public void User_02_Login() {
		
		loginPage =  homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailAddress);
		
		loginPage.enterToPassword("123456");
		

		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}
	@Test
	public void User_03_Customer_Infor() {
		
		
		customerInforPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerInforPage.getFirstnameTextBoxValue(), "Leo");
		
		Assert.assertEquals(customerInforPage.getLastnameTextBoxValue(), "Messi");
		
		Assert.assertEquals(customerInforPage.getEmailTextBoxValue(), emailAddress);
			
	}
	@Test
	public void User_04_Switch_Page() {
		
		//siteMapPage = customerInforPage.openSiteMapPage(driver);
		siteMapPage = (SiteMapPageOject) customerInforPage.openFooterPageByName(driver, "Sitemap");
		
		newsPage = (NewsPageOject) siteMapPage.openFooterPageByName(driver, "News");
		
		shoppingCartPage = (ShoppingCartPageOject) newsPage.openFooterPageByName(driver, "Shopping cart");
		
		aboutUsPage = (AboutUsPageOject) shoppingCartPage.openFooterPageByName(driver, "About us");
		
		shoppingCartPage = (ShoppingCartPageOject) aboutUsPage.openFooterPageByName(driver, "Shopping cart");
		
		siteMapPage = (SiteMapPageOject) shoppingCartPage.openFooterPageByName(driver, "Sitemap");
		
	}
	@Test
	public void User_05_Switch_Page() {
	
		//siteMapPage = customerInforPage.openSiteMapPage(driver);
		siteMapPage.openFooterPageName(driver, "News");
		newsPage = PageGeneratorManager.getNewsPageOject(driver);
		
		newsPage.openFooterPageName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPageOject(driver);
		
		shoppingCartPage.openFooterPageName(driver, "About us");
		aboutUsPage = PageGeneratorManager.getAboutUsPageOject(driver);
		
		aboutUsPage.openFooterPageName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPageOject(driver);
		
		shoppingCartPage.openFooterPageName(driver, "News");
		newsPage = PageGeneratorManager.getNewsPageOject(driver);
		
		

		
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
