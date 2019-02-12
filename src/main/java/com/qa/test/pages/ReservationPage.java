package com.qa.test.pages;

import org.openqa.selenium.By;

import com.qa.test.base.TestBase;
import com.qa.test.util.TestUtil;

public class ReservationPage extends TestBase 
{
	public By oneway= By.xpath("//*[@value='oneway']");
	public By passengercount= By.name("passCount");
	public By depfrom= By.name("fromPort");
	public By depto= By.name("toPort");
	public By month= By.name("fromMonth");
	public By date= By.name("fromDay");
	public By servclass= By.xpath("//*[@value='Coach']");
	public By airline= By.xpath("//select[@name='airline']");
	public By submit= By.name("findFlights");
	
	public ReservationPage() {
		super();
	}
	
	TestUtil tu = new TestUtil(driver);
	
	
	public String reservationPageTitle() {

		return tu.getPageTitle();
	}
	
	
	
	
	
	
	
}
