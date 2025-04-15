package com.orangehrm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
public static String getProperty(String key) {
	FileInputStream fis=null;
	try {
		fis = new FileInputStream("C:\\Users\\KUNASH\\eclipse-workspace\\OrangeHRM1\\src\\main\\java\\com\\orangehrm\\util");
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop= new Properties();
	try {
		prop.load(fis);
	}
	catch(IOException e) {
		e.printStackTrace();
		}
return prop.getProperty(key);
}


}
