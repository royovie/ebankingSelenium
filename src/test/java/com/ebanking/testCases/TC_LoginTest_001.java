package com.ebanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObject.LoginPage;
public class TC_LoginTest_001 extends BaseClass{
	@Test
    public void loginTest() throws InterruptedException, IOException
    {
		Logger.info("URL is opened");
        
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        Thread.sleep(2000);
        Logger.info("Entered username");
        
        lp.setPassword(password);
        Thread.sleep(2000);
        lp.clickSubmit();
        Logger.info("Entered password");
        
        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            Logger.info("Login test passed");
        }
        else{
        	captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            Logger.info("Login test failed");
        }
    }
}
