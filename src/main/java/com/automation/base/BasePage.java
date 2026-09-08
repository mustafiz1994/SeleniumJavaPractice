package com.automation.base;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // =========================
    // Browser Actions
    // =========================

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void navigateForward() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }


    // =========================
    // Element Actions
    // =========================

    protected void click(By locator) {

        wait.waitForClickable(locator).click();
    }

    protected void enterText(By locator, String text) {

        WebElement element = wait.waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected void clearText(By locator) {

        wait.waitForVisibility(locator).clear();
    }

    protected String getText(By locator) {

        return wait.waitForVisibility(locator).getText();
    }

    protected String getAttribute(By locator, String attribute) {

        return wait.waitForVisibility(locator)
                .getAttribute(attribute);
    }


    // =========================
    // Element State
    // =========================

    protected boolean isDisplayed(By locator) {

        return wait.waitForVisibility(locator).isDisplayed();
    }

    protected boolean isEnabled(By locator) {

        return wait.waitForVisibility(locator).isEnabled();
    }

    protected boolean isSelected(By locator) {

        return wait.waitForVisibility(locator).isSelected();
    }


    // =========================
    // Dropdown Actions
    // =========================

    protected void selectByVisibleText(
            By locator,
            String text) {

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByVisibleText(text);
    }

    protected void selectByValue(
            By locator,
            String value) {

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByValue(value);
    }

    protected void selectByIndex(
            By locator,
            int index) {

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByIndex(index);
    }

    protected String getSelectedOption(By locator) {

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        return select
                .getFirstSelectedOption()
                .getText();
    }

    protected List<WebElement> getAllOptions(By locator) {

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        return select.getOptions();
    }


    // =========================
    // Checkbox / Radio Actions
    // =========================

    protected void selectCheckbox(By locator) {

        WebElement element =
                wait.waitForVisibility(locator);

        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void unselectCheckbox(By locator) {

        WebElement element =
                wait.waitForVisibility(locator);

        if (element.isSelected()) {
            element.click();
        }
    }


    // =========================
    // Element Count
    // =========================

    protected int getElementCount(By locator) {

        return driver.findElements(locator).size();
    }
}