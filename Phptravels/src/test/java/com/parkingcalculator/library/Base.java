package com.parkingcalculator.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class Base {

	public static WebDriver driver;
	public 	static GlobalSeleniumLibrary myLibrary;
	@BeforeClass
	public void beforeAllTestStart() {
		 myLibrary = new GlobalSeleniumLibrary(driver);	
	}
	@AfterClass
	public void afterAllTestCompleted() {
		
	}
	
	@BeforeMethod
	public void beforeEachTestStart() {
		driver = myLibrary.startChromeBrowser();
		
		/*System.setProperty("webdriver.chrome.driver", "src/test/resources/browers_drivers/chromedriver.exe");
		// start a browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();*/
	}

	@AfterMethod
	public void afterEachTestEnd() {
		try {
			Thread.sleep(5 * 1000);
			driver.close();// it close the driver only
			driver.quit();// kills/deletes the driver object
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
