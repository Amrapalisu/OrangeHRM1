package com.orangehrm.util;

public class Locators {
	public static String getLocator(String key) {
return PropertiesUtil.getProperty(key, key);

	}

}
