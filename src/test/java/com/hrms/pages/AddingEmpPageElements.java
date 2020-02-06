package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddingEmpPageElements extends DashboardPageElements {
	
	@FindBy(id="firstName")
	public WebElement name;
	
	@FindBy(id="lastName")
	public WebElement lName;
	
	@FindBy(id="btnSave")
	public WebElement save;
	
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement added;
	
	public AddingEmpPageElements(){
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	public void natigateToAddEmp(String name1, String last1) {
		sendText(name, name1);
		sendText(lName, last1);
		click(save);	
	}
	

}
