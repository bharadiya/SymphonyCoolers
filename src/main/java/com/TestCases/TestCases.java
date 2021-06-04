package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjects.CommercialCooler;

@Listeners(listeners.TestNGListeners.class)
public class TestCases extends ParentClass {

	@Test(priority = 1)
	public void TC_01_ProductName_AscendingSort() {
		CommercialCooler page = new CommercialCooler(Constants.driver);
		page.selectSortBy("Product Name");
		page.clickToSortAsc();
		Assert.assertTrue(page.isProductNameSorted(0));
	}

	@Test(priority = 2)
	public void TC_02_ProductName_DescendingSort() {
		Constants.doRefresh();
		CommercialCooler page = new CommercialCooler(Constants.driver);
		page.selectSortBy("Product Name");
		page.clickToSortDesc();
		Assert.assertTrue(page.isProductNameSorted(1));
	}

	@Test(priority = 3)
	public void TC_03_ProductPrice_AscendingSort() {
		Constants.doRefresh();
		CommercialCooler page = new CommercialCooler(Constants.driver);
		page.selectSortBy("Price");
		page.clickToSortAsc();
		Assert.assertTrue(page.isProductPriceSorted(0));
	}

	@Test(priority = 4)
	public void TC_04_ProductPrice_DescendingSort() {
		Constants.doRefresh();
		CommercialCooler page = new CommercialCooler(Constants.driver);
		page.selectSortBy("Price");
		page.clickToSortDesc();
		Assert.assertTrue(page.isProductPriceSorted(1));
	}
}
