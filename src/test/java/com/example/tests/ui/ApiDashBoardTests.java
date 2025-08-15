package com.example.tests.ui;

import com.example.Config;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

@Epic("Dashboard API")
@Feature("Dashboard Creation")
public class ApiDashBoardTests {

    private static String API_KEY;
    private static String BASE_URL;
    private static String createdDashboardId;

    @BeforeAll
    public static void setup() {
        API_KEY = Config.getProperty("api.key");
        BASE_URL = Config.getProperty("base.url");
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @Order(1)
    @Story("Создание дашборда")
    @Description("Тест 2: Создание нового Dashboard")
    @Severity(SeverityLevel.CRITICAL)
    public void createDashboardTest() {
        String requestBody = """
                {
                    "name": "Test Dashboard",
                    "description": "Dashboard created via API test"
                }
                """;

        Response response = given()
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/api/v1/default_personal/dashboard")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .extract().response();

        createdDashboardId = response.jsonPath().getString("id");

        given()
                .header("Authorization", "Bearer " + API_KEY)
                .when()
                .get("/api/v1/default_personal/dashboard/" + createdDashboardId)
                .then()
                .statusCode(200)
                .body("id", equalTo(Integer.parseInt(createdDashboardId)));

        Assertions.assertNotNull(createdDashboardId);

        given()
                .header("Authorization", "Bearer " + API_KEY)
                .when()
                .delete("/api/v1/default_personal/dashboard/" + createdDashboardId)
                .then()
                .statusCode(200);
    }

    @Test
    @Order(2)
    @Story("Создание дашборда c недостаточными параметрами")
    @Description("Тест 3: Создание Dashboard с недостаточными параметрами")
    @Severity(SeverityLevel.CRITICAL)
    public void createDashboardNegativeTest() {
        String invalidRequestBody = """
                {
                    "description": "Incorrect request"
                }
                """;

        given()
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .body(invalidRequestBody)
                .when()
                .post("/api/v1/default_personal/dashboard")
                .then()
                .statusCode(400)
                .body("errorCode", equalTo(4001))
                .body("message", notNullValue());

    }

}
