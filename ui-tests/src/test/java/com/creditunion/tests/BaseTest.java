package com.creditunion.tests;

import com.creditunion.utils.Config;
import com.creditunion.utils.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if(Boolean.parseBoolean(System.getProperty("headless", Config.get("headless")))){
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1366,800");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Config.get("implicitWaitSec"))));
        driver.get(Config.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result){
        try{
            if(result.getStatus() == ITestResult.FAILURE){
                ScreenshotUtil.capture(driver, result.getName());
            }
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }
}
