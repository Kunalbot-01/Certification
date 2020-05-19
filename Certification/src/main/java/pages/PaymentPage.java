package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class PaymentPage extends BasePage 
{
	Logger log = Logger.getLogger(PaymentPage.class);
	
	@FindBy(xpath=PageConstants.TXT_CARDNUM)
	private WebElement TXT_cardNum;
	
	@FindBy(xpath=PageConstants.TXT_NAMEONCARD)
	private WebElement TXT_nameOnCard;
	
	@FindBy(xpath=PageConstants.TXT_EXPDATE)
	private WebElement TXT_expDate;
	
	@FindBy(xpath=PageConstants.TXT_CVVNUM)
	private WebElement TXT_cvvNum;
	
	@FindBy(xpath=PageConstants.BTN_PAY)
	private WebElement BTN_pay;
	
	public PaymentPage (WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterCardDetails(String cardNum, String nameOnCard, String expMon, String expYear, String cvvNum)
	{
		try
		{
			verifyElementPresent(TXT_cardNum);
			TXT_cardNum.sendKeys(cardNum);
			verifyElementPresent(TXT_nameOnCard);
			TXT_nameOnCard.sendKeys(nameOnCard);
			verifyElementPresent(TXT_expDate);
			TXT_expDate.sendKeys(expMon);
			TXT_expDate.sendKeys(expYear);
			verifyElementPresent(TXT_cvvNum);
			TXT_cvvNum.sendKeys(cvvNum);
			Reporter.log("Payment Page-Card details entered; Card number:= "+cardNum+" Name on Card:= "+nameOnCard+"\nExpiry month and year:= "+expMon+"/"
					+expYear+" CVV number= "+cvvNum,true);
			log.info("Card information has been entered on the payment page.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error entering card details on the payment page.");
		}
	}
	
	public void clickPay()
	{
		try
		{
			verifyElementPresent(BTN_pay);
			BTN_pay.click();
			Reporter.log("Pay button is clicked and button's text is "+BTN_pay.getText(),true);
			log.info("Pay button is clicked on payment page with no issues.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clicking payment page.");
		}
	}

}
