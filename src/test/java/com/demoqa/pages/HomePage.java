package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for login button
    By LoginBtn = By.id("login");

    //Method to click login button
    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }
    }
