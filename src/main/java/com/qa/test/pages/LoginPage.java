package com.qa.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.test.base.TestBase;
import com.qa.test.util.TestUtil;

public class LoginPage extends TestBase {

	public By username = By.name("userName");
	public By password = By.name("password");

	public By submitButton = By.name("login");
	
//	TestBase tb = new TestBase();
	
	
	public LoginPage() {
		super();
	}
	
	TestUtil tu = new TestUtil(driver);
	

	public String loginPageTitle() {

		return tu.getPageTitle();
	}
	
	public ReservationPage login (String un, String pwd) {
		tu.sendText(username,  un);
		tu.sendText(password, pwd);
		
		tu.clickElement(submitButton);
		
		return new ReservationPage();
	}

}
