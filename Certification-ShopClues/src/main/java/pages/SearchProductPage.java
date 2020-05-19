package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import generic.BasePage;

/**
 * This class is to support the confirmation page in the list.
 * 
 * @author Shalu chawla
 *
 */
public class SearchProductPage extends BasePage {
	Logger log = Logger.getLogger(SearchProductPage.class);

	@FindBy(id = PageConstants.TXT_SRCHBOX)
	private WebElement TXT_searchBox;
	
	@FindBy(xpath = PageConstants.BTN_SRCH)
	private WebElement BTN_search;

	/**
	 * This is the default constructor for the method
	 *  
	 * @param driver the webdriver object
	 * 
	 * 
	 */
	public SearchProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is to verify the expected out of confirmation page
	 *  
	 */
	public void setSearch(String product) {
		try {
			verifyElementPresent(TXT_searchBox);
			TXT_searchBox.sendKeys(product);
			log.info("Setting up search works fine.");

		} catch (Exception e) {
			log.error(e);
			log.error("Error when setting up the search.");
		}
	}
	
	public void clickSearch() {
		try {
			verifyElementPresent(BTN_search);
			BTN_search.click();
			log.info("Clicking the search works fine.");
			Reporter.log("Search button is clicked.",true);

		} catch (Exception e) {
			log.error(e);
			log.error("Error when clicking the search button.");
		}
	}
	
	public void clearSearchBox() {
		try {
			verifyElementPresent(TXT_searchBox);
			TXT_searchBox.clear();
			log.info("Clearing up the textbox works fine.");

		} catch (Exception e) {
			log.error(e);
			log.error("Error when clearing up the search.");
		}
	}
	
	public void setSearchUsingRobot(String product)  {
		try {
			verifyElementPresent(TXT_searchBox);
			mouseOverAndClick(TXT_searchBox);
			//TXT_searchBox.click();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    StringSelection stringSelection = new StringSelection(product);
		    clipboard.setContents(stringSelection, null);
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
			//TXT_searchBox.sendKeys(product);
		    Reporter.log("Setting up the search section works fine",true);
			log.info("Setting up search works fine.");

		} catch (AWTException e) {
			log.error(e);
			log.error("Error when setting up the search.");
		}
	}
	
	public void clickSearchUsingRobot() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			log.info("Pressing Enter works fine.");
			Reporter.log("Enter is pressed using Robot class.",true);

		} catch (AWTException e) {
			log.error(e);
			log.error("Error when pressing enter using Robot class.");
		}
	}

}
