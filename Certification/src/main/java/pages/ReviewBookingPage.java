package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class ReviewBookingPage extends BasePage
{
	
	Logger log = Logger.getLogger(ReviewBookingPage.class);
	
	@FindBy(xpath=PageConstants.LBL_RVWHTLNM)
	private WebElement LBL_rvwHtlNm;
	
	@FindBy(xpath=PageConstants.LBL_RVWRMTYP)
	private WebElement LBL_rvwRmTyp;
	
	@FindBy(xpath=PageConstants.LBL_RVWCHKININFO)
	private List<WebElement> LBL_rvwChkInDtls;
	
	@FindBy(xpath=PageConstants.TXT_FIRSTNAME)
	private WebElement TXT_fName;
	
	@FindBy(xpath=PageConstants.TXT_LASTNAME)
	private WebElement TXT_lName;
	
	@FindBy(xpath=PageConstants.TXT_EMAIL)
	private WebElement TXT_email;
	
	@FindBy(xpath=PageConstants.TXT_MOBNUM)
	private WebElement TXT_mobNum;
	
	@FindBy(xpath=PageConstants.SEL_EXPCHKINTIME)
	private WebElement SEL_expChkInTm;
	
	@FindBy(xpath=PageConstants.ARR_SPLRQST)
	private WebElement ARR_splRqst;
	
	@FindBy(xpath=PageConstants.TXT_SPLRQST)
	private WebElement TXT_splRqust;
	
	@FindBy(xpath=PageConstants.BTN_PYMNTOPTNS)
	private WebElement BTN_pymntOptns;
	
	public ReviewBookingPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getReviewHotelName()
	{
		try
		{
			verifyElementPresent(LBL_rvwHtlNm);
			String rvwHtlNm = LBL_rvwHtlNm.getText();
			Reporter.log("Hotel name from review page is "+rvwHtlNm,true);
			log.info("Review hotel name found is "+rvwHtlNm);
			return rvwHtlNm;
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error with review hotel name.");
		}
		return null;
	}
	
	public String getRoomType()
	{
		try
		{
			verifyElementPresent(LBL_rvwRmTyp);
			String rmType = (LBL_rvwRmTyp.getText()).substring(4);
			Reporter.log("On Review page; Room type is "+rmType,true); 
			log.info("Room type option has been captured with no issues.");
			return rmType;
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error when getting room type option.");
		}
		return " ";
	}
	
	public void verifyCheckInDetails(String mon, String checkInDay, String chkOutDay, String gstNum, String rmNum)
	{
		try
		{
			verifyElementsPresent(LBL_rvwChkInDtls);
			String monTemp=mon.substring(0, 2);
			if((LBL_rvwChkInDtls.get(0).getText()).contains(checkInDay) && (LBL_rvwChkInDtls.get(0).getText()).contains(monTemp))
			{
				Assert.assertTrue(true);
				log.info("Check In date on review page is verified and it is  "+LBL_rvwChkInDtls.get(0).getText());
				Reporter.log("Check In date on review page is verified and it is "+LBL_rvwChkInDtls.get(0).getText(),true);
			}
			
			if((LBL_rvwChkInDtls.get(1).getText()).contains(chkOutDay) && (LBL_rvwChkInDtls.get(1).getText()).contains(monTemp))
			{
				Assert.assertTrue(true);
				log.info("Check Out date on review page is verified and it is  "+LBL_rvwChkInDtls.get(1).getText());
				Reporter.log("Check Out date on review page is verified and it is "+LBL_rvwChkInDtls.get(1).getText(), true);
			}
			
			String[] gstAndRmCntArray = (LBL_rvwChkInDtls.get(2).getText()).split(" ");
			if(gstAndRmCntArray[0]==gstNum && gstAndRmCntArray[1]=="Guest")
			{
				Assert.assertTrue(true);
				log.info("Guest and Roon info is + "+LBL_rvwChkInDtls.get(2).getText());
				Reporter.log("Guest and Room is "+LBL_rvwChkInDtls.get(2).getText(), true);
			}
			if(gstAndRmCntArray[3]==rmNum && gstAndRmCntArray[4]=="Room")
			{
				Assert.assertTrue(true);
				log.info("Guest and Roon info is + "+LBL_rvwChkInDtls.get(2).getText());
				Reporter.log("Guest and Room is "+LBL_rvwChkInDtls.get(2).getText(), true);
			}
			log.info("Checkin information on review page has been verified.");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error getting checkin information.");
		}
	}
	
	public void enterGuestDetails(String fName, String lName, String email, String mobNum, String expCheckIn, String splReqText)
	{
		try
		{
			verifyElementPresent(TXT_fName);
			TXT_fName.sendKeys(fName);
			verifyElementPresent(TXT_lName);
			TXT_lName.sendKeys(lName);
			verifyElementPresent(TXT_email);
			TXT_email.sendKeys(email);
			verifyElementPresent(TXT_mobNum);
			TXT_mobNum.sendKeys(mobNum);
			verifyElementPresent(SEL_expChkInTm);
			Select selDrpdwn = new Select(SEL_expChkInTm);
			if(expCheckIn!="")
				selDrpdwn.selectByValue(expCheckIn);
			if(splReqText!=null || splReqText!="")
			{
				verifyElementPresent(ARR_splRqst);
				ARR_splRqst.click();
				verifyElementPresent(TXT_splRqust);
				TXT_splRqust.sendKeys(splReqText);
			}
			Reporter.log("Review page: guest details entered is: First Name = "+fName+" Last Name = "+lName+" Email = "+email+" Mobile No.= "+
					mobNum+" Expected check-in time = "+expCheckIn+" Special Request Text = "+splReqText,true);
			log.info("Guest Information has been set with no issues.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error entering guest information.");
		}
		
	}
	
	public void clickPaymentOptionsButton()
	{
		try
		{
			verifyElementPresent(BTN_pymntOptns);
			BTN_pymntOptns.click();
			Reporter.log("Payment Options button has been clicked having text: "+BTN_pymntOptns.getText(), true);
			log.info("Proceed to Payment Options button has been clicked.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clicking Proceed to Payment Options button.");
		}
	}
}
