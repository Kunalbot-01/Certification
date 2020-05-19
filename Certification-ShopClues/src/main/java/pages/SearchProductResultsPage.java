package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class SearchProductResultsPage extends BasePage 
{
	Logger log = Logger.getLogger(SearchProductResultsPage.class);
	
	@FindBy(xpath=PageConstants.LBL_PRODUCTS)
	private WebElement LBL_prodName;
	
	@FindBy(xpath=PageConstants.LBL_PRODUCTCOUNT)
	private WebElement LBL_productCount;
	
	@FindBy(xpath=PageConstants.LBL_PRODUCTPRICE)
	private WebElement LBL_prodPrice;
	
	public SearchProductResultsPage (WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void getProductsCount()
	{
		try
		{
			verifyElementPresent(LBL_productCount);
			String[] arrProdCount = LBL_productCount.getText().split(" ");
			if(Integer.parseInt(arrProdCount[1])>0)
			{
				Assert.assertTrue(Integer.parseInt(arrProdCount[1])>0);
				Reporter.log("Pass:: Number of products in the results are greater than 0 and it is- "+arrProdCount[1], true);
				log.info("Number of products are "+arrProdCount[1]);
			}
			else
			{
				Reporter.log("Fail:: Error with number of products in the results and it is- "+arrProdCount[1], true);
				log.info("Number of products are "+arrProdCount[1]);
				
			}
			
					
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("Error getting products count.");
		}
		
	}
	
	public void getFirstProductName()
	{
		try
		{
			verifyElementPresent(LBL_prodName);
			String prodName = LBL_prodName.getText();
			Reporter.log("First product name from search is "+prodName,true);
			log.info("First product name is "+prodName);
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("There is error getting first name of the product");
		}
	}
	
	
	public void getPriceOfFirstProduct()
	{
		try
		{
			verifyElementPresent(LBL_prodPrice);
			String prodPrice = LBL_prodPrice.getText();
			Reporter.log("Price of first product name from search is "+prodPrice,true);
			log.info("Price of first product name from search is "+prodPrice);
		}
		catch(Exception e)
		{
			log.error(e);
			log.error("There is error getting price of the product");
		}
	}
	
}
