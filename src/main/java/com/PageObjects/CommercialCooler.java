package com.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.TestCases.Constants;

/**
 * @author Hp
 *
 */
public class CommercialCooler {

	public CommercialCooler(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//select[@id='sorter'])[1]")
	WebElement sortBy;

	@FindBy(how = How.XPATH, using = "(//a[@title='Set Ascending Direction'])[1]")
	WebElement setAscendingDirection;

	@FindBy(how = How.XPATH, using = "(//a[@title='Set Descending Direction'])[1]")
	WebElement SetDescendingDirection;

	@FindBy(how = How.XPATH, using = "(//label[normalize-space(text())='Sort By :'])[1]/following-sibling::a")
	WebElement alink;

	@FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Large Space Cooler']/child::span")
	WebElement largeSpaceCoolerCount;

	@FindBy(how = How.XPATH, using = "//a[@class='product-item-link']")
	List<WebElement> productName;

	@FindBy(how = How.XPATH, using = "//span[@data-price-type='finalPrice']//span[@class='price']")
	List<WebElement> productPrice;

	public boolean isProductNameSorted(int sort) {
		Constants.waitForPageLoad(100000);
		int count = 0;
		count = productName.size();
		int countOnPage = getNumberOfCoolerCount();
		SoftAssert a = new SoftAssert();
		a.assertEquals(count == countOnPage, true);
		String[] arr = new String[count];
		for (int i = 0; i < count; i++) {
			arr[i] = productName.get(i).getText().trim();
		}
		if (sort == 0) {
			return isArraySortedAccNameAsc(arr);
		} else {
			return isArraySortedAccNameDesc(arr);
		}
	}

	public boolean isProductPriceSorted(int sort) {
		Constants.waitForPageLoad(100000);
		int count = 0;
		count = productPrice.size();
		int countOnPage = getNumberOfCoolerCount();
		SoftAssert a = new SoftAssert();
		a.assertEquals(count == countOnPage, true);
		String[] arr = new String[count];
		int[] price = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = productPrice.get(i).getText();
			price[i] = convertPricetoInt(arr[i]);
		}
		if (sort == 0) {
			return isArraySortedAccPriceAsc(price);
		} else {
			return isArraySortedAccPriceDesc(price);
		}
	}

	public int convertPricetoInt(String a) {
		a = a.substring(1);
		a = a.replaceAll("\\W", "");
		return Integer.parseInt(a);
	}

	public boolean isArraySortedAccNameAsc(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].compareTo(a[i + 1]) <= 0) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isArraySortedAccNameDesc(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].compareTo(a[i + 1]) >= 0) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public void clickToSortAsc() {
//		String a = alink.getAttribute("title");
		Constants.waitForPageLoad(100000);
		if (alink.getAttribute("title").contains("Desc")) {
		} else {
			alink.click();
		}
	}

	public void clickToSortDesc() {
		Constants.waitForPageLoad(100000);
		if (alink.getAttribute("title").contains("Asc")) {
		} else {
			alink.click();
		}
	}

	public void selectSortBy(String sortParameter) {
		Constants.waitForPageLoad(100000);
		Constants.waitForElement(30, sortBy);
		Select s = new Select(sortBy);
		s.selectByVisibleText(sortParameter);
	}

	public boolean isArraySortedAccPriceAsc(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] <= (a[i + 1])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isArraySortedAccPriceDesc(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] >= (a[i + 1])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public int getNumberOfCoolerCount() {
		System.out.println(Integer.parseInt(largeSpaceCoolerCount.getText().trim().replaceAll("\\D", "")));
		return Integer.parseInt(largeSpaceCoolerCount.getText().trim().replaceAll("\\D", ""));
	}
}
