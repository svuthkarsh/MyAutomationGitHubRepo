package com.nk.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import com.nk.common.NKConstants;
import com.nk.util.BasePageObject;

public class MyNaukriPage extends BasePageObject {

	/*WebDriver uiDriver;*/
	public MyNaukriPage(WebDriver driver){
		super(driver);
	}
	
	String text=null;
	
	public void verifyingUsernameLoginPage(){
		text=uiDriver.getTitle().toLowerCase();
		Assert.assertEquals(text, NKConstants.PAGETITLE_MYNUAKRIPAGE,"User Login Page tilte is not displayed");
		}
	
}
