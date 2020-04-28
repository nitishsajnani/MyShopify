package com.myshopify.tests;

import static com.myshopify.utilities.YamlReader.getYamlValue;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myshopify.tests.BaseTest;

public class TC001_SearchAndAddProductOnCart extends BaseTest {

	public TC001_SearchAndAddProductOnCart(String baseUrl) {
		super("loginApp.baseUrl");
	}

	String  password;
	String productName="RoundNeck Shirt";
	int ProductNumberFromList=1;
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
	}
