package com.qa.test.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.test.base.TestBase;
import com.qa.test.pages.LoginPage;
import com.qa.test.pages.ReservationPage;
import com.qa.test.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage lp;
	ReservationPage rp;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void validateLoginPageTitle() {
		String title = lp.loginPageTitle();
		System.out.println("Page Title : " + title);
		Assert.assertEquals(title, "Welcome: Mercury Tours", "Test Case Failed Due to Login PageTitle MisMatch");

	}

	@Test(priority = 2)
	public void validateLogin() {
		rp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		String title = rp.reservationPageTitle();
		System.out.println("Page Title : " + title);
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:",
				"Test Case Failed Due to Reservation Page Title MisMatch");
	}

	@AfterMethod
	public void browserClose() {
		driver.close();
	}

}
