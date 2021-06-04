package com.TestCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Utility.PropertyConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass {
	PropertyConfig prop;

	@Parameters("browser")
	@BeforeTest
	public void setUp(@Optional("chrome") String browser) {
		prop = new PropertyConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
		}
		Constants.driver.manage().window().maximize();
		Constants.driver.get(prop.getProperty("url"));
		Constants.waitForPageLoad(10000);
	}

	@AfterTest
	public void tearDown() {
		Constants.driver.quit();
		Reporter.log("All Instances closed successfully");
	}

}
