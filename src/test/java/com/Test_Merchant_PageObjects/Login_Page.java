package com.Test_Merchant_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Test_Merchant_TestCases.Base_Class;

public class Login_Page extends BasePage {

	// constructor
	public Login_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='fullName']")
	WebElement userNameTxt;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTxt;

	@FindBy(xpath = "//button[text()=' Sign In ']")
	WebElement signInButton;

	@FindBy(xpath = "//div[text()='Invalid username or password']")
	WebElement InvalidUserMsg;

	@FindBy(xpath = "//a[text()='Forgot Password ?']")
	WebElement forgotPasswordLink;

	// All Method in Login Page

	public void enterUserName(String userMobileNo) {
		userNameTxt.sendKeys(userMobileNo);
	}

	public void enterPassword(String userName) {
		passwordTxt.sendKeys(userName);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	public void clickOnforgotPasswordLink() {
		forgotPasswordLink.click();
	}

	public long wait_For_Visibility_Of_Login_Elements() {
		
		long pageload_startTime = System.currentTimeMillis();

		try {
			Base_Class.wait.until(ExpectedConditions.visibilityOf(userNameTxt));
			Base_Class.wait.until(ExpectedConditions.visibilityOf(passwordTxt));
			Base_Class.wait.until(ExpectedConditions.visibilityOf(signInButton));
			
		} catch (Exception e) {
			return -1;
		}

		long pageload_endTime = System.currentTimeMillis();
		long loadTime = pageload_endTime - pageload_startTime;

		return loadTime;
	}

	public String invalidUserOrPasswordErrorMsg() {
		Base_Class.wait.until(ExpectedConditions.visibilityOf(InvalidUserMsg));
		return InvalidUserMsg.getText();
	}

	
	public String forgotPasswordLinkMsg() {
		Base_Class.wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
		return forgotPasswordLink.getText();
	}
	// Method for Forgot Password Option is Visible
	public boolean isForgotPasswordlinkVisible() {
		try {
			return forgotPasswordLink.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	

}