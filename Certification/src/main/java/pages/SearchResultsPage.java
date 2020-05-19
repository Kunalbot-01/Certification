package pages;

import java.util.HashSet;
import java.util.List;
//import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class SearchResultsPage extends BasePage 
{
	Logger log = Logger.getLogger(SearchResultsPage.class);
	
	@FindBy(xpath=PageConstants.LBL_HOTELNAME)
	private WebElement LBL_hotelName;
	
	@FindBy(xpath=PageConstants.IMG_HOTEL)
	private WebElement IMG_hotel;
	
	@FindBy(xpath=PageConstants.BNR_LOGIN)
	private WebElement BNR_login;
	
	@FindBy(xpath=PageConstants.BTN_BACKTOTOP)
	private WebElement BTN_bckToTop;
	
	@FindBy(xpath=PageConstants.CHK_PAYATHOTEL)
	private WebElement CHK_payAtHotel;
	
	@FindBy(xpath=PageConstants.CHK_PRICERANGE2)
	private WebElement CHK_priceRange2opt;
	
	@FindBy(xpath=PageConstants.CHK_RATING4)
	private WebElement CHK_rating4;
	
	@FindBy(xpath=PageConstants.LBL_PRICE)
	private List<WebElement> LBL_price;
	
	@FindBy(xpath=PageConstants.LBL_RATING)
	private List<WebElement> LBL_rating;
	
	public SearchResultsPage (WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getFstHtlName()
	{
		try
		{
			verifyElementPresent(LBL_hotelName);
			String hotelName=LBL_hotelName.getText();
			Reporter.log("First Hotel name found in Results is "+hotelName, true);
			log.info("First Hotel name found in Resultset is "+hotelName);
			return hotelName;
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("First Hotel name in resultset is in error.");
		}
		return " ";
		
	}
	
	public void getHotelsCount()
	{
		try
		{
			
			Set<String> tempSet = new HashSet<String>();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
            long value = (Long) executor.executeScript("return document.body.scrollHeight");
			//verifyElementPresent(LBL_hotelName);
			for(int x = 300; x<=value; x+=250) 
			{
			verifyElementPresent(LBL_hotelName);
			String hName= LBL_hotelName.getText();
			tempSet.add(hName);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+x+")");
			
			Thread.sleep(5000);
			}
			int numOfHtls=tempSet.size();
			Reporter.log("Number of hotels on search result page are "+numOfHtls,true);
			log.info("Number of hotels showing up on results page are "+numOfHtls);
			verifyElementPresent(BTN_bckToTop);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
			BTN_bckToTop.click();
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("There is error getting number of hotels.");
		}
	}
	
	public void clickHotel()
	{
		try
		{
			verifyElementPresent(IMG_hotel);
			String parentWindow = driver.getWindowHandle();
			Reporter.log("Parent Window handle is "+parentWindow, true);
			IMG_hotel.click();
			Set<String> handles = driver.getWindowHandles();
			for(String handle: handles)
			{
				if(!handle.equals(parentWindow))
				{
					Reporter.log("Child window handle is "+ handle, true);
					driver.switchTo().window(handle);
				}
				
			}
			Reporter.log("First hotel from the search result has been clicked.",true);
			log.info("Clicked on the first hotels from the search criteria.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error when clicking on the hotel.");
		}

		
	}
	
	public void applyPopularFilter()
	{
		try
		{
			verifyElementPresent(CHK_payAtHotel);
			CHK_payAtHotel.click();
			Reporter.log("Clicked on Pay at Hotel checkbox under popular filters.",true);
			log.info("Clicked on Pay at Hotel checkbox under popular filters.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clicking Pay at Hotel checkbox.");
		}
	}
	
	public void applyPriceRangeFilter()
	{
		try
		{
			verifyElementPresent(CHK_priceRange2opt);
			CHK_priceRange2opt.click();
			Reporter.log("Clicked on Price range second checkbox under price range filters.",true);
			log.info("Clicked on Price range second checkbox under price range filters.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clicking Pay at price range checkbox.");
		}
	}
	
	public void applyRatingFilter()
	{
		try
		{
			verifyElementPresent(CHK_rating4);
			CHK_rating4.click();
			Reporter.log("Clicked on rating 4 and above under Ratings section.",true);
			log.info("Clicked on rating 4 and above under Ratings section.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clicking rating checkbox.");
		}
	}
	
	public void verifyPriceAfterFilter()
	{
		try
		{
			verifyElementsPresent(LBL_price);
			String[] arrPrcRng = CHK_priceRange2opt.getText().split(" - ");
			int lowPrice = Integer.parseInt(arrPrcRng[0].substring(1));
			int highPrice = Integer.parseInt(arrPrcRng[1].substring(1));
			int actPrice = Integer.parseInt(LBL_price.get(0).getText());
			String hotelName=LBL_hotelName.getText();
			if(actPrice>=lowPrice && actPrice<=highPrice)
			{
				Reporter.log("Price "+actPrice+" Showing up on hotel "+hotelName+" is within the range "+lowPrice+" - "+highPrice, true);
				log.info("Price "+actPrice+" Showing up on hotel "+hotelName+" is within the range "+lowPrice+" - "+highPrice);
			}
						
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error verifying price for the first hotel.");
		}
	}
	
	public void verifyRatingAfterFilter()
	{
		try
		{
			verifyElementsPresent(LBL_rating);
			String[] arrRating = LBL_rating.get(0).getText().split(" / ");
			String rating = arrRating[0];//.replaceAll("\"", "");
			Float actRating = Float.parseFloat(rating);
			String hotelName=LBL_hotelName.getText();
			if(actRating>4)
			{
				Reporter.log("Rating "+actRating+" Showing up for hotel "+hotelName+" is greater than 4", true);
				log.info("Rating "+actRating+" Showing up for hotel "+hotelName+" is greater than 4");
			}
			else
			{
				Reporter.log("Rating "+actRating+" showing up for hotel "+hotelName+" is not greater than 4", true);
				log.info("Rating "+actRating+" showing up for hotel "+hotelName+" is not greater than 4");
			}
						
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error verifying rating for the first hotel.");
		}
	}

}
