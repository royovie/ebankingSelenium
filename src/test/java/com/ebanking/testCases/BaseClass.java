package com.ebanking.testCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.ebanking.utilities.ReadConfig;
public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getURl();
    public String username =readconfig.getUsername();
    public String password =readconfig.getPassword();
    public static WebDriver driver;

    public static Logger Logger;
    @BeforeClass
    public void start() throws InterruptedException{
        System.setProperty("webdriver.chorme.driver",readconfig.getChromepath());
        driver = new ChromeDriver();
        
        Logger =org.apache.log4j.Logger.getLogger("e-banking");
        PropertyConfigurator.configure("Log4j.properties");
        
        driver.get(baseURL);
        Thread.sleep(2000);
        
        driver.switchTo().frame("gdpr-consent-notice");
        Thread.sleep(2000);
        
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void End(){
        driver.quit();
    }
    
    public void captureScreen(WebDriver driver, String tname) throws IOException {
    	TakesScreenshot ts =(TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname + ".png");
    	FileUtils.copyFile(source,target);
    	System.out.println("Screenshot taken");
    }
}
