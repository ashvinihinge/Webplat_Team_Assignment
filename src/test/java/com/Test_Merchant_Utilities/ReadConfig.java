package com.Test_Merchant_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	String path =".//Configuration_Folder//config.properties";
	
	FileInputStream file;

	// Constructor
	public ReadConfig() {
		try {
			prop = new Properties();

			// To read file
			FileInputStream file = new FileInputStream(path);
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method for read base URl:

	public String getBaseURL() {
		String urlValue = prop.getProperty("appURL");

		if (urlValue != null) {
			return urlValue;
		} else {
			throw new RuntimeException("Url Not found");
		}
	}

	// method for read Browser from Config file:
	public String getBrowser() {
		String browserValue = prop.getProperty("browser");

		if (browserValue != null) {
			return browserValue;
		} else {
			throw new RuntimeException("Browser Not FOund ");

		}
	}
}
