package com.creditunion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoanApplicationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By amount = By.id("loanAmount");
    private By term = By.id("loanTerm");
    private By income = By.id("annualIncome");
    private By submit = By.cssSelector("button[type='submit']");
    private By status = By.id("applicationStatus");

    public LoanApplicationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void apply(String amt, String trm, String inc){
        wait.until(ExpectedConditions.visibilityOfElementLocated(amount)).sendKeys(amt);
        driver.findElement(term).sendKeys(trm);
        driver.findElement(income).sendKeys(inc);
        driver.findElement(submit).click();
    }

    public String getStatus(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(status)).getText();
    }
}
