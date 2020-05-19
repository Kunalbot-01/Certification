package TestScripts;


import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.AutoConst;
import generic.BaseTest;
import generic.ReadExcel;
import pages.HomePage;
import pages.PageConstants;
import pages.SignInPage;


public class LoginFunctionalityTest extends BaseTest
{
	HomePage homePage = null;	
	SignInPage signIn = null;
	
	
	@Test(enabled = true)
	public void testCase1() throws InterruptedException {
		
			
		  Reporter.log("*********Test Case 01 *************"); 
		  homePage=new HomePage(driver);
		  String[][] dataLogin = ReadExcel.getData(AutoConst.INPUT_PATH, "Login");
		  homePage.verifyTitlePresent(PageConstants.TTL_HOMEPAGE);
		  homePage.clickAllowButton();
		  homePage.clickSignIn();
		  //System.out.println(driver.getTitle());
		  
		  signIn = new SignInPage(driver);
		  Thread.sleep(5000);
		  for(int i=1;i<dataLogin.length;i++)
		  {
		 
			  Reporter.log("UserName:= "+dataLogin[i][0],true);
			  Reporter.log("Password:= "+dataLogin[i][1],true);
			  signIn.setUserInformation(dataLogin[i][0]);
			  signIn.setPassword(dataLogin[i][1]);
			  signIn.clickLoginButton();
			  boolean check = signIn.verifyLoginErrorMsg();
			  if(check && dataLogin[i][1].length()<6)
				  signIn.verifyErrorPasswordMsg();
			  else if (check==false)
				  signIn.verifyErrorPasswordMsg();
			  Thread.sleep(2000);
			  signIn.clearUserInfoTextBox();
			  signIn.clearPasswordTextBox();
			  
		  }
	}
	
	
}
