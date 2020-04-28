package com.myshopify.tests;

import static com.myshopify.utilities.YamlReader.getYamlValue;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_AddQuanityAndVerifyPrice extends BaseTest {

	public TC002_AddQuanityAndVerifyPrice(String baseUrl) {
		super("loginApp.baseUrl");
	}

	String  password;
	String productName="RoundNeck Shirt";
	int ProductNumberFromList=1;
	String productQuantity="3";
	@BeforeClass
	public void init() {
		password = getYamlValue("HomePage.LoginDetails.password");
	}

	@Test
	public void TestStep01_UserSubmitLoginDetails() {
		Shop.loginPage.clickOnEnterPasswordlink();
		Shop.loginPage.loginAppPassword(password);
		Shop.loginPage.clickOnEnterButton();
		Reporter.log("User is successfully login into the application",true);
	}
	
	
	@Test
	public void TestStep02_UserSearchTheProduct() {
		Shop.searchPage.clickOnSearchButton();
		Shop.searchPage.enterProduct(productName);
		Shop.searchPage.clickOnSearchIcon();
		Shop.searchPage.selectProduct(ProductNumberFromList);
		Reporter.log("User is able to search and select the product",true);
	}
	
	@Test
	public void TestStep03_UserAddedTheProduct() {
		Shop.searchPage.clickOnAddedToCart();
		Shop.searchPage.clickOnViewCart();	
		Reporter.log("User is successfully Added product to cart",true);
	}
	@Test
	public void TestStep04_VerifyProductIsAddedIntoCart() {
	Shop.cartPage.verifyProductAddedToCart(productName);	
	Reporter.log("Verified product has been added to cart",true);
	}
	@Test
	public void TestStep05_IncreaseQuantityOfSameProduct() {
	Shop.cartPage.validateTheProductPrice(productQuantity);	
	Reporter.log("Verified product price has been udpdated with quantities of the item",true);
	}

	
	}
