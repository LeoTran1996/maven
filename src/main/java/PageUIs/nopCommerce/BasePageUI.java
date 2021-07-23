package PageUIs.nopCommerce;

public class BasePageUI {
	// Khong tham so
	public static final String HOME_PAGE_IMG = "//img[@alt='nopCommerce demo store']";
	public static final String SHOPPING_CART_LINK = "//a[text()='Shopping cart']";
	public static final String ABOUT_US = "//a[text()='About us']";
	public static final String NEWS_LINK = "//a[text()='News']";
	public static final String SITEMAP_LINK = "//a[text()='Sitemap']";
	
	// Co 1 tham so = dynamic page name
	public static final String FOOTER_PAGE_LINK_BY_NAME = "//div[@class='footer']//a[text()='%s']";
	
	public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//a[text()='%s']";

	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";	
}


