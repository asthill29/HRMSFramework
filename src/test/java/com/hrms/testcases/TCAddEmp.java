package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddingEmpPageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class TCAddEmp extends CommonMethods{
	
	
	
	@Test(dataProvider="getData", groups="regression")
		public void addingEmp(String name, String lName) throws InterruptedException {	
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements board=new DashboardPageElements ();
		AddingEmpPageElements emp=new AddingEmpPageElements();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		board.navigateToAddEmployee();
		emp.natigateToAddEmp(name, lName);
		Assert.assertTrue(emp.added.isDisplayed(), "Employee was not added");
		System.out.println("Employee were added");
		
		}
	
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "AddEmployee");
	}
	
	
	
	//LoginPage login = new LoginPage();
			//sendText(login.username, ConfigsReader.getProperty("username"));
			//sendText(login.password, ConfigsReader.getProperty("password"));
	

}
