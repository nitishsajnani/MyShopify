package com.myshopify.actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.myshopify.getpageobjects.GetPage;

public class LoginPageAction extends GetPage {

	WebDriver driver;

	public LoginPageAction(WebDriver driver) {
		super(driver, "LoginPage");
		this.driver = driver;
	}
	public void clickOnEnterPasswordlink() {
	 	clickOnButton(element("lnk_password"),"password");
	}

	public void clickOnEnterButton()
	{
		hardWait(3);
		Actions act=new Actions(driver);
		act.moveToElement(element("btn_enter")).click().perform();
	}
	public void loginAppPassword(String password) {
		enterText(element("inp_password"),password);
	}
}