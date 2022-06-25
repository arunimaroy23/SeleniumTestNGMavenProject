package com.demoqa.utilities;

import com.relevantcodes.extentreports.LogStatus;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
    public WebDriver driver;
    ConfigFileReader config = new ConfigFileReader();
    public static Logger log = Logger.getLogger(Log4j.class.getName());

    String driverPath;
    public static ExtentTest test;
    static ExtentReports report;


    @BeforeClass
    public void initializeDriver()
    {

        PropertyConfigurator.configure(System.getProperty("user.dir")+"/Configs/log4j.properties");
        String browser = config.getBrowser();
        log.info("Browser selected= " + browser);

        if (!browser.equalsIgnoreCase("safari")) {
            driverPath = config.getDriverPath();
            log.info("Driver path = " + driverPath);
        }

        switch (browser)
        {
            case "firefox":
            {
                log.info("Initializing firefox driver");
                System.setProperty("webdriver.gecko.driver",driverPath);
                driver = new FirefoxDriver();
                break;
            }
            case "safari":
            {
                log.info("Initializing safari driver");
                driver = new SafariDriver();
                break;
            }
            default:
            {
                log.info("Initializing chrome driver");
                System.setProperty("webdriver.chrome.driver",driverPath);
                driver = new ChromeDriver();
            }
        }
        String url = config.getApplicationUrl();
        //test.log(LogStatus.INFO,"URL");
        test.log(LogStatus.INFO,"URL= "+url);
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
        log.info("Closed browser");
    }
    @BeforeSuite
    public void initializeExtentReport()
    {
        //Setup Extent report
        report = new ExtentReports(System.getProperty("user.dir")+"/Reports/ExtentReportResults.html",true);
        log.info(System.getProperty("user.dir")+"/Reports/ExtentReportResults.html");
        test = report.startTest("Login Test");
    }

    @AfterSuite
    public void endReport()
    {
        test.log(LogStatus.INFO,"End Test");
        report.endTest(test);
        report.flush();
    }


}
