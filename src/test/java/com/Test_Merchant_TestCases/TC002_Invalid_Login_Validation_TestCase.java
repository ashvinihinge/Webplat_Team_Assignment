package com.Test_Merchant_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Test_Merchant_PageObjects.Login_Page;

public class TC002_Invalid_Login_Validation_TestCase extends Base_Class {

	@Test
	public void validate_The_Error_Handling_Of_Incorrect_Credentials() {

		logger.info("******** -------------------------   ******");

		logger.info("******** TC002_Invalid_Login_Validation_TestCase_Started ******");
		
		// Login Page
		Login_Page loginpage = new Login_Page(driver);

		loginpage.enterUserName("9999999999");
		logger.info("Enter User Name ");

		loginpage.enterPassword("Amitabh");

		logger.info("Enter Password ");

		loginpage.clickOnSignInButton();

		logger.info("Click on Sign In Button");

		// Validation:
		String invalidMsg = loginpage.invalidUserOrPasswordErrorMsg();
		System.out.println("The Error Msg is :"+invalidMsg);
		Assert.assertEquals(invalidMsg, "Invalid username or password");
		
		logger.info("Invalid UserName Or Password");

		logger.info("******** Finished TC002_Invalid_Login_Validation_TestCase******");
	}

}
