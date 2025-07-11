package com.Test_Merchant_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Test_Merchant_TestCases.Base_Class;

public class Forgot_Password_Page extends BasePage {

	// constructor
	public Forgot_Password_Page(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//button[text()=' Send ']")
	WebElement sendButton;


    @FindBy(xpath = "//div[contains(text(),'Username not exists')]")
    WebElement errorMessage;

  // xpath Of InstagramIcon :   //a[@class='sicon']/child::i [@class='fa-brands fa-instagram']
   
    @FindBy(xpath ="//a[@class='sicon']/child::i [@class='fa-brands fa-instagram']")
     WebElement instagramIcon;

	
	
	// All Method in Login Page

    
    public void clickOnSendButton() {
    	sendButton.click();
	}
    
    public boolean isErrorMessageShown() {
        try {
        	Base_Class.wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
        }
    
    public void clickInstagramIcon() {
    	instagramIcon.click();
    	
    }
	
   

}
