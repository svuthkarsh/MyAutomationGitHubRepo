package com.nk.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nk.pages.CreateJobAlert;
import com.nk.pages.CustomerSupportPage;
import com.nk.pages.HomePage;
import com.nk.pages.JobAlertCreatedPage;
import com.nk.pages.LoginNaukriPage;
import com.nk.pages.LoginRecruitNaukriPage;
import com.nk.pages.MyNaukriPage;
import com.nk.pages.RecruitNaukriPage;
import com.nk.pages.ResumeNaukriPage;
import com.nk.pages.TermsAndConditions;
import com.nk.util.BaseTestObject;

import net.sourceforge.htmlunit.corejs.javascript.ObjToIntMap;

public class HomePageTest extends BaseTestObject

{
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	

HomePage objHomePage;
LoginRecruitNaukriPage objLoginRecruitNaukriPage;
RecruitNaukriPage objRecruitNaukriPage;
LoginNaukriPage objLoginNaukriPage;
MyNaukriPage objMyNaukriPage;
TermsAndConditions objTermsAndConditions;
CreateJobAlert objCreateJobAlert;
ResumeNaukriPage objResumeNaukriPage;
CustomerSupportPage objCustomerSupportPage;
JobAlertCreatedPage objJobAlertCreatedPage;

boolean flag;
String actual_Result=null;
String parent_window=null;

@Parameters({"browserType","url"})
@Test(priority=1, enabled=true)
public void clickOnSiteLogoAndCheckThePageTitle() throws Exception
{
	Log.info("----> Clicking on Site Logo and Verifying Home Page Title<------------");
try 
{
	objHomePage= new HomePage(uiDriver);
	objHomePage.maxWindow();
	//objHomePage.closePopUp();
	objHomePage.waitImplicit();
	flag=objHomePage.verifySiteLogo();
	Assert.assertTrue(flag, "Site Logo is not Matching");
	objHomePage.clickOnSiteLogo();
	objHomePage.verifyHomePageTitle();
	
	
} 
catch (Exception e) 
{
	throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
}
}

@Test(priority=2, enabled=true)
public void VerifyHeaderMenuNames() throws Exception
{
	Log.info("Verification of Header Links ");
	{
		
		try 
		{
			objHomePage= new HomePage(uiDriver);
			objHomePage.verifyHomePageTitle();
			objHomePage.getHeaderLinksName();
			
			
			
		} catch (Exception e) 
		{
			throw new Exception("FAILED VERIFY HEADER MENU NAME TEST CASE" + "\n VerifyHeaderMenuNames" + e.getLocalizedMessage());
		}
	}
}

@Test (priority=3, enabled=true)
public void clickOnEmployerZone() throws Exception
{
Log.info("Clicking on the Employer Zone");

try 
{
	objHomePage= new HomePage(uiDriver);
	objHomePage.maxWindow();
	objHomePage.verifyHomePageTitle();
	objLoginRecruitNaukriPage=objHomePage.clickEmployerZone();
	objLoginRecruitNaukriPage.switchToNewWindow();
	objLoginRecruitNaukriPage.waitImplicit();
	objLoginRecruitNaukriPage.verifyLoginRecruiteNaukriSiteLogo();
	flag=objLoginRecruitNaukriPage.verifyRequestInformationText();
	Assert.assertTrue(flag, "Request information Text is Missing");
	actual_Result=objLoginRecruitNaukriPage.getCurrentLocation();
	System.out.println(actual_Result);
	objHomePage=objLoginRecruitNaukriPage.clickOnRecruitNaukriSiteLogo();
	objHomePage.verifyHomePageTitle();
	
	
	
} 
catch (Exception e) 
{
	throw new Exception("FAILED WHILE CLICKING ON EMPLOYER ZONE TESTCASE" + "\n clickOnEmployerZone " +e.getLocalizedMessage());
}
}
@Test (priority=4, enabled=true)
public void clickOnBuyLinks() throws Exception
{
try 
{
	objHomePage= new HomePage(uiDriver);
	objHomePage.waitImplicit();
	objHomePage.maxWindow();
	flag=objHomePage.verifyBuyOnline();
	Assert.assertTrue(flag, "Buy online object is Missing");
	objHomePage.isBuyonlinePresent();
	parent_window=uiDriver.getWindowHandle();
	objRecruitNaukriPage=objHomePage.clickOnBuyOnLineSubMenu();
	objRecruitNaukriPage.switchToNewWindow();
	objRecruitNaukriPage.verifyourorder();
	objLoginNaukriPage=objRecruitNaukriPage.clickONClickhere();
	objHomePage=objLoginNaukriPage.clickOnSiteLogo();
	objHomePage.verifyHomePageTitle();
	//objHomePage.closeBrowser();
	
} catch (Exception e) 
{
	throw new Exception("FAILED WHILE CLICKING ON BUY ONLINE LINKS" + "\n clickOnBuyLinks " +e.getLocalizedMessage());
}	
}

@Test(priority=5,enabled=true)
public void clickOnPostinsta() throws Exception
{
	String parentWindowName = uiDriver.getWindowHandle();
	
	try {
		
		objHomePage= new HomePage(uiDriver);
		objHomePage.waitImplicit();
		objHomePage.maxWindow();
		flag=objHomePage.verifyBuyOnline();
		Assert.assertTrue(flag, "Buy online object is Missing");
		objHomePage.isBuyonlinePresent();
		parent_window=uiDriver.getWindowHandle();
		objRecruitNaukriPage=objHomePage.clickOnPostanInstaJob();
		objRecruitNaukriPage.switchToNewWindow();
		objLoginNaukriPage=objRecruitNaukriPage.clickONClickhere();
		//objLoginNaukriPage.closeBrowser();
		
	} catch (Exception e) 
	{
		throw new Exception("Failed Click on Post insta link Test case" + "\n clickOnPostinsta" +e.getLocalizedMessage());
	} 
	
	finally {
		
		closeAndSwitchToParent(parentWindowName);
	}
}

@Test (priority=6,enabled=true)
public void clickOnPostYourCV() throws Exception
{
	try
	{
		objHomePage=new HomePage(uiDriver);
		objHomePage.waitImplicit();
		objHomePage.maxWindow();
		objHomePage.verifyEnterEmailIDTextBox();
		objHomePage.enterEmailIdText("sulckds.ew@gmail.com");
		objHomePage.verifyCreatePassword();
		objHomePage.enterCreatePassword("jaskjasd");
		objHomePage.verifyPostYourCV();
		objMyNaukriPage =objHomePage.clickOnPostYourCV();
		objJobAlertCreatedPage = new JobAlertCreatedPage(uiDriver); 
		objJobAlertCreatedPage.verifyLogoutLink();
		objJobAlertCreatedPage.clickOnLogoutLink();
		objLoginNaukriPage.clickOnLoginAgain();
		objLoginNaukriPage.waitImplicit(4000);
		objHomePage=objLoginNaukriPage.clickOnSiteLogo();
		//objHomePage.closeBrowser();
		
		
		
	} catch (Exception e) 
	{
		throw new Exception("Failed click on Post your CV Test case" + "\n clickOnPostYourCV" +e.getLocalizedMessage());
	}
}
@Test(priority=7,enabled=true)
public void clickOnTermsConditions() throws Exception
{
	try 
	{
		objHomePage= new HomePage(uiDriver);
		objHomePage.maxWindow();
		objHomePage.waitImplicit();
		objHomePage.verifyTermsAndConditionsLink();
		objTermsAndConditions=objHomePage.clickOnTermsAndConditionsLink();
		objTermsAndConditions.waitImplicit(4000);
		objTermsAndConditions.verifyTermstext();
		objTermsAndConditions.verifyCloseWindowTermsandCondition();
		objTermsAndConditions.clickOnCloseWindowTermsandConditions();
		//objTermsAndConditions.closeBrowser();
		
	} catch (Exception e) 
	{
		throw new Exception("FAILED THE TEST CASE CLCIKING ON TERMS AND CONDITIONS " + "\n clickOnTermsConditions" +e.getLocalizedMessage());
	}
}

@Test (priority=8, enabled=true)
public void clickOnCreateJobAlert() throws Exception
{
	try 
	{
		objHomePage= new HomePage(uiDriver);
		objHomePage.verifyGetMatchedJobsPara();
		objHomePage.verifyCreateJobAlertButton();
		objCreateJobAlert=objHomePage.clickonCreateJobAlertButton();
		objCreateJobAlert.verifyTellUsTextisPresent();
		objCreateJobAlert.verifyCloseImagebutton();
		objCreateJobAlert.clickOnCloseImagebutton();
		//objCreateJobAlert.closeBrowser();
		
		
	} catch (Exception e)
	{
		throw new Exception("FAILED CREATE JOB ALERT TEST CASE " + "\n clickOnCreateJobAlert" +e.getLocalizedMessage() );
	}
}

@Test (priority=9, enabled=true)
public void clickOnNaukriFastForwardLink() throws Exception
{
	try 
	{
		objHomePage= new HomePage(uiDriver);
		objHomePage.verifyNaukriFastForwardImageLink();
		objResumeNaukriPage=objHomePage.clickOnNaukriFastForwardImageLink();
		objResumeNaukriPage.waitImplicit();
		//objResumeNaukriPage.verifyNaukriFastForwardTitle();
		objResumeNaukriPage.verifyINeedImpresive();
		objResumeNaukriPage.verifyCustomerServiceLink();
		objResumeNaukriPage.clickOnCustomerSupportService();
		objResumeNaukriPage.verifyHomeImage();
		objHomePage=objResumeNaukriPage.clickOnHomeImage();
		objHomePage.verifyHomePageTitle();
		
	} catch (Exception e)
	{
		throw new Exception("FAILED CLICK ON FAST AND FORWARD " + "\n clickOnCreateJobAlert" +e.getLocalizedMessage() );
	}
}


public void closeAndSwitchToParent(String parentWindowName ) throws InterruptedException{
	uiDriver.close();
	Thread.sleep(5000);
	uiDriver.switchTo().window(parentWindowName);
}

}
