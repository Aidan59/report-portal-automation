package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By addDashboardBtn = By.cssSelector("#app > div > div > div > div > div.layout__content--y1ANI > div.scrollWrapper__scroll-component--L3JSO > div.scrollWrapper__scrolling-content--FGvAS.scrollWrapper__with-footer--lyezV > div > div.layout__page-container--O1S09 > div > div.pageLayout__page-header--nY9Ni > div > div > div.addDashboardButton__add-dashboard-btn--acseh > button");
    private final By addDashboardName = By.cssSelector("#modal-root > div > div.modalLayout__scrolling-content--z2e1T > div > div:nth-child(1) > span > div > div.modalContent__modal-content--xbIue > form > div:nth-child(1) > div.modalField__modal-field-content--A4lX0 > div > input");
    private final By addDashboardBtnModal = By.cssSelector("#modal-root > div > div.modalLayout__scrolling-content--z2e1T > div > div:nth-child(1) > span > div > div.modalFooter__modal-footer--yasOK > div.modalFooter__buttons-block--Bplno > div:nth-child(2) > button");

    private final By addWidgetBtn = By.cssSelector("#app > div > div > div > div > div.layout__content--y1ANI > div.scrollWrapper__scroll-component--L3JSO > div.scrollWrapper__scrolling-content--FGvAS.scrollWrapper__with-footer--lyezV > div > div.layout__page-container--O1S09 > div > div.pageLayout__page-content--DCfUt > div > div.dashboardItemPage__buttons-container--Y1y1d > div:nth-child(1) > button");
    private final By radioBtnTaskProgress = By.cssSelector("#modal-root > div > div.widgetWizardModal__scrolling-content--WypTy > div > div.scrollWrapper__scrolling-content--FGvAS > div > div.widgetWizardContent__widget-wizard-content--InQJb > div.wizardControlsSection__wizard-controls-section--v0bBW > div.wizardControlsSection__controls-wrapper--hC20C > form > div > div:nth-child(2)");
    private final By nextBtn = By.cssSelector("#modal-root > div > div.widgetWizardModal__scrolling-content--WypTy > div > div.scrollWrapper__scrolling-content--FGvAS > div > div.widgetWizardContent__widget-wizard-content--InQJb > div.wizardControlsSection__wizard-controls-section--v0bBW > div.wizardControlsSection__buttons-block--HD8zo > div > button");
    private final By radioBtnFilterFirst = By.cssSelector("#modal-root > div > div.widgetWizardModal__scrolling-content--WypTy > div > div.scrollWrapper__scrolling-content--FGvAS > div > div.widgetWizardContent__widget-wizard-content--InQJb > div.wizardControlsSection__wizard-controls-section--v0bBW > div.wizardControlsSection__controls-wrapper--hC20C > form > div.filtersControl__filters-control--WRwmL > div.filtersList__filter-list--P5EdM > div > div.scrollWrapper__scrolling-content--FGvAS > div:nth-child(1)");
    private final By nextBtn2 = By.cssSelector("#modal-root > div > div.widgetWizardModal__scrolling-content--WypTy > div > div.scrollWrapper__scrolling-content--FGvAS > div > div.widgetWizardContent__widget-wizard-content--InQJb > div.wizardControlsSection__wizard-controls-section--v0bBW > div.wizardControlsSection__buttons-block--HD8zo > div:nth-child(2) > button");
    private final By widgetName = By.cssSelector("#modal-root > div > div.widgetWizardModal__scrolling-content--WypTy > div > div.scrollWrapper__scrolling-content--FGvAS > div > div.widgetWizardContent__widget-wizard-content--InQJb > div.wizardControlsSection__wizard-controls-section--v0bBW > div.wizardControlsSection__controls-wrapper--hC20C > form > div:nth-child(1) > div.modalField__modal-field-content--A4lX0 > div > input");
    private final By addBtn = By.cssSelector("#modal-root > div > div.widgetWizardModal__scrolling-content--WypTy > div > div.scrollWrapper__scrolling-content--FGvAS > div > div.widgetWizardContent__widget-wizard-content--InQJb > div.wizardControlsSection__wizard-controls-section--v0bBW > div.wizardControlsSection__buttons-block--HD8zo > div:nth-child(2) > button");
    private final By widgets = By.cssSelector("#app > div > div > div > div > div.layout__content--y1ANI > div.scrollWrapper__scroll-component--L3JSO > div.scrollWrapper__scrolling-content--FGvAS.scrollWrapper__with-footer--lyezV > div > div.layout__page-container--O1S09 > div > div.pageLayout__page-content--DCfUt > div > div.container > div > div > div > div > div > div.widget__widget-header--YaPlQ.draggable-field.widget__modifiable--jR_PU > div > div.widgetHeader__info-block--Lp75m > div.widgetHeader__widget-name--vhUok > div.widgetHeader__widget-name-block--AOAHS");

    public void openDashboard(String dashboardUrl) {
        driver.get(dashboardUrl);
    }

    public void clickAddDashboard(String dashboardName) {
        wait.until(ExpectedConditions.elementToBeClickable(addDashboardBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addDashboardName)).sendKeys(dashboardName);
        wait.until(ExpectedConditions.elementToBeClickable(addDashboardBtnModal)).click();
    }

    public void clickAddWidget(String widgetTitle) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addWidgetBtn)).click();
            Thread.sleep(3000);

            wait.until(ExpectedConditions.elementToBeClickable(radioBtnTaskProgress)).click();
            wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
            Thread.sleep(3000);

            wait.until(ExpectedConditions.elementToBeClickable(radioBtnFilterFirst)).click();
            wait.until(ExpectedConditions.elementToBeClickable(nextBtn2)).click();
            Thread.sleep(3000);

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(widgetName));
            nameField.clear();
            nameField.sendKeys(widgetTitle);
            Thread.sleep(3000);

            wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isWidgetPresent(String widgetTitle) {
        List<WebElement> list = driver.findElements(widgets);
        return list.stream().anyMatch(e -> e.getText().equals(widgetTitle));
    }
}
