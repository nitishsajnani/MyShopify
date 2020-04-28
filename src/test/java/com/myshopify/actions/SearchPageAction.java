package com.myshopify.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.myshopify.getpageobjects.GetPage;

public class SearchPageAction extends GetPage {

	WebDriver driver;

	public SearchPageAction(WebDriver driver) {
		super(driver, "SearchPage");
		this.driver = driver;
	}
	public void clickOnSearchButton() {
	 	clickOnButton(element("btn_search"),"search");
	}

	
	public void enterProduct(String searchItem) {
		enterText(element("inp_search"),searchItem);
	}

	public void clickOnSearchIcon() {
	 	clickOnButton(element("icon_search"),"search icon");
	}

public void selectProduct(int productNumber)
{
	List<WebElement> products=elements("list_product");
    try{
	 if(productNumber<=products.size()){
		 products.get(productNumber).click();
		 logMessage("User select the product number from list: "+productNumber);
	 }
	 else
		 logMessage("There is no product found");
	 }
 catch(Exception e)
 {
	 logMessage("There is no product found");
 } 
}
public void clickOnAddedToCart() {
	clickOnButton(element("btn_addToCart"),"add to cart");	
	hardWait(3);
}
public void clickOnViewCart() {
	clickOnButton(element("lnk_viewCart"),"view cart");	

		
}
public void NavigateToFeatureCollectionSection() {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element("sec_featureCollection"));
try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


public void selectProductFromGridList(int productNumber)
{
	List<WebElement> products=elements("grid_listItem");
    try{
	 if(productNumber<=products.size()){
		 products.get(productNumber).click();
		 logMessage("User select the product number from list: "+productNumber);
	 }
	 else
		 logMessage("There is no product found");
	 }
 catch(Exception e)
 {
	 logMessage("There is no product found");
 } 
}
public void selectSizeOfProduct(String sizeOfProduct) {
  Select size=new Select(element("dd_productSize"));	
  size.selectByValue(sizeOfProduct);
  logMessage("User selected the product size: "+sizeOfProduct);
}
}

 
  
  

