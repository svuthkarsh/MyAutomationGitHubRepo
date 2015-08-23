package com.nk.pages;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.nk.util.BasePageObject;

public class RecruitNaukriPage extends BasePageObject
{
	

	
By youeorder=By.xpath("//div[@class='greyBdrCrt']/span");

By clickher=By.xpath("//a/strong");

String actual_Result=null;
String expected_Result=null;
String parent_window=null;
boolean flag=false;

	public RecruitNaukriPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());

	/*************************************************************************************************************************************/
	/**
	 * @author manjunathr
	 * @return
	 * @throws Exception
	 */
	public String  verifyourorder() throws Exception
	{
		Log.info("Verification for Post Your CV Button");
	
		try 
		{
			actual_Result=getText(youeorder);
			expected_Result="Your Order Details";
		Assert.assertEquals(actual_Result, expected_Result, "Terms are not Matching");
		
		} catch (Exception e)
		{
			throw new Exception("FAILED WHILE VERIFING THE Terms Text" + "\n verifyTermstext "+e.getLocalizedMessage());
		}
		
		return actual_Result;
		
	}
	
	/*************************************************************************************************************************************/
	/**
	 * @author manjunathr
	 * @return LoginNaukriPage
	 * @throws Exception
	 */
	public LoginNaukriPage  clickONClickhere() throws Exception
	{
		Log.info("Verification for Post Your CV Button");
		
		try 
		{
			parent_window= uiDriver.getWindowHandle();
			uiDriver.findElement(clickher).click();
			switchToNewWindow();
		} catch (Exception e)
		{
			throw new Exception("FAILED WHILE VERIFING THE Terms Text" + "\n verifyTermstext "+e.getLocalizedMessage());
		}
		
		return new LoginNaukriPage(uiDriver);
		
	}
	/*************************************************************************************************************************************/

}
