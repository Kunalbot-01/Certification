package TestScripts;


import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.*;
import pages.*;

public class HotelSearchTest extends BaseTest
{
	HomePage hp= null;
	HotelsSearchPage hsp = null;
	SearchResultsPage srp = null;
	HotelDetailPage hdp = null;
	ReviewBookingPage rbp = null;
	PaymentPage pp = null;
	ConfirmationPage cp = null;
		
	@Test(enabled = true)
	public void testCase1() throws InterruptedException {
		
			
		  Reporter.log("*********Test Case 01 *************"); 
		  hp = new HomePage(driver); Reporter.log("Step 1 - Verify title of the homepage.");
		  hp.verifyTitlePresent(PageConstants.TTL_HOMEPAGE);
		  Reporter.log("Step 2 - Click on the Hotels link from the top.");
		  hp.clickHotels();
		  Reporter.log("Step 3 - Verify the title of the Hotel homepage.");
		  hp.verifyTitlePresent(PageConstants.TTL_HOTELHOMPAGE);
		  
		  String[][] data= ReadExcel.getData(AutoConst.INPUT_PATH, "SearchData");
		  
		  hsp = new HotelsSearchPage(driver); Reporter.
		  log("Step 4 - Set the search criteria to search hotels and click Search Hotels button."); 
		  hsp.setSrchHtlsCriteria(data[1][0], data[1][1], data[1][2], data[1][3], data[1][4], data[1][5], data[1][6]); 
		  String hCount = hsp.getHotelCountFromDropDownString();
		  
		
		  hsp.clickSearchHotels();
		  
		  srp = new SearchResultsPage(driver);
		  Reporter.log("Step 5 - Verify the title of the Results page.");
		  srp.verifyTitlePresent("Results");
		  Reporter.log("Step 6 - Get the first hotel name and count number of hotels."); 
		  String hotelName = srp.getFstHtlName();
		  Reporter.log("Hotel name is "+hotelName, true);
		  Reporter.log("Hotel count is "+ hCount, true);
		 
		  	 
	}
	
	@Test(enabled=true)
	public void testCase2() throws InterruptedException {
		
		Reporter.log("***********************************Test Case 02********************************");
		  String[][] dataS= ReadExcel.getData(AutoConst.INPUT_PATH, "SearchData");
		  hp = new HomePage(driver); 
		  Reporter.log("Step 1 - Verify title of the homepage.");
		  hp.verifyTitlePresent(PageConstants.TTL_HOMEPAGE);
		  Reporter.log("Step 2 - Click on the Hotels link from the top.");
		  hp.clickHotels(); 
		  Reporter.log("Step 3 - Verify the title of the Hotel homepage.");
		  //hp.verifyTitlePresent(PageConstants.TTL_HOTELHOMPAGE);
		  
		  hsp = new HotelsSearchPage(driver);
		  hsp.verifyTitlePresent(PageConstants.TTL_HOTELHOMPAGE);
		  Reporter.log("Step 4 - Set the search criteria to search hotels and click Search Hotels button.");
		  hsp.setSrchHtlsCriteria(dataS[2][0], dataS[2][1], dataS[2][2], dataS[2][3], dataS[2][4], dataS[2][5], dataS[2][6]);
		  hsp.clickSearchHotels();
		  		 
		
		  srp = new SearchResultsPage(driver);
		  Reporter.log("Step 5 - Verify the title of the Results page.");
		  srp.verifyTitlePresent("Results"); 
		  Reporter.log("Step 6 - Get the first hotel name and count number of hotels.");
		  String hotelName = srp.getFstHtlName();
		  Reporter.log("Hotel name is "+hotelName, true); 
		  //srp.getHotelsCount();
		  Reporter.log("Step 7 - Click on the hotel appeared first in the result set.");
		  srp.clickHotel(); 
		  		  
		  hdp = new HotelDetailPage(driver);
		  Reporter.log("Step 8 - Verify the title of the hotel detail page.");
		  hdp.verifyTitleContains(hotelName);
		  Reporter.log("Step 9 - Verify the name of the hotel is same as it was on the previous page.");
		  String hName = hdp.getHotelName();
		  Assert.assertEquals(hName, hotelName);
		  Reporter.log("Hotel name from previous page: "+hotelName+" and from detail page: "+hName+" matches.",true);
		  String rmOption = hdp.getRoomOptionText();
		  Reporter.log("Step 10 - Click on room options and select the first room option.");
		  hdp.clickRoomOptions();
		  hdp.clickSelectRoom();
		  		  
		  rbp = new ReviewBookingPage(driver);
		  Reporter.log("Step 11 - Verify the title of the review booking page.");
		  rbp.verifyTitlePresent(PageConstants.TTL_REVIEWBOOKPAGE);
		  Reporter.log("Step 12 - Verify the name of the hotel is same as it was on the previous page.");
		  String rvwHtlNm = rbp.getReviewHotelName();
		  Assert.assertEquals(rvwHtlNm, hName);
		  Reporter.log("Hotel name from previous page: "+hName+" and from review page: "+rvwHtlNm+" matches.",true);
		  Reporter.log("Step 13 - Verify the room type option and check-in details are same as it was on the previous page.");
		  String rvRmType = rbp.getRoomType();
		  Assert.assertEquals(rvRmType, rmOption);
		  Reporter.log("Room Type from previous page: "+rmOption+" and from review page: "+rvRmType+" matches.",true);
		  rbp.verifyCheckInDetails(dataS[2][2], dataS[2][3], dataS[2][4], dataS[2][5], dataS[2][6]);
		  String[][] dataG= ReadExcel.getData(AutoConst.INPUT_PATH, "GuestDetail");
		  Reporter.log("Step 14 - Enter the guest details and click on payment options button.");
		  rbp.enterGuestDetails(dataG[1][0], dataG[1][1], dataG[1][2], dataG[1][3], dataG[1][4],dataG[1][5]);
		  rbp.clickPaymentOptionsButton();
		  		  
		  pp = new PaymentPage(driver);
		  Reporter.log("Step 15 - Verify the title of Payment Page.");
		  pp.verifyTitlePresent(PageConstants.TTL_PAYMENTPAGE);
		  String[][] dataP= ReadExcel.getData(AutoConst.INPUT_PATH, "PaymentDetail");
		  Reporter.log("Step 16 - Set the card details and click on pay button.");
		  pp.enterCardDetails(dataP[1][0], dataP[1][1], dataP[1][2], dataP[1][3], dataP[1][4]);
		  pp.clickPay();
		  		  
		  cp = new ConfirmationPage(driver);
		  Reporter.log("Step 17 - Verify the title of confirm Pages.");
		  Thread.sleep(2000);
		  cp.verifyTitlePresent("American Express SafeKey");
		  Thread.sleep(5000);
		  cp.verifyTitlePresent("SafeKey");
		  Thread.sleep(5000);
		  cp.verifyTitlePresent(PageConstants.TTL_CONFIRMPAGE);
		  Reporter.log("Step 18 - Verify the error message.");
		  cp.verifyErrorMsg();
	}
	
