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
	@FindBy(xpath=PageConstants.LINK_HOTEL)
	private WebElement LNK_hotel;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 */
	public void clickHotels() {
		try
		{
			verifyElementPresent(LNK_hotel);
			LNK_hotel.click();
			Reporter.log("Hotel link is clicked from the Home page.",true);
			log.info("Hotel link from main menu is clicked with no issues.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Hotel link is not getting clicked.");
		}
	}

}
