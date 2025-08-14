package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By login = By.cssSelector("#app > div > div > div > div > div > div:nth-child(4) > div.pageBlockContainer__page-block-container--yjilS > form > div.loginForm__login-field--AEtls > div > div > div > input");
    private final By password = By.cssSelector("#app > div > div > div > div > div > div:nth-child(4) > div.pageBlockContainer__page-block-container--yjilS > form > div.loginForm__password-field--k13kz > div > div > div > input");
    private final By loginButton = By.cssSelector("#app > div > div > div > div > div > div:nth-child(4) > div.pageBlockContainer__page-block-container--yjilS > form > div.loginForm__login-button-container--KT9g6 > button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public void login(String user, String pass) {
        driver.findElement(login).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}
