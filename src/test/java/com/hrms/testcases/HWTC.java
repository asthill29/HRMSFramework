package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class HWTC extends CommonMethods{
	
	
Properties prop;
	
	@Test
	public void loginValidation() {
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practice/Example.properties";
	
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//storing login info
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		LoginPageElements login=new LoginPageElements();
		login.login(username, password);
		
		//verifying user login in
		DashboardPageElements dashboard=new DashboardPageElements();
		Assert.assertTrue(dashboard.welcome.isDisplayed(), "Message is not display");
		
	}
	
	
	

}
