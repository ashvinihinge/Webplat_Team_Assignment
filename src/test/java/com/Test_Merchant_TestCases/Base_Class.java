package com.Test_Merchant_TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Test_Merchant_Utilities.ReadConfig;

public class Base_Class {


	public static WebDriver driver;
	public static Logger logger;
	public static WebDriverWait wait;  
	
	ReadConfig readConfig = new ReadConfig();


	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os,String br ) {

		// initialization Logger
	
		logger = LogManager.getLogger("Webplat_Team_Assignment_Ashwini_Hinge");
		
    	String url = readConfig.getBaseURL();
    	String browser = readConfig.getBrowser();

		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "msedge":
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
	
				
		   // Implicit Wait (Applies globally to findElement/findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Explicit Wait (Used where needed)
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        

		
     // Open URl
     		driver.get(url);
     		logger.info(" Application URL Opened");
	
        // Maximize window:
		driver.manage().window().maximize();
	}
	
public String captureScreenShot(String testName) throws IOException {
		
		String timestamp = new SimpleDateFormat("yyyy.mmmm.dd.hh.mm.ss").format(new Date());
		

		TakesScreenshot takescreenshot = ((TakesScreenshot) driver);

		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		 	
	//	File screenShotImage = new File(System.getProperty("user.dir")+ "//ScreenShorts_Folder//" + testName + ".png");

		String targetFilePath = System.getProperty("user.dir")+ "//Screenshots_Folder//" + testName + "_"+ timestamp + ".png";

		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
				return targetFilePath;

	}
	
	  @AfterClass
	  public void tearDown() { 
		 // driver.close(); 
		  logger.info(" Browser is Closed");
		  driver.quit();
		  }
	 

}
