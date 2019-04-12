package com.parkingcalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.parkingcalculator.library.Base;

public class HomePage extends Base {

	public HomePage goto_Phptravel_Website() {

		driver.get("https://www.phptravels.net/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		return this;

	}

	/*public HomePage goto_PhpFrontPage() {

		myLibrary.handleCheckBoxRadioBTN(
				By.xpath("/html/body/section[2]/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div/a"), true);

		return this;
	}*/

	public void selectHotel() {
		try {
			WebElement hotel = driver.findElement(By.xpath("//div[@id='select2-drop']//input[@type='text']"));
			hotel.sendKeys("New Delhi");
			Thread.sleep(5 * 1000);
			hotel.sendKeys(Keys.ARROW_DOWN);
			hotel.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
