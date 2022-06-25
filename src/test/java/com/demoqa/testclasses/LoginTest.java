package com.demoqa.testclasses;

import com.demoqa.pages.Dashboard;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.utilities.BaseClass;
import com.demoqa.utilities.ConfigFileReader;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseClass {
    public static Logger log = Logger.getLogger(Log4j.class.getName());
    ConfigFileReader config = new ConfigFileReader();
    HomePage home;
    LoginPage login;
    Dashboard dashboard;

    @Test
    public void successfulLogin(){
        home = new HomePage(driver);
        home.clickLogin();
        log.info("Clicked on login button of homepage");

        login = new LoginPage(driver);
        //Enter username & password
        login.enterUsername(config.getUserName());
        login.enterPassword(config.getPassword());
        log.info("Entered login credentials");

        //Click on login button
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assert if Logout button is visible. Logout button becomes visible if login is successful
        try {
            dashboard = new Dashboard(driver);
            //Capture the page heading
            log.info("The page heading is --- " +dashboard.getHeading());
            Assert.assertTrue(dashboard.isLogoutBtnVisible());
            log.info("Successfully logged in");
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
            log.info("Test Failed");
        }
    }

    @Test
    public void loginFailTest(){
        home = new HomePage(driver);
        home.clickLogin();
        log.info("Clicked on login button of homepage");

        login = new LoginPage(driver);
        //Enter username & password
        login.enterUsername("abc");
        login.enterPassword("xyz");
        log.info("Entered login credentials");

        //Click on login button
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assert if Logout button is visible. Logout button becomes visible if login is successful
        try {
            dashboard = new Dashboard(driver);
            //Capture the page heading
            log.info("The page heading is --- " +dashboard.getHeading());
            Assert.assertTrue(dashboard.isLogoutBtnVisible());
            log.info("Successfully logged in");
        }
        catch (Exception e)
        {
            log.info("Test Failed");
            Assert.fail(e.getMessage());
        }
    }


}
