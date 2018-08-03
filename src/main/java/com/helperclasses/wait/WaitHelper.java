package com.helperclasses.wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclasses.logHelper.LoggerHelper;

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		driver = this.driver;
		log.info("WaitHelper has been initialised");
	}

	/**
	 * This is Implicit wait method
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		log.info("Implicit wait has been set to :" + timeout);

	}

	/**
	 * This is to wait for WebDriver wait
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(timeOutInSeconds, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(NoAlertPresentException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return null;

	}

	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSec
	 */
	public void waitForElementVisibleWithPoolingTime(WebElement element, int timeOutInSeconds,
			int pollingEveryMiliSec) {
		log.info("Waiting for :" + element.toString() + "for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element to be is Visible now");

	}

	/**
	 * WebDriver wait for element to be clickable
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + "for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element to be Clickable now");

	}

	/**
	 * WebDriver wait for element to be visible
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + "for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element to be  is Visible now");

	}

	/**
	 * WebDriver wait for element Not Present
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + "for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element to be  is InVisible now");
		return status;

	}

	/**
	 * To be available Frame and Switch to it
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + "for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame To BeAvailable AndSwitchToIt ");

	}

	/**
	 * To write Custom method to solve Synchronization in Selenium Webdriver
	 * @param driver
	 * @param xpath
	 * @param time
	 * @return
	 */
	public WebElement isElementPresnt(WebDriver driver, String xpath, int time) {

		WebElement element = null;

		for (int i = 0; i < time; i++) {
			try {
				element = driver.findElement(By.xpath(xpath));
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		return element;

	}
}
