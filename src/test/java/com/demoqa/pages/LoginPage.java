package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    By uName = By.id("userName");

    //Locator for password field
    By pswd = By.id("password");

    //Locator for login button
    By loginBtn = By.id("login");

    //Method to enter username
    public void enterUsername(String user) {
        driver.findElement(uName).clear();
        driver.findElement(uName).sendKeys(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        driver.findElement(pswd).clear();
        driver.findElement(pswd).sendKeys(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}
