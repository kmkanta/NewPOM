package com.helperclasses.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.helperclasses.logHelper.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
		log.info("WindowHelper has been initialised");
	}

	/**
	 * Switch to Parent Window
	 */
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
		log.info("Switch to Parent Window ..");
	}

	/**
	 * This method is used for switch to child windows
	 * 
	 * @param index
	 */
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				driver.switchTo().window(window);
				log.info("Switched to : " + index + "window");
			} else {
				i++;
			}
		}
	}

	/**
	 * This method is used for close all tabs and switch to Main window
	 */
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		log.info("Switched to main window");
	}

	/**
	 * This method is used for Navigate back to Browser
	 */
	public void navigateBack() {
		driver.navigate().back();
		log.info("Navigating Back to the window");
	}

	/**
	 * This method is used for Navigate forward to Browser
	 */
	public void navigateForward() {
		driver.navigate().forward();
		log.info("Navigating Forward to the window");
	}

	/**
	 * This method is used for refresh the browser
	 */
	public void refreshBrowser() {
		driver.navigate().refresh();
		log.info("To refresh the browser window");
	}
}
