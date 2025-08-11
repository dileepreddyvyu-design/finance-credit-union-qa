package com.creditunion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By accountOverviewHeader = By.cssSelector("#rightPanel h1");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isLoaded(){
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(accountOverviewHeader)).getText();
        return text != null && text.toLowerCase().contains("accounts overview");
    }
}
