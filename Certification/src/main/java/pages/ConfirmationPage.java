package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import generic.BasePage;

/**
 * This class is to support the confirmation page in the list.
 * 
 * @author Shalu chawla
 *
 */
public class ConfirmationPage extends BasePage {
	Logger log = Logger.getLogger(ConfirmationPage.class);

	@FindBy(xpath = PageConstants.LBL_ERRORMSG)
	private WebElement LBL_errorMsg;

	/**
	 * This is the default constructor for the method
	 *  
	 * @param driver the webdriver object
	 * 
	 * 
	 */
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is to verify the expected out of confirmation page
	 *  
	 */
	public void verifyErrorMsg() {
		try {
			verifyElementPresent(LBL_errorMsg);
			Assert.assertEquals(LBL_errorMsg.getText(), PageConstants.CONFPAGE_ERRORMSG);
			Reporter.log("Error message showing up on confirmation page is " + LBL_errorMsg.getText(), true);
			log.info("Verify error message on conf page works fine.");

		} catch (Exception e) {
			log.error(e);
			log.error("Error when verifying confirmation error message.");
		}
	}

}
