package com.myshopify.webfactory;

import static com.myshopify.utilities.YamlReader.setYamlFilePath;

import com.myshopify.actions.CartPageAction;
import com.myshopify.actions.LoginPageAction;
import com.myshopify.actions.SearchPageAction;
import com.myshopify.getpageobjects.GetPage;
import com.myshopify.utilities.CustomFunctions;

public class ShopTestInitiator extends TestSessionInitiator{

	public CustomFunctions customFunctions;
	public LoginPageAction loginPage;
	public SearchPageAction searchPage;
	public CartPageAction cartPage;

	
		private void _initPage() {
			loginPage = new LoginPageAction(driver);	
			searchPage=new SearchPageAction(driver);
			cartPage=new CartPageAction(driver);
		}

	public ShopTestInitiator(String testname) {
		super();
		setProduct();
		setYamlFilePath();
		configureBrowser();
		_initPage();
	}

	public void setProduct(){
		product = "Shop";
		CustomFunctions.setProduct(product);

		GetPage.setProduct(product);
	}
	
	
}

