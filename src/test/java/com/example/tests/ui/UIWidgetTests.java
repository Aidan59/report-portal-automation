package com.example.tests.ui;

import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class UIWidgetTests {

    private WebDriver driver;
    private final String baseUrl = "https://demo.reportportal.io/ui/";

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
    @Description("Тест 1: Создание нового Widget типа Task Progress")
    void testAddTaskProgressWidget() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        login.open(baseUrl + "#login");
        login.login("default", "1q2w3e");

        dashboard.openDashboard(baseUrl + "#default_personal/dashboard");

        dashboard.clickAddDashboard("Test Dashboard");

        dashboard.clickAddWidget("Task Progress");

        Assertions.assertTrue(dashboard.isWidgetPresent("Task Progress"), "Widget не найден на Dashboard");
    }

}
