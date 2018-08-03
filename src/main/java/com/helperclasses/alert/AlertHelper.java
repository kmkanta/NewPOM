package com.helperclasses.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.helperclasses.logHelper.LoggerHelper;

public class AlertHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("AlertHelper Class has been initialised...");
	}

	public Alert getAlert() {
		log.info("Alert Text is..." + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	/**
	 * 
	 */

	public void acceptAlert() {
		log.info("Alert is Accepted...");
		getAlert().accept();
	}

	public void dismissAlert() {
		log.info("Alert is Accepted...");
		getAlert().dismiss();
	}

	public String getAlertText() {
		log.info("The Text of the Alert is..." + getAlert().getText());
		return getAlert().getText();
	}

	public boolean alertIsPresent() {
		try {
			getAlert();

			log.info("Alert is Present...");
			return true;
		} catch (NoAlertPresentException e) {
			log.info("Alert is not Present ..." + e.getCause());
			return false;
		}
	}

	public void acceptAlertPresent() {
		if (alertIsPresent()) {
			acceptAlert();
		} else {
			log.info("Alert is not present...");
		}
	}

	public void dismissAlertPresent() {
		if (alertIsPresent()) {
			dismissAlert();
		} else {
			log.info("Alert is not present...");
		}
	}

	public void enterTextInAlertBox(String text) {
		if (alertIsPresent()) {
			getAlert().sendKeys(text);
			log.info("Text is Entered into the Alert box..." + text);
			acceptAlert();

		} else {
			log.info("Alert is not present...");
		}
	}
}
