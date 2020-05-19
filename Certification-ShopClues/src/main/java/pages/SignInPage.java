package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class SignInPage extends BasePage 
{
	Logger log = Logger.getLogger(SignInPage.class);
	String hotelCount=null;
	
	@FindBy(id=PageConstants.TXT_USERINFO)
	private WebElement TXT_userInfo;
	
	@FindBy(xpath=PageConstants.TXT_PASSWORD)
	private WebElement TXT_password;
	
	@FindBy(xpath=PageConstants.BTN_LOGIN)
	private WebElement BTN_login;
	
	@FindBy(xpath=PageConstants.LBL_ERRORMSGPWD)
	private WebElement LBL_errorMsg;
	
	@FindBy(xpath=PageConstants.LBL_ERRORMSGPASS)
	private WebElement LBL_errorMsgPass;
	
	@FindBy(xpath=PageConstants.LBL_LOGINERRORMSG)
	private WebElement LBL_errorMsgLogin;
	
		public SignInPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginButton()
	{
		try
		{
			verifyElementPresent(BTN_login);
			BTN_login.click();
			Reporter.log("Clicking on the login button from sign in page.",true);
			log.info("Sign In button is clicked.");
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Sign In button is having issues.");
		}
	}
	
	
	public void setUserInformation(String userInfo)
	{
		try
		{
			verifyElementPresent(TXT_userInfo);
			TXT_userInfo.sendKeys(userInfo);;
			log.info(userInfo+ " user information has been sent to textbox.");
			Reporter.log(userInfo+ " user information has been sent to textbox.",true);
			
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error sending userinfo to textbox.");
		}
	}
	
	public void setPassword(String pass)
	{
		try
		{
			verifyElementPresent(TXT_password);
			TXT_password.sendKeys(pass);
			
			Reporter.log("Password "+pass+" sent to password text box.");
			
		}
		catch(Exception e)
		{
			
			log.error(e);
			log.error("Problem with setting password "+pass+" to password textbox.");
			Assert.fail();
		}
	}
	
	public boolean verifyLoginErrorMsg()
	{
		try
		{
				if(LBL_errorMsgLogin.isDisplayed())
				{
					String actErrorMsg = LBL_errorMsgLogin.getText();
					if(actErrorMsg.contentEquals(PageConstants.SIGNINPAGE_ERRORMSGLOGIN))
					{
						Reporter.log("Pass: Error message is correct.",true);
						Reporter.log("Actual error message is "+actErrorMsg,true);
						Reporter.log("Expected error message is "+PageConstants.SIGNINPAGE_ERRORMSGLOGIN,true);
					}
					else
					{
						Reporter.log("Fail: Error message is not correct.",true);
						Reporter.log("Actual error message is "+actErrorMsg,true);
						Reporter.log("Expected error message is "+PageConstants.SIGNINPAGE_ERRORMSGLOGIN,true);
					}
					return true;
				}
			}
			catch(Exception e)
			{
				log.error(e);
				log.error("Error occured verifying login error message.");
				
			}
		return false;
		}
		
	
	public void verifyErrorPasswordMsg()
	{
		try
		{
			if(LBL_errorMsgPass.isDisplayed())
				{
					String actErrorMsg = LBL_errorMsgPass.getText();	
					if(actErrorMsg.contentEquals(PageConstants.SIGNINPAGE_ERRORMSGPASS))
					{
						Reporter.log("Pass: Error message is correct.",true);
						Reporter.log("Actual error message is "+actErrorMsg,true);
						Reporter.log("Expected error message is "+PageConstants.SIGNINPAGE_ERRORMSGPASS,true);
					}
					else
					{
						Reporter.log("Fail: Error message is not correct.",true);
						Reporter.log("Actual error message is "+actErrorMsg,true);
						Reporter.log("Expected error message is "+PageConstants.SIGNINPAGE_ERRORMSGPASS,true);
					}
					
					
			}
			
			else if(LBL_errorMsg.isDisplayed())
				{
					String actErrorMsg = LBL_errorMsg.getText();	
					if(actErrorMsg.contentEquals(PageConstants.SIGNINPAGE_ERRORMSG))
					{
						Reporter.log("Pass: Error message is correct.",true);
						Reporter.log("Actual error message is "+actErrorMsg,true);
						Reporter.log("Expected error message is "+PageConstants.SIGNINPAGE_ERRORMSG,true);
					}
					else
					{
						Reporter.log("Fail: Error message is not correct.",true);
						Reporter.log("Actual error message is "+actErrorMsg,true);
						Reporter.log("Expected error message is "+PageConstants.SIGNINPAGE_ERRORMSG,true);
					}
					
				}
				
				log.info("Comparing error message with actual and expected worked fine.");
				
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error getting and comparing error messages..");
		}
		
	}
	
	public void clearUserInfoTextBox()
	{
		try
		{
			verifyElementPresent(TXT_userInfo);
			TXT_userInfo.clear();
			log.info("User information textbox has been cleared.");
			Reporter.log("User information textbox has been cleared.",true);
			
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clearing userinfo textbox.");
		}
		
	}
	
	public void clearPasswordTextBox()
	{
		try
		{
			verifyElementPresent(TXT_password);
			TXT_password.clear();
			log.info("Password textbox has been cleared.");
			Reporter.log("Password textbox has been cleared.",true);
			
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error clearing password textbox.");
		}
		
	}

	
}
