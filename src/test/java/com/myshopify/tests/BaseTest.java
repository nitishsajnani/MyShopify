package com.myshopify.tests;

import static com.myshopify.utilities.YamlReader.getYamlValue;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.myshopify.webfactory.ShopTestInitiator;

@Listeners()
public class BaseTest {
	protected boolean isTestRunCreated = false;
	protected ShopTestInitiator Shop;
	protected String product;
	protected int counterForTests;
	protected int failCount;
	protected String baseUrl;

	public BaseTest(String baseUrl) {
		this.baseUrl = baseUrl;
		System.out.println("baseURL::" + baseUrl);
	}

	@BeforeClass
	public void beforeMethod() {
		Shop = new ShopTestInitiator(this.getClass().getSimpleName());
		Shop.launchApplication(getYamlValue(baseUrl));
	}

	@AfterClass(alwaysRun = true)
	public void close_Test_Session() throws IOException {
		// Shop.closeBrowserSession();
	}

}
