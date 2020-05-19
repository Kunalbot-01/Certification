package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class HotelDetailPage extends BasePage
{
	Logger log = Logger.getLogger(HotelDetailPage.class);
	
	@FindBy(xpath=PageConstants.LBL_HOTELNAME)
	private WebElement LBL_hotelName;
	
	@FindBy(xpath=PageConstants.BTN_VWRMOPTNS)
	private WebElement BTN_vwRmOptns;
	
	@FindBy(xpath=PageConstants.BTN_SLCTRM)
	private List<WebElement> BTN_slctRoom;
	
	@FindBy(xpath=PageConstants.LBL_RMOPTS)
	private WebElement LBL_roomOpts;
	
	@FindBy(xpath=PageConstants.LNK_LOCATION)
	private WebElement LNK_location;
	
	@FindBy(xpath=PageConstants.IMG_LOCATION)
	private WebElement IMG_location;
	
	@FindBy(xpath=PageConstants.LNK_GUESTRVW)
	private WebElement LNK_guestReviews;
	
	@FindBy(xpath=PageConstants.DIV_GUESTRVW)
	private WebElement DIV_guestReviews;
	
	@FindBy(xpath=PageConstants.LNK_QUESANDANSWR)
	private WebElement LNK_quesAndAns;
	
	@FindBy(xpath=PageConstants.DIV_QUESANDANSWR)
	private WebElement DIV_quesAndAns;
	
	@FindBy(xpath=PageConstants.LNK_HOTELPOLICIES)
	private WebElement LNK_hotelPolicies;
	
	@FindBy(xpath=PageConstants.DIV_HOTELPOLICIES)
	private WebElement DIV_hotelPolicies;
	
	public HotelDetailPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getHotelName()
	{
		try
		{
			verifyElementPresent(LBL_hotelName);
			String hName = LBL_hotelName.getText();
			log.info("Hotel name found on Hotel detail page is "+hName);
			return hName;
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error when getting the hotel name from the hotel detail page.");
		}
		return null;
	}
	
	public void clickRoomOptions()
	{
		try
		{
			verifyElementPresent(BTN_vwRmOptns);
			BTN_vwRmOptns.click();
			log.info("View Room Options button is clicked.");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error when clicking view room options button.");
		}
	}
	
	public void clickSelectRoom()
	{
		try
		{
			verifyElementsPresent(BTN_slctRoom);
			BTN_slctRoom.get(0).click();
			log.info("First select room is clicked.");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error when selecting room.");
		}
	}
	
	public String getRoomOptionText()
	{
		try
		{
			verifyElementPresent(LBL_roomOpts);
			String rmOption = LBL_roomOpts.getText();
			log.info("Room option label found with no issues.");
			return rmOption;
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error getting room option label.");
		}
		return "";
	}
	
	public void verifyLocation()
	{
		try
		{
			verifyElementPresent(LNK_location);
			LNK_location.click();
			Reporter.log("Location link is clicked.",true);
			log.info("Location link is clicked.");
			Boolean locPresent = IMG_location.isDisplayed();
			if(locPresent)
			{
				Reporter.log("Location image is present.",true);
			}
			else
			{
				Reporter.log("Location image is not present.",true);
			}
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error verifying location link and image.");
		}
	}
	
	public void verifyGuestReviews()
	{
		try
		{
			verifyElementPresent(LNK_guestReviews);
			LNK_guestReviews.click();
			Reporter.log("Guest reviews link is clicked.",true);
			log.info("Guest reviews link is clicked.");
			Boolean isPresent = DIV_guestReviews.isDisplayed();
			if(isPresent)
			{
				Reporter.log("Guest review section is present.",true);
			}
			else
			{
				Reporter.log("Guest review section is not present.",true);
			}
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error verifying guest review link and section.");
		}
	}
	
	public void verifyQuestionsAndAnswers()
	{
		try
		{
			verifyElementPresent(LNK_quesAndAns);
			LNK_quesAndAns.click();
			Reporter.log("Questions and Answers link is clicked.",true);
			log.info("Questions and Answers link is clicked.");
			Boolean isPresent = DIV_quesAndAns.isDisplayed();
			if(isPresent)
			{
				Reporter.log("Questions and Answers section is present.",true);
			}
			else
			{
				Reporter.log("Questions and Answers section is not present.",true);
			}
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error verifying Questions and Answers link and section.");
		}
	}
	
	public void verifyHotelPolicies()
	{
		try
		{
			verifyElementPresent(LNK_hotelPolicies);
			LNK_hotelPolicies.click();
			Reporter.log("Hotel policies link is clicked.",true);
			log.info("Hotel policies link is clicked.");
			Boolean isPresent = DIV_quesAndAns.isDisplayed();
			if(isPresent)
			{
				Reporter.log("Hotel policies section is present.",true);
			}
			else
			{
				Reporter.log("Hotel policies section is not present.",true);
			}
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error verifying Hotel policies link and section.");
		}
	}


}
