package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	
	public  static HomePageOject getHomePageOject(WebDriver driver) {
		return new HomePageOject(driver);
	}
	
	public static LoginPageOject getLoginPageOject(WebDriver driver) {
		return new LoginPageOject(driver);
	}
	
	public static RegisterPageOject getRegisterPageOject(WebDriver driver) {
		return new RegisterPageOject(driver);
	}
	
	public static CustomerInforPageOject getCustomerPageOject(WebDriver driver) {
		return new CustomerInforPageOject(driver);
	}
	
	public static AboutUsPageOject getAboutUsPageOject(WebDriver driver) {
		return new AboutUsPageOject(driver);
	}
	
	public static SiteMapPageOject getSiteMapPageOject(WebDriver driver) {
		return new SiteMapPageOject(driver);
	}
	
	public static NewsPageOject getNewsPageOject(WebDriver driver) {
		return new NewsPageOject(driver);
	}
	
	public static ShoppingCartPageOject getShoppingCartPageOject(WebDriver driver) {
		return new ShoppingCartPageOject(driver);
	}
	
	
}
