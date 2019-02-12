package com.qa.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 20;

	public WebDriver driver;
	public WebElement element;
	
	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findElement(final By ele) {
		element= driver.findElement(ele);
		return element;

	}

	public void sendText(final By ele, String data) {
		findElement(ele).sendKeys(data);
	}

	public void clickElement(final By ele) {
		findElement(ele).click();
	}

	public void selectfromdropdown(final By ele, String visibletext)
	{
		element=findElement(ele);
		Select select = new Select(element);
		
		
	}
	

}
