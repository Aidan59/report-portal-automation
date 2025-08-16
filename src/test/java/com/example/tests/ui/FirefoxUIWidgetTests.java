package com.example.tests.ui;

import com.example.Config;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class FirefoxUIWidgetTests {

    private WebDriver driver;
    private String baseUrl = Config.getProperty("base.url");

    @BeforeEach
    void setup() {
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("signon.rememberSignons", false);
        options.addPreference("signon.autofillForms", false);
        options.addPreference("signon.storeWhenAutocompleteOff", false);
        options.addPreference("extensions.formautofill.creditCards.enabled", false);
        options.addPreference("extensions.formautofill.addresses.enabled", false);
        options.addPreference("network.http.phishy-userpass-length", 255);
        options.addPreference("signon.showAutoCompleteFooter", false);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @Story("Создание Widget через UI")
    @Description("Тест 1: Создание нового Widget через Firefox")
    @Severity(SeverityLevel.CRITICAL)
    void testAddTaskProgressWidget() {
        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        login.open(baseUrl + "ui/#login");
        login.login("default", "1q2w3e");


        dashboard.openDashboard(baseUrl + "ui/#default_personal/dashboard");

        dashboard.clickAddDashboard("Test Dashboard");

        dashboard.clickAddWidget("Task Progress");

        Assertions.assertTrue(dashboard.isWidgetPresent("Task Progress"));

        dashboard.deleteDashboard();

        Assertions.assertFalse(dashboard.isWidgetPresent("Task Progress"));
    }
}
