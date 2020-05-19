package generic;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage
{
	protected WebDriver driver = null;
	Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void verifyTitlePresent(String expTitle)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		String actTitle=driver.getTitle();
		try
		{
			w.until(ExpectedConditions.titleContains(expTitle));
			String actTitleU = actTitle.toUpperCase();
			String expTitleU = expTitle.toUpperCase();
			System.out.println(actTitleU);
			Assert.assertEquals(actTitleU,expTitleU);
			Reporter.log("Expected title matches with actual title. \nActual Title is "+actTitle+"\nexpected title is "+expTitle, true);	
			log.info("Given string title "+actTitle+ " contains in expected title; which is "+expTitle+".");
		}
		catch(Exception e)
		{
			log.error("Caught an [" + e.getClass().getName() + "]", e);
			log.error(expTitle+" and "+actTitle +" didnot match ");
		}
	}
	
	public void verifyTitleContains(String expTitle)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		String actTitle=driver.getTitle();
		try
		{
			w.until(ExpectedConditions.titleContains(expTitle));
			if(actTitle.contains(expTitle))
				Assert.assertTrue(true);
			Reporter.log("Expected title matches with actual title. \nActual Title is "+actTitle+"\nexpected title is "+expTitle, true);	
			log.info("Given string title "+actTitle+ " contains in expected title; which is "+expTitle+".");
		}
		catch(Exception e)
		{
			log.error("Caught an [" + e.getClass().getName() + "]", e);
			log.error(expTitle+" and "+actTitle +" didnot match ");
		}
	}
	
	public void verifyElementPresent(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		try
		{
			w.until(ExpectedConditions.visibilityOf(ele));
			System.out.println("Element text is "+ele.getText());
			log.info(ele+ " was found");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Unable to find the element "+ele +": "+ e);
			//e.printStackTrace();
		}
	}
	
	public void verifyElementToBeSelected(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		try
		{
			w.until(ExpectedConditions.elementToBeSelected(ele));
			System.out.println("Element text is "+ele.getText());
			log.info(ele+ " was found");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Unable to find the element "+ele +": "+ e);
			//e.printStackTrace();
		}
	}
	
	public void verifyElementsPresent(List<WebElement> lEle)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		try
		{
			w.until(ExpectedConditions.visibilityOfAllElements(lEle));
			for (int i = 0; i<lEle.size(); i++)
			{
				System.out.println("Elements are "+lEle.get(i).getText());
			}
			log.info(lEle+ " was found");
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Unable to find the element "+lEle +": "+ e);
			//e.printStackTrace();
		}
	}
	
	public void mouseOver(WebElement ele) 
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			log.info("Mouse overed on" +ele);
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Mouse over failed "+e);
		}
		
	}
	
	public void mouseOverAndClick(WebElement ele) 
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).click().perform();
			log.info("Mouse overed on" +ele);
			
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Mouse over failed "+e);
		}
		
	}
	
	

	
}
