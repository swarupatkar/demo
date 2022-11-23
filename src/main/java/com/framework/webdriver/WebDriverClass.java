package com.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.reports.ReportsClass;
import com.framework.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass extends ReportsClass{
	
	// All the methods related to browser setup and tear-down

	WebDriver driver;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	@BeforeMethod(alwaysRun=true)
	@Parameters(value="browser")
	public void setupBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		setDriver(driver);
	}

	@AfterMethod(alwaysRun=true)
	public void teardownBrowser() {
		driver.quit();
	}
	
	public static synchronized void setDriver(WebDriver driver) {
		thread.set(driver);
	}
	
	public static synchronized WebDriver getDriver() {
		return thread.get();
	}
	
	@DataProvider(name="testdata")
	public String [][] getData(){
		String [][] data = ReadExcel.readData("TestData.xlsx", "Sheet1");
		return data;
	}

}
