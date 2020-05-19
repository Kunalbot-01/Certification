package TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.AutoConst;
import generic.BaseTest;
import generic.ReadExcel;
import pages.*;

public class SearchProductsTest extends BaseTest
{
	HomePage homePage = null;
	SearchProductPage searchProduct = null;
	SearchProductResultsPage results = null;
	
	@Test(enabled = true)
	public void searchProducts() throws InterruptedException {
		
			
		  Reporter.log("*********Test Case search products using excel sheet *************"); 
		  homePage=new HomePage(driver);
		  String[][] dataSearch = ReadExcel.getData(AutoConst.INPUT_PATH, "SearchProducts");
		  homePage.verifyTitlePresent(PageConstants.TTL_HOMEPAGE);
		  homePage.clickAllowButton();
		  searchProduct = new SearchProductPage(driver);
		  results = new SearchProductResultsPage(driver);
		  Reporter.log("*************************************************************************************");
		  for (int i=1;i<dataSearch.length;i++)
		  {
			  Reporter.log("Search Product name is: "+dataSearch[i][0],true);
			  searchProduct.setSearch(dataSearch[i][0]);
			  searchProduct.clickSearch();
			  searchProduct.clearSearchBox();
			  results.verifyTitlePresent(PageConstants.TTL_RESULTPAGE);
			  results.getProductsCount();
			  results.getFirstProductName();
			  results.getPriceOfFirstProduct();
			  Reporter.log("*************************************************************************************");
			  
		  }
		  
	}
	
}
