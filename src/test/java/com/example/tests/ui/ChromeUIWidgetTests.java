package com.example.tests.ui;

import com.example.Config;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

@Epic("Dashboard UI")
@Feature("Widget Creation")
public class ChromeUIWidgetTests {

    private WebDriver driver;
    private String baseUrl = Config.getProperty("base.url");

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @Story("Создание Widget через UI")
    @Description("Тест 1: Создание нового Widget через Chrome")
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
