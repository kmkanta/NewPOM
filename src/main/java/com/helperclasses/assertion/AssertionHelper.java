package com.helperclasses.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.helperclasses.logHelper.LoggerHelper;

public class AssertionHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Verifying test " + s1 + " with " + s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue(String message) {
		log.info("Making Script PASS.." + message);
		Assert.assertTrue(true, message);
	}

	public static void makeTrue() {
		log.info("Making Script PASS..");
		Assert.assertTrue(true);
	}

	public static void makeFalse() {
		log.info("Making Script FAIL..");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("Making Script FAIL.." + message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {
		log.info("Making Script PASS.." + status);
		Assert.assertTrue(status);
	}

	public static void verifyFalse(boolean status) {
		log.info("Making Script PASS.." + status);
		Assert.assertTrue(status);
	}

	public static void verifyNullObject(String text) {
		log.info("Verify Object is NULL...");
		Assert.assertNull(text);
	}

	public static void verifyNotNullObject(String text, String message) {
		log.info("Verify Object is not NULL..." + message);
		Assert.assertNotNull(text, message);
	}

	public static void verifyNullObject(String text, String message) {
		log.info("Verify Object is NULL..." + message);
		Assert.assertNull(text, message);
	}

	public static void verifyNotNullObject(String text) {
		log.info("Verify Object is not NULL...");
		Assert.assertNotNull(text);
	}

}
