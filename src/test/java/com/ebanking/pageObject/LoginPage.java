package com.ebanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 WebDriver localdriver;

	   public LoginPage(WebDriver remoteDriver){
	        localdriver = remoteDriver;
	        PageFactory.initElements(remoteDriver,this);
	    }

	    @FindBy(name="uid")
	    @CacheLookup
	    WebElement txtUserName;

	    @FindBy(name="password")
	    @CacheLookup
	    WebElement txtPassword;

	    @FindBy(name="btnLogin")
	    @CacheLookup
	    WebElement btnLogin;
	    
	    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
		@CacheLookup
		WebElement linkLogout;

	    public void setUserName(String username){
	        txtUserName.sendKeys(username);
	    }
	    public void setPassword(String userPassword){
	        txtPassword.sendKeys(userPassword);
	    }
	    public void clickSubmit(){
	        btnLogin.click();
	    }
	    public void clickLogout()
		{
			linkLogout.click();
		}
	}
