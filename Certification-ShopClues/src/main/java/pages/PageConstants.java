package pages;

public class PageConstants 
{
	//Home page
	public final static String BTN_ALLOW = "//button[contains(@class,'moe-btn-allow moe-allow-class')]";
	public final static String DIV_NOTIFICATION = "//div[@class='moe-safari-notification-inner-wrapper']";
	public final static String LINK_SIGNIN = "//li[@id='sign-in']/a";
	public final static String TXT_SRCHBOX = "autocomplete";
	public final static String BTN_SRCH="//a[@class='srch_action btn orange']";
	
	//Sign In page
	public final static String TXT_USERINFO = "main_user_login";
	public final static String TXT_PASSWORD = "//input[@type='password']";
	public final static String BTN_LOGIN="//a[@id='login_button']";
	public final static String LBL_LOGINERRORMSG = "//span[@class='error_span_text user_login_err']";
	public final static String LBL_ERRORMSGPWD = "//div[@style='display: block;']/span[@class='error_span_text password_err']";
	public final static String LBL_ERRORMSGPASS = "//span[@class='error_span_text password_err']";
	public final static String SIGNINPAGE_ERRORMSG ="Incorrect login details.";
	public final static String SIGNINPAGE_ERRORMSGLOGIN ="Please enter valid email id or mobile number.";
	public final static String SIGNINPAGE_ERRORMSGPASS = "Password must be 6 characters or more.";
	
	//Search Results page
	public final static String LBL_PRODUCTCOUNT = "//div[@class='countNo']/p";
	public final static String LBL_PRODUCTS="//div[@class='column col3 search_blocks']//h2";
	public final static String LBL_PRODUCTPRICE="//div[@class='column col3 search_blocks']//span[@class='p_price']";
	
	//Titles
	public final static String TTL_HOMEPAGE = "Online Shopping Site India - Shop Online for men, women and kids fashion, home, kitchen, health, sports and more products at ShopClues";
	public final static String TTL_RESULTPAGE="Online Shopping Store | Buy Online: Mobiles Phone, Computers, Tablets Pc, Home Appliances | Lowest Price shop in India at ShopClues";
	
	
}
