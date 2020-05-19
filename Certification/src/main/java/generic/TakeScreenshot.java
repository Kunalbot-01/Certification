package generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class TakeScreenshot {
	
	static String filePath = ".//Screenshots//";
	static Logger log = Logger.getLogger(TakeScreenshot.class);
	
	public static void takeScreenShot(String pageName, WebDriver driver) {
   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name 
           try {
				FileUtils.copyFile(scrFile, new File(".//Screenshots//"+pageName+".png"));
				Reporter.log("***Placed screen shot in "+filePath+" ***",true);
				log.info("Screenshot is captured at "+filePath);
			} catch (IOException e) {
				log.error(e);
				log.error("Error when taking screenshot.");
			}
	}

}
