package com.Test_Merchant_TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Test_Merchant_PageObjects.Login_Page;

public class TC001_Page_Load_Performance_Login_Elements extends Base_Class {

	@Test
	public void Log_time_taken_To_loaded_login_page_elements() throws IOException {

		logger.info("****** TC001_Page_Load_Performance_Login_Elements_Started ********");
		// Login Page
		Login_Page loginpage = new Login_Page(driver);

		long loadTime = loginpage.wait_For_Visibility_Of_Login_Elements();

		logger.info("Time taken to load login elements: " + loadTime + " ms ");

		System.out.println("Time taken to load login elements: " + loadTime + " ms");

		if (loadTime == -1 || loadTime > 30000) {

			Assert.fail("Login elements can't load within 30s.");
		} else {
			logger.info("Login elements loaded in " + loadTime + " ms");
		}
		logger.info("****** Finished TC001_Page_Load_Performance_Login_Elements TestCase********");
	}

}
