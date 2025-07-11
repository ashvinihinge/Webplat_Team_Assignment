package com.Test_Merchant_TestCases;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import com.Test_Merchant_PageObjects.Forgot_Password_Page;
import com.Test_Merchant_PageObjects.Login_Page;

public class TC004_Instagram_Redirect extends Base_Class {

		
	@Test
	public void testInstagramRedirectIfForgotNotVisible() throws IOException {

		logger.info("****** TC004_Instagram_Redirect_Started ********");
		
		//Login Page
		Login_Page loginpage = new Login_Page(driver);
		
		// Forgot Password Page
				Forgot_Password_Page forgetpasswordPage=new Forgot_Password_Page(driver);
	
		if (loginpage.isForgotPasswordlinkVisible()) {
			logger.info("Forgot password Linked is visible. Skipping Instagram redirect test");
            return;
        }

		
		
						
        String parentWindow = driver.getWindowHandle();
        forgetpasswordPage.clickInstagramIcon();
        logger.info("Click on Instragram Icon");
        
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("instagram")) {
        	logger.info("Successfully redirected to Instagram: " + currentUrl);
        } else {
        	logger.info("Instagram redirection failed."); 
             }


		  logger.info("****** Finished TC004_Instagram_Redirect TestCase********");
	    }
	 

	
}
