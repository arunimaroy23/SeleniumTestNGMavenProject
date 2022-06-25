package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver=driver;
    }

    //Locators for the page title and the logout button
    By heading = By.xpath("//div[@class=\"main-header\"]");
    By logoutBtn = By.xpath("//button[contains(text(),'Log out')]");

    //Method to capture the page heading
    public String getHeading() {
        return driver.findElement(heading).getText();
    }

    //Method to click on Logout button
    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
    public boolean isLogoutBtnVisible() {
        return (driver.findElement(logoutBtn).isDisplayed());
    }
}
