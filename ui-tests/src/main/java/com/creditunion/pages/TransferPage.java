package com.creditunion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TransferPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By transferLink = By.linkText("Transfer Funds");
    private final By amount = By.id("amount");
    private final By fromAccount = By.id("fromAccountId");
    private final By toAccount = By.id("toAccountId");
    private final By transferBtn = By.cssSelector("input[value='Transfer']");
    private final By title = By.cssSelector("#rightPanel h1");
    private final By rightPanel = By.id("rightPanel");

    public TransferPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigate(){
        wait.until(ExpectedConditions.elementToBeClickable(transferLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(amount));
    }

    public void makeTransfer(String amt){
        // choose different accounts when possible
        Select from = new Select(wait.until(ExpectedConditions.elementToBeClickable(fromAccount)));
        if (from.getOptions().size() > 0) from.selectByIndex(0);

        Select to = new Select(wait.until(ExpectedConditions.elementToBeClickable(toAccount)));
        if (to.getOptions().size() > 1) {
            to.selectByIndex(1);
        } else if (to.getOptions().size() > 0) {
            to.selectByIndex(0);
        }

        driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(transferBtn).click();
    }

    /** Wait for a confirmation signal and return the entire right panel text. */
    public String waitForConfirmationAndGetText(){
        ExpectedCondition<Boolean> success = d -> {
            String t = d.findElement(title).getText().toLowerCase();
            String p = d.findElement(rightPanel).getText().toLowerCase();
            return t.contains("transfer complete") || p.contains("has been transferred") || p.contains("transfer");
        };
        wait.until(success);
        return driver.findElement(rightPanel).getText();
    }
}
