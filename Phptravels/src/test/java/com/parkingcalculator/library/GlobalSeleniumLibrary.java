package com.parkingcalculator.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

/***
 * This is a common global selenium libraries and can be used any selenium
 * projects
 * 
 * @author Lakshmi @ Created 12/22/18
 */

public class GlobalSeleniumLibrary {
	private WebDriver driver;

	/***
	 * This is a Constructor
	 * 
	 * @param _driver
	 */
	public GlobalSeleniumLibrary(WebDriver _driver) {
		driver = _driver;
	}

	/***
	 * This is the method enters text string to a edit webElement in web-site
	 * 
	 * @param by
	 * @param value
	 */
	public void enterTextField(By by, String value) {
		try {
			WebElement textWebElement = driver.findElement(by);
			textWebElement.clear();
			textWebElement.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/***
	 * This method starts chrome browser and maximize it
	 * 
	 * @return WebDriver
	 */
	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/browers_drivers/chromedriver.exe");
			// start a browser
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return driver;

	}

	/***
	 * This is a fluent wait, waits dynamically for a webElement and polls the
	 * source html
	 * 
	 * @param by
	 * @return webElement
	 */
	//
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			@SuppressWarnings("deprecation")
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}

		return targetElem;

	}

	/***
	 * This method is use to select the drop down webElement by selecting the
	 * visible text in web-site
	 * 
	 * @param by
	 * @param visibleTextValue
	 */
	public void selectDropDown(By by, String visibleTextValue) {
		try {
			WebElement dropDownElement = driver.findElement(by);
			Select dropDown = new Select(dropDownElement);
			dropDown.selectByVisibleText(visibleTextValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This method is use to select the drop down webElement by selecting the index
	 * in web-site
	 * 
	 * @param by
	 * @param index
	 */

	public void selectDropDown(By by, int index) {
		try {
			WebElement dropDownElement = driver.findElement(by);
			Select dropDown = new Select(dropDownElement);
			dropDown.selectByIndex(index);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This method is use to select the drop down by selecting the webElement by
	 * value in web-site
	 * 
	 * @param attributeValue
	 * @param by
	 */
	public void selectDropDown(String attributeValue, By by) {
		try {

			WebElement dropDownElement = driver.findElement(by);
			Select dropDown = new Select(dropDownElement);
			dropDown.selectByValue(attributeValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This method is use for click the webElement button
	 * 
	 * @param by
	 */
	public void clickButton(By by) {
		try {
			WebElement button = driver.findElement(by);
			button.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * This method is clicks or un-clicks for radio button 
	 * 
	 */
	public void handleCheckBoxRadioBTN(By by, boolean isUserWantsToCheckBox) {

		WebElement elem = driver.findElement(by);
		boolean checkboxState = elem.isSelected();

		if (checkboxState == true) { // by default is checked
			if (isUserWantsToCheckBox == true) {//Scenario1 do nothing

			} else { // scenario2:
				elem.click();
			}

		} else {// by default is not checked

			if (isUserWantsToCheckBox == true) { // Secnario3
				elem.click();

			} else { // Scenario4:

				
			}

		}

	}

}
