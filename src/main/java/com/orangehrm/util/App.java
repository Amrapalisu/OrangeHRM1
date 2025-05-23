package com.orangehrm.util;

public class App {
	private static String baseDir = System.getProperty("user.dir");// path of current working directory
	private static String filePath = baseDir + "\\src\\main\\resources\\propertiesfiles\\App.properties";

	public static String getAppUrl(String env) {
		// System.out.println(baseDir);
		return PropertiesUtil.getProperty(filePath, env + ".url");
	}

//public static void main(String[] args) {
//	String env = System.getProperty("env");
//System.out.println(getAppUrl(env));	//getAppUrl("qa");
//}
	public static String getuserName(String env) {
		return PropertiesUtil.getProperty(filePath, env + ".usrename");
	}

	public static String getPassword(String env) {
		return PropertiesUtil.getProperty(filePath, env + ".password");
	}
}
