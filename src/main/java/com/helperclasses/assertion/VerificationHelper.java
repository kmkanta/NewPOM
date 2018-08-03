package com.helperclasses.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.helperclasses.logHelper.LoggerHelper;

public class VerificationHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
		log.info("VerifivationHelper Class has been initialised");
	}

	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is Displayed : " + element.getText());
			return true;
		} catch (Exception e) {
			log.error("Element is not Displayed", e.getCause());
			return false;
		}
	}

	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is Displayed : " + element.getText());
			return false;
		} catch (Exception e) {
			log.error("Element is not Displayed");
			return true;
		}
	}

	public String readTextFromElement(WebElement element) {
		if (null == element) {
			log.info("WebElement is Null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if (status) {
			log.info("Element text is.." + element.getText());
			return element.getText();
		} else {
			return null;
		}
	}

	public String getText(WebElement element) {
		if (null == element) {
			log.info("WebElement is Null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if (status) {
			log.info("Element text is.." + element.getText());
			return element.getText();
		} else {
			return null;
		}
	}

	public String getTitle() {
		log.info("Page Title is :" + driver.getTitle());
		return driver.getTitle();
	}

	public String getCurrentURL() {
		log.info("Page Current URL is :" + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public String getpageSource() {
		log.info("Page Page Source is :" + driver.getPageSource());
		return driver.getPageSource();
	}
}
