package com.myshopify.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.myshopify.getpageobjects.GetPage;

public class CartPageAction extends GetPage {

	WebDriver driver;

	public CartPageAction(WebDriver driver) {
		super(driver, "CartPage");
		this.driver = driver;
	}
	public void clickOnEnterPasswordlink() {
	 	clickOnButton(element("lnk_password"),"password");
	}
	public void verifyProductAddedToCart(String productName) {
      List<WebElement> products=elements("list_product");
		Assert.assertEquals(products.get(0).getText().contains(productName),true);
		logMessage("Product has been added successfuly ie.: "+productName);
	}
}