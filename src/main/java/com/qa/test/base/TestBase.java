package com.qa.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.qa.test.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static File file;
	public static FileInputStream fis;
	public static WebElement element;
	
	public static XSSFWorkbook ExcelBook;
	public static XSSFSheet Excelsheet;
	public static XSSFCell Excelcell;
	public static XSSFRow Excelrow;

	public TestBase() {

		try {
			prop = new Properties();
			file = new File("D:\\JavaLearning\\NewTours\\src\\main\\java\\com\\qa\\test\\config\\config.properties");
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ActionItem()
	{
		Actions builder=new Actions(driver);
		builder.clickAndHold(element).moveByOffset(200, 300).perform();
		Action action=builder.build();
		action.perform();
		
	}
	
	public static void JavascriptScrollAction()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,150)");
	}
	
	public static String ReadExcel() throws IOException
	{
		try{
			//File excel=new File();
			FileInputStream excel=new FileInputStream("E:/Data Excel");
			ExcelBook= new XSSFWorkbook(excel);
			Excelsheet= ExcelBook.getSheetAt(1);
			Excelcell= Excelsheet.getRow(1).getCell(1);
			String testdata=Excelcell.getStringCellValue();
			return testdata;
			}
		
			catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\\\Selenium Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
//			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\\\Selenium Drivers\\\\geckodriver_win64\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(url);
		

	}

}
