package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ConfigsReader {
	
	static Properties prop;
	
	public static Properties readProperties(String filePath) {

		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				
		}
		return prop;
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	
	
	
	

}
