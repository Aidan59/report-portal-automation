# Report Portal Automation Tests

## 📌 Описание проекта
Проект предназначен для автоматизации UI и API тестирования демо-версии **Report Portal** с использованием:
- **Selenium WebDriver** — для UI тестов
- **RestAssured** — для API тестов
- **JUnit 5** — для тестового фреймворка
- **Allure Reports** — для генерации отчетов
- **Maven** — для сборки проекта и управления зависимостями

Тесты демонстрируют:
- работу с UI (создание нового Widget),
- работу с API (создание Dashboard и негативные сценарии),
- применение паттернов Page Object Model (POM),
- принципы FIRST и AAA,
- интеграцию с Allure для генерации отчетов.

---

## 🛠 Технологический стек
- Java 23
- Maven 4.0
- Selenium WebDriver 4.14.0
- RestAssured 5.3.0
- JUnit Jupiter 5.9.3
- Allure 2.20.1

---

## 🔑 Инструкция
1. Установить **Java JDK (23 или выше)**.
2. Установить **Maven**.
3. Установить **Allure**.
4. Клонировать проекта: git clone https://github.com/your-username/report-portal-automation.git
   cd report-portal-automation 
5. Получить API ключ и вписать его в config.properties
6. Запустить тесты с помощью команды: mvn clean test 
7. Посмотреть отчет allure c помощью команды: mvn allure:serve
