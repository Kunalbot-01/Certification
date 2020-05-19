package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

/**
 * 
 * 
 * @author Shalu chawla
 *
 */
public class HomePage extends BasePage {
	
	Logger log = Logger.getLogger(HomePage.class);	
	
	@FindBy(xpath=PageConstants.BTN_ALLOW)
	private WebElement BTN_allow;
	
	@FindBy(xpath=PageConstants.DIV_NOTIFICATION)
	private WebElement DIV_notification;
	
	@FindBy(xpath=PageConstants.LINK_SIGNIN)
	private WebElement LNK_signIn;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 */
	public void clickAllowButton() {
		try
		{
			Thread.sleep(10000);
			if(DIV_notification.isDisplayed())
			{
				//verifyElementPresent(BTN_allow);
				mouseOverAndClick(BTN_allow);
				//BTN_allow.click();
				Reporter.log("Allow button from the pop-up alert window is clicked from the Home page.",true);
				log.info("Allow button from the pop-up alert window is clicked with no issues.");
			}
			else
			{
				Reporter.log("Allow button from the pop-up alert window is not displayed.",true);
				log.info("Allow button from the pop-up alert window is not displayed.");
			}
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Allow button from the pop-up alert window not getting clicked.");
		}
	}
	
	public void clickSignIn()
	{
		try
		{
			verifyElementPresent(LNK_signIn);
			LNK_signIn.click();
			Reporter.log("SignIn link is clicked from the Home page.",true);
			log.info("SignIn link is clicked with no issues.");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clicking SignIn link from home page.");
		}
	}

}
