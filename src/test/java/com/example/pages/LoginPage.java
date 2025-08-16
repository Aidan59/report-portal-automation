package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By login = By.cssSelector("#app > div > div > div > div > div > div:nth-child(4) > div.pageBlockContainer__page-block-container--yjilS > form > div.loginForm__login-field--AEtls > div > div > div > input");
    private final By password = By.cssSelector("#app > div > div > div > div > div > div:nth-child(4) > div.pageBlockContainer__page-block-container--yjilS > form > div.loginForm__password-field--k13kz > div > div > div > input");
    private final By loginButton = By.cssSelector("#app > div > div > div > div > div > div:nth-child(4) > div.pageBlockContainer__page-block-container--yjilS > form > div.loginForm__login-button-container--KT9g6 > button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(login)).sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
