package com.creditunion.tests;

import com.creditunion.pages.LoanApplicationPage;
import com.creditunion.pages.LoginPage;
import com.creditunion.pages.DashboardPage;
import com.creditunion.utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanTests extends BaseTest {

    @Test
    public void loanApplicationShowsPendingStatus(){
        new LoginPage(driver).login(Config.get("username"), Config.get("password"));
        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isLoaded(), "Dashboard loaded");
        // navigate to loan page would be here
        LoanApplicationPage loan = new LoanApplicationPage(driver);
        loan.apply("5000","24","60000");
        Assert.assertTrue(loan.getStatus().toLowerCase().contains("pending"), "Loan status should be pending");
    }
}
