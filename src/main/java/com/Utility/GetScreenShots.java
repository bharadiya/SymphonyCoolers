package com.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestCases.Constants;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GetScreenShots {
	AShot ashot = new AShot();
	Screenshot sc;
	Date d = new Date();

	public void getScreenShotWebElement(String xpath) {
		sc = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Constants.driver,
				Constants.driver.findElement(By.xpath(xpath)));
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./Screenshots/" + dateinString + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getScreenShotWebElement(WebElement element) {
		sc = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Constants.driver, element);
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./ScreenShotImages/" + dateinString + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getScreenShotWindowSize() {
		sc = ashot.takeScreenshot(Constants.driver);
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./ScreenShotImages/" + dateinString + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getScreenShotEntirePage() {
		sc = ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(Constants.driver);
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./ScreenShotImages\\" + dateinString + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}