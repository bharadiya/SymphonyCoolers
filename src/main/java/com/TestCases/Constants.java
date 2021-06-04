package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constants {
	public static WebDriver driver;
	// public static Logger logger =
	// LogManager.getLogger(com.TestCases.TestCases.class);

	public static void goSleep(int timeInSec) {
		try {
			Thread.sleep(timeInSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitForElement(int timeInSec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean isElementVisible(WebElement element) {
		boolean result = element.isDisplayed();
		System.out.println(result);
		return result;
	}

	public static void waitForPageLoad(int timeInSec) {
		Constants.driver.manage().timeouts().pageLoadTimeout(timeInSec, TimeUnit.SECONDS);
	}

	public static void doRefresh() {
		Constants.driver.navigate().refresh();
	}
}
