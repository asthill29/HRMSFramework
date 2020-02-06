package com.hrms.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddingEmpPageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddingEmpTest extends CommonMethods{
	
	@Test(dataProvider="empData")
	public void addEmployee(String name,String lName) {
		LoginPageElements login = new LoginPageElements();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		DashboardPageElements dashboard = new DashboardPageElements();
		AddingEmpPageElements addEmp=new AddingEmpPageElements();
		dashboard.navigateToLeaveList();
		sendText(addEmp.name, name);
		sendText(addEmp.lName, lName);
		click(addEmp.save);
	}
	@DataProvider
	public Object[][] empData() {
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "Adding Employee");
	}

}
