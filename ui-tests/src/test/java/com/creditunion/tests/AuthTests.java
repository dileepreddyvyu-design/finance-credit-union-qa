package com.creditunion.tests;

import com.creditunion.pages.LoginPage;
import com.creditunion.pages.DashboardPage;
import com.creditunion.utils.Config;
import com.creditunion.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {

    @Test
    public void validLoginLoadsDashboard(){
        LoginPage login = new LoginPage(driver);
        login.login(Config.get("username"), Config.get("password"));
        ScreenshotUtil.capture(driver, "validLogin_afterSubmit");
        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isLoaded(), "Dashboard should load for valid login");
        ScreenshotUtil.capture(driver, "validLogin_dashboard");
    }

    @Test
    public void invalidPasswordShowsError(){
        LoginPage login = new LoginPage(driver);
        login.login(Config.get("username"), "WrongPass!");
        String err = login.getError();
        ScreenshotUtil.capture(driver, "invalidLogin_error");
        Assert.assertTrue(err.toLowerCase().contains("could not"), "Should show invalid password message");
    }
}
