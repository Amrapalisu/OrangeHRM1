package com.orangehrm.util;

public class App {
	public static String  getAppUrl(String env) {
		String baseDir = System.getProperty("user.dir");//path of current working directory
		String filePath=baseDir+"\\src\\main\\resources\\propertiesfiles\\App.properties";
		//System.out.println(baseDir);
     return PropertiesUtil.getProperty(filePath,env+".url");
	}
public static void main(String[] args) {
	String env = System.getProperty("env");
System.out.println(getAppUrl(env));	//getAppUrl("qa");
}
}
