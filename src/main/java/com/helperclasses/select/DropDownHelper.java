package com.helperclasses.select;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.helperclasses.logHelper.LoggerHelper;

public class DropDownHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDown Helper Class has been instantiated...");
	}

	public Select getSelectClass(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public void selectUsingIndex(WebElement element, int index) {
		log.info("select By  Using Index and index is.." + index);
		getSelectClass(element).selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		log.info("select By Using visible Text and text is.." + visibleText);
		getSelectClass(element).selectByVisibleText(visibleText);
	}

	public void selectByValue(WebElement element, String htmlValue) {
		log.info("select By using HTML value and value is.." + htmlValue);
		getSelectClass(element).selectByValue(htmlValue);
	}

	public void deSelectUsingIndex(WebElement element, int index) {
		log.info("De Select By  Using Index and index is.." + index);
		getSelectClass(element).deselectByIndex(index);
	}

	public void deSelectByVisibleText(WebElement element, String visibleText) {
		log.info(" De Select By Using visible Text and text is.." + visibleText);
		getSelectClass(element).deselectByVisibleText(visibleText);
	}

	public void deSelectByValue(WebElement element, String htmlValue) {
		log.info("De Select By using HTML value and value is.." + htmlValue);
		getSelectClass(element).deselectByValue(htmlValue);
	}

	public List<String> getAllDropDownData(WebElement element) {
		List<WebElement> elementList = getSelectClass(element).getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementList) {
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		Collections.sort(valueList);// To sort the list values
		return valueList;
	}
}
