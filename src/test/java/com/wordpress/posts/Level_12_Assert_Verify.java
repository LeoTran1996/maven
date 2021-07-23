package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageOjects.wordpress.DashboardPageOject;
import pageOjects.wordpress.LoginPageOject;

public class Level_12_Assert_Verify extends BaseTest {

	WebDriver driver;
	DashboardPageOject dashboardPage;
	LoginPageOject loginPage;

	@Parameters({ "browser" , "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	}
	
	@Test
	public void Login_01_Assert() {
		System.out.println("Step 1");
		Assert.assertTrue(false);
		
		System.out.println("Step 2");
		Assert.assertTrue(true);
		
		System.out.println("Step 3");
		Assert.assertFalse(true);
		
		System.out.println("Step 4");
		Assert.assertFalse(false);
	}
	
	@Test
	public void Login_02_Verify() {
		System.out.println("Step 1");
		verifyTrue(false);
		
		System.out.println("Step 2");
		verifyTrue(true);
		
		System.out.println("Step 3");
		verifyFalse(true);
		
		System.out.println("Step 4");
		verifyFalse(false);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
