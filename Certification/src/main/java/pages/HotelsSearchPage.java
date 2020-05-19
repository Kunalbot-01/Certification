package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class HotelsSearchPage extends BasePage 
{
	Logger log = Logger.getLogger(HotelsSearchPage.class);
	String hotelCount=null;
	
	@FindBy(xpath=PageConstants.RADIO_INDIA)
	private WebElement RDO_india;
	
	@FindBy(xpath=PageConstants.RADIO_INTRNTNLS)
	private WebElement RDO_foreign;
	
	@FindBy(id=PageConstants.TXT_WHERE)
	private WebElement TXT_where;
	
	@FindBy(xpath=PageConstants.DRP_SELCITY1)
	private WebElement DRP_selectCity;
	
	@FindBy(xpath=PageConstants.LBL_MNTH)
	private WebElement LBL_monYear;
	
	@FindBy(xpath=PageConstants.BOX_CHKIN)
	private WebElement BOX_checkin;
		
	@FindBy(xpath=PageConstants.BOX_CHKOUT)
	private WebElement BOX_checkout;
	
	@FindBy(xpath=PageConstants.ARR_RIGHT)
	private WebElement ARR_right;
	
	@FindBy(xpath=PageConstants.BOX_GSTNRM)
	private WebElement BOX_gstNdRm;
	
	@FindBy(xpath=PageConstants.VLU_RMCNT)
	private WebElement VLU_rmCnt;
	
	@FindBy(xpath=PageConstants.SGN_PLUS_RM)
	private WebElement SGN_plsRM;
	
	@FindBy(xpath=PageConstants.SGN_MNS_RM)
	private WebElement SGN_mnsRM;
	
	@FindBy(xpath=PageConstants.VLU_GSTCNT)
	private WebElement VLU_gstCnt;
	
	@FindBy(xpath=PageConstants.SGN_PLUS_GST)
	private WebElement SGN_plsGST;
	
	@FindBy(xpath=PageConstants.SGN_MNS_GST)
	private WebElement SGN_mnsGST;
	
	@FindBy(xpath=PageConstants.BTN_DONE)
	private WebElement BTN_done;
	
	@FindBy(xpath=PageConstants.BTN_SEARCH_HOTELS)
	private WebElement BTN_srchHtls;
	
		public HotelsSearchPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSearchHotels()
	{
		try
		{
			verifyElementPresent(BTN_srchHtls);
			BTN_srchHtls.click();
			Reporter.log("Clicking on the search hotels from Hotle Search page.",true);
			log.info("Search hotels button is clicked.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Search hotels is having issues.");
		}
	}
	
	public void setSrchHtlsCriteria(String isDomestic, String locWhere, String mon, String chkInDay, String chkOutDay, String rmCnt, String gstCnt)
	{
		try
		{
			Reporter.log("Setting up search criteria on Hotel Search page.",true);
			//select radio button
			setRadioButton(isDomestic);
						
			//fill in location and select the first option
			setLocationText(locWhere);
			
			//click and select check-in and check-out date
			if(mon!=""&&chkInDay!=""&&chkOutDay!= "")
			{
				setCheckInAndCheckOutDate(mon, chkInDay, chkOutDay);
			}
			
			//setChkOutDate(chkOutDay);
			setGstNdRm(rmCnt, gstCnt);					
		}
		catch(Exception e)
		{
			log.error("Problem occurred while setting up the search criterias.");
		}
	}
	
	public void setRadioButton(String isDomestic)
	{
		try
		{
			if(isDomestic=="Y")
			{
				verifyElementPresent(RDO_india);
				RDO_india.click();
				log.info("India Radio button is clicked.");
				Reporter.log("Radio button: India is selected.",true);
			}
			else if (isDomestic=="N")
			{
				verifyElementPresent(RDO_foreign);
				RDO_foreign.click();
				log.info("International Radio button is clicked.");
				Reporter.log("Radio button: Internaltional is selected.",true);
			}
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error setting up Radion button.");
		}
	}
	
	public void setLocationText(String locWhere)
	{
		try
		{
			verifyElementPresent(TXT_where);
			TXT_where.sendKeys(locWhere);
			
			if(DRP_selectCity.isDisplayed()) 
			{
				hotelCount = DRP_selectCity.getText();
				Reporter.log(DRP_selectCity.getText()+" is displayed.",true);
				System.out.println(DRP_selectCity); 
				DRP_selectCity.click(); 
			} 
			else 
			{
					Reporter.log(DRP_selectCity.getText()+" is not displayed.",true);
			}

			//mouseOverAndClick(DRP_selectCity);
			Reporter.log("Location "+locWhere+" sent to text box and first option offerred is selected");
			
		}
		catch(Exception e)
		{
			
			log.error(e);
			log.error("Problem with setting up the location "+locWhere+" in search criteria.");
			Assert.fail();
		}
	}
	
	public void setCheckInAndCheckOutDate(String mon, String chkInDay, String chkOutDay)
	{
		try
		{
			verifyElementPresent(BOX_checkin);
			mouseOverAndClick(BOX_checkin);
			verifyElementPresent(LBL_monYear);
			String lbl_monthYr = LBL_monYear.getText();
			String[] mntArray= lbl_monthYr.split(" ");
			if(!mntArray[0].equalsIgnoreCase(mon))
			{
				setMonth(mon);
			}
			setDate(chkInDay);
			setDate(chkOutDay);
			
			Reporter.log("Check In day is "+chkInDay+" month is "+mon+" Check Out day is "+chkOutDay, true);
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Problem occured setting up checkin and checkout dates");
		}
	}
	
	public void setMonth(String mon)
	{
		try 
		{
			verifyElementPresent(ARR_right);
			ARR_right.click();
			log.info("Next month is clicked.");
			
		}
		catch(Exception e)
		{
			log.error("Problem clicking next month.");
		}
	}
	
	public void setDate(String dayInput) {
		try
		{
			WebElement LNK_chkdate = driver.findElement(By.xpath("//span[text()='"+dayInput+"']"));
			verifyElementPresent(LNK_chkdate);
			LNK_chkdate.click();
			log.info("Given date "+dayInput+" is selected.");
			
		}
		catch(Exception e)
		{
			log.error("Problem selecting the given "+dayInput+" date.");
		}
	}
	
	
	public void setGstNdRm(String rmCnt, String gstCnt)
	{
		try
		{
			verifyElementPresent(BOX_gstNdRm);
			BOX_gstNdRm.click();
			verifyElementPresent(VLU_rmCnt);
			String rmCount = VLU_rmCnt.getText();
			if(Integer.parseInt(rmCnt) > Integer.parseInt(rmCount))
			{
				SGN_plsRM.click();
			}
			else if ((Integer.parseInt(rmCnt) < Integer.parseInt(rmCount)) && (Integer.parseInt(rmCnt) >= 1) )
			{
				SGN_mnsRM.click();
			}
			
			verifyElementPresent(VLU_gstCnt);
			String gstCount = VLU_gstCnt.getText();
			if(Integer.parseInt(gstCnt) > Integer.parseInt(gstCount))
			{
				SGN_plsGST.click();
			}
			else if ((Integer.parseInt(gstCnt) < Integer.parseInt(gstCount)) && (Integer.parseInt(gstCnt) >= 1) )
			{
				SGN_mnsGST.click();
			}
			//String value=null;
			BTN_done.click();
			
			String text = BOX_gstNdRm.getAttribute("value");
			
			//String text2 = BOX_gstNdRm.toString();
		
			//System.out.println("text is "+text);
			
			//System.out.println("text2 is "+text2);
			String[] txtArray= text.split(" ");
			Reporter.log("Verifying guest count. Expected guest count is "+gstCnt+" actual is "+txtArray[0], true);
			Reporter.log("Verifying room count. Expected room count is "+rmCnt+" actual is "+txtArray[3], true);
			Assert.assertEquals(txtArray[0], gstCnt);
			Assert.assertEquals(txtArray[3], rmCnt);
			
			log.info("Room and guest count have been set with no issues.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error setting Room and guest count.");
		}
		
	
		
	}
	public String getHotelCountFromDropDownString()
	{
		try
		{
			System.out.println(hotelCount);
			String[] arrHotelCount = hotelCount.split("\n");
			System.out.println("Array is ");
			for (int i = 0; i<arrHotelCount.length;i++)
			{
				System.out.println("i is "+i+"value is "+arrHotelCount[i]);
				if (arrHotelCount[i].contains("Hotels"))
				{
					String[] newArr = arrHotelCount[i].split(" ");
					System.out.println(newArr[0]);
					return newArr[0];
				}
				
			}
			log.info("Getting hotel count from the dropdown link text.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error getting hotel count.");
		}
		
		return "";
		
	}

	
	
	
	/*
	 * private WebElement prepareWebElementWithDynamicXpath (String xpathValue,
	 * String substitutionValue ) {
	 * 
	 * return driver.findElement(By.xpath(xpathValue.replace("xxxxx",
	 * substitutionValue))); }
	 */

}
