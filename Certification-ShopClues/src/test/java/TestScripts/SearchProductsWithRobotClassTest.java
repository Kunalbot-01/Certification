package TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.PageConstants;
import pages.SearchProductPage;
import pages.SearchProductResultsPage;

public class SearchProductsWithRobotClassTest extends BaseTest
{
	HomePage homePage = null;
	SearchProductPage searchProduct = null;
	SearchProductResultsPage results = null;
	
	@Test
	public void searchUsingRobotClass() throws InterruptedException 
	{
		Reporter.log("*****************Search using Robot Class*********************");
		homePage=new HomePage(driver);
		homePage.verifyTitlePresent(PageConstants.TTL_HOMEPAGE);
		homePage.clickAllowButton();
		searchProduct = new SearchProductPage(driver);
		searchProduct.setSearchUsingRobot("Headphones");
		searchProduct.clickSearchUsingRobot();
		results = new SearchProductResultsPage(driver);
		results.getProductsCount();
		Reporter.log("*************************************************************");
	}

}
