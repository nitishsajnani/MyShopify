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
	
	public void validateTheProductPriceWithQuantity()
	{
		
		
		
	}
	
	public void validateTheProductPrice(String productQuantity) {
		 double price =calculateItemPrice();
		    logMessage("Product price for single item:"+price);
         hardWait(2); 
	  	enterText(element("inp_Quantity"),productQuantity);		
        hardWait(2);
        int quantityoFItem=Integer.parseInt(productQuantity);
		 double finalPrice =calculateItemPrice();
         logMessage("Product price for " +productQuantity+ "items: "+finalPrice);
         Assert.assertEquals(price*quantityoFItem, finalPrice);
	      logMessage("Verifed product price updated with respect to product quantity");
	}
	public double calculateItemPrice() {
   String price=element("txt_finalPrice").getText();
   String updatedPrice=price.replace(",", "");
   String[] priceWithoutCurrency=updatedPrice.split(" ");
   String priceOfItem=	priceWithoutCurrency[1];
  double finalPrice=Double.parseDouble(priceOfItem);
	return finalPrice;
	}
}