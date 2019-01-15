package org.pluralsight.pageobjectprojecttests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public WebDriver driver;
	
	@Parameters({"browserType"})
	@BeforeClass
	public void setUp(String strBrowserType)
	{
		switch (strBrowserType)
		{
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "C:\\H2K\\temp\\logs.txt");
				//Declare an object of type WebDriver that will use the methods of class FirefoxDriver()
				driver = new FirefoxDriver();
				break;
				
			case "InternetExplorer":
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
			default:
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void cleanUp()
	{
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}