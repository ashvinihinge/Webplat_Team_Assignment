package com.Test_Merchant_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Test_Merchant_PageObjects.Forgot_Password_Page;
import com.Test_Merchant_PageObjects.Login_Page;

public class TC003_Forgot_Password_Flow extends Base_Class {

	@Test
	public void validate_Forgot_password_feature_behaves_correctly_or_Not() throws IOException {

	

		logger.info("****TC003_Forgot_Password_Flow Started ***** ");
		
		// Login Page
		Login_Page loginpage = new Login_Page(driver);
		
		Forgot_Password_Page forgetpasswordPage=new Forgot_Password_Page(driver);

		loginpage.isForgotPasswordlinkVisible();
		
		
			        if (loginpage.isForgotPasswordlinkVisible()) {
	    
	        	 
		          String msg= loginpage.forgotPasswordLinkMsg();
		            System.out.println(msg);  
		
		            logger.info("Forget Password Link Msg : "+msg);
	            loginpage.clickOnforgotPasswordLink();
	         

	            logger.info("Click On Forget Password Link ");
	         

	            loginpage.enterUserName("999999999");
	    

	            logger.info("Enter UserName :");

	            forgetpasswordPage.clickOnSendButton();
	            
	            logger.info("Click On send Button ");
	

	            if (forgetpasswordPage.isErrorMessageShown()) {

	            	logger.info("Correct error message displayed: Username does not exist");
	            } else {
	        
	            	logger.info("Expected error message not displayed");
	            }

	        }
	        else {
	        	captureScreenShot("testName");

	        	logger.info("Forgot password option is not present at login page");
	        }
	     
	        logger.info("****Finished TC003_Forgot_Password_Flow ***** ");
			
	    }


	}


