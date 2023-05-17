package com.ebanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObject.AddCustomerPage;
import com.ebanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User name is provided");
		lp.setPassword(password);
		Logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		Thread.sleep(3000);
		addcust.clickAddNewCustomer();
		Thread.sleep(2000);
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
        Thread.sleep(7000);
        
        driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
        Thread.sleep(2000);
		Logger.info("providing customer details....");
		Thread.sleep(2000);
		
		addcust.custName("Ovie");
		addcust.custgender("male");
		addcust.custdob("02","13","2000");
		Thread.sleep(5000);
		addcust.custaddress("Poland");
		addcust.custcity("Warsaw");
		addcust.custstate("Warsaw");
		addcust.custpinno("000321");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		Logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case passed....");
			
		}
		else
		{
			Logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

	public String randomestring() {
		String genratedstring=RandomStringUtils.randomAlphabetic(21);
		return null;
	}
	
	
}