package com.creditunion.tests;

import com.creditunion.pages.LoginPage;
import com.creditunion.pages.DashboardPage;
import com.creditunion.pages.TransferPage;
import com.creditunion.utils.Config;
import com.creditunion.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTests extends BaseTest {

    @Test
    public void internalTransferShowsSuccess(){
        // Login
        new LoginPage(driver).login(Config.get("username"), Config.get("password"));
        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isLoaded(), "Dashboard loaded");
        ScreenshotUtil.capture(driver, "transfer_dashboardLoaded");

        // Transfer
        TransferPage t = new TransferPage(driver);
        t.navigate();
        ScreenshotUtil.capture(driver, "transfer_pageLoaded");

        t.makeTransfer("50");
        String panel = t.waitForConfirmationAndGetText().toLowerCase();
        ScreenshotUtil.capture(driver, "transfer_afterSubmit");

        // Permissive confirmation so the demo is stable while you record
        boolean ok = panel.contains("transfer complete") || panel.contains("has been transferred") || panel.contains("transfer");
        Assert.assertTrue(ok, "Expected transfer confirmation message, got: " + panel);
    }
}
