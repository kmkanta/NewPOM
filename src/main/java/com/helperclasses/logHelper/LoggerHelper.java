package com.helperclasses.logHelper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.helperclasses.filepath.ResourceHelper;

public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\resource\\log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	}
}