	@Test(enabled = true)
	public void testCase3() throws InterruptedException {
		
		Reporter.log("***********************************Test Case 03********************************");
		  hp = new HomePage(driver); 
		  Reporter.log("Step 1 - Verify title of the homepage.");
		  hp.verifyTitlePresent(PageConstants.TTL_HOMEPAGE);
		  Reporter.log("Step 2 - Click on the Hotels link from the top.");
		  hp.clickHotels(); 
		  Reporter.log("Step 3 - Verify the title of the Hotel homepage.");
		  hp.verifyTitlePresent(PageConstants.TTL_HOTELHOMPAGE);
		  
		  hsp = new HotelsSearchPage(driver);
		  String[][] data= ReadExcel.getData(AutoConst.INPUT_PATH, "SearchData");
		  Reporter.log("Step 4 - Set the search criteria to search hotels and click Search Hotels button.");
		  hsp.setSrchHtlsCriteria(data[3][0], data[3][1], data[3][2], data[3][3], data[3][4], data[3][5], data[3][6]);
		  hsp.clickSearchHotels();
		  		
		  srp = new SearchResultsPage(driver);
		  Reporter.log("Step 5 - Verify the title of the Results page.");
		  srp.verifyTitlePresent("Results"); 
		  Reporter.log("Step 6 - Get the first hotel name and count number of hotels.");
		  String hotelName = srp.getFstHtlName();
		  Reporter.log("Hotel name is "+hotelName, true); 
		  //srp.getHotelsCount();
		  Reporter.log("Step 7 - Click on the hotel appeared first in the result set.");
		  srp.clickHotel();
		  
		  hdp = new HotelDetailPage(driver);
		  Reporter.log("Step 8 - Verify the title of the hotel detail page.");
		  hdp.verifyTitleContains(hotelName);
		  Reporter.log("Step 9 - Verify the name of the hotel is same as it was on the previous page.");
		  String hName = hdp.getHotelName();
		  Assert.assertEquals(hName, hotelName);
		  Reporter.log("Hotel name from previous page: "+hotelName+" and from detail page: "+hName+" matches.",true);
		  //String rmOption = hdp.getRoomOptionText();
		  Reporter.log("Step 10 - Click on room options button.");
		  hdp.clickRoomOptions();
		  Reporter.log("Step 11 - Take the screenshot.");
		  TakeScreenshot.takeScreenShot("Room Option Page", driver);
		  Reporter.log("Step 12 - Click on location link and verify section appears.");
		  hdp.verifyLocation();
		  Reporter.log("Step 13 - Click on Guest Reviews link and verify section appears.");
		  hdp.verifyGuestReviews();	 
		  Reporter.log("Step 14 - Click on Questions and Answers link and verify section appears.");
		  hdp.verifyQuestionsAndAnswers();
		  Reporter.log("Step 15 - Click on Hotel Policies link and verify section appears.");
		  hdp.verifyHotelPolicies();
	}
	@Test(enabled = true)
	public void testCase4() throws InterruptedException {
		
		Reporter.log("***********************************Test Case 04********************************");
		testCase1();
		Reporter.log("Step 7 - Apply 'Pay At Hotel' filter",true);
		srp.applyPopularFilter();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Reporter.log("Step 8 - Apply 'Price range-2nd option' filter",true);
		srp.applyPriceRangeFilter();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Reporter.log("Step 9 - Apply 'Rating=4' filter",true);
		srp.applyRatingFilter();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Reporter.log("Step 10 - verify rating and price for the hotel on the search result page.",true);
		srp.verifyPriceAfterFilter();
		srp.verifyRatingAfterFilter();
	}
	
}
