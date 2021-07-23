package pageOject.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageOject getHomePage(WebDriver driver) {
		return new HomePageOject(driver);
	}

}
