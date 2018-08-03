package com.helperclasses.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.helperclasses.logHelper.LoggerHelper;

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);

	public FrameHelper(WebDriver driver) {
		this.driver = driver;
		log.info("FrameHelper has been initialised");
	}

	/**
	 * This method is switch to frame based on Frame name
	 * 
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Switch to :" + frameName + " Frame");
	}

	/**
	 * This method is switch to frame based on index
	 * 
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		log.info("Switch to :" + index + " Frame");
	}

	/**
	 * This method is switch to frame based on WebElement
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switch to Frame" + element.toString());
	}

	/**
	 * This method is switch to Parent or default frame
	 */
	public void switchToParentFrame() {
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
	}

}
