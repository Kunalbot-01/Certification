package generic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConst
{
	public static WebDriver driver = null;
	public WebDriverWait wait = null;
	
	@Parameters("browserType")
	@BeforeMethod
	public void launchApp(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile testprofile = profile.getProfile("default");
			testprofile.setPreference("dom.webnotifications.enabled", false);
			testprofile.setPreference("dom.push.enabled", true);
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, testprofile);
			FirefoxOptions opt = new FirefoxOptions();
			opt.merge(dc);
			driver =  new FirefoxDriver(opt);
			//driver = new FirefoxDriver();
		}
		else 
		{
			Reporter.log("Invalid browser selection", true);
			System.exit(0);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
		driver.get(APP_URL);
		
	}
	
	
	  @AfterMethod 
	  public void closeApp() 
	  { 
		  driver.quit(); 
	  }
	  
	 

}
