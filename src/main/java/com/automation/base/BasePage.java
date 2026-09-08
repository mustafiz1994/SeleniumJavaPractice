package com.automation.base;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    protected void click(By locator) {

        wait.waitForClickable(locator).click();
    }

    protected void enterText(By locator, String text) {

        WebElement element = wait.waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {

        return wait.waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        return wait.waitForVisibility(locator).isDisplayed();
    }

    protected void selectByVisibleText(
            By locator,
            String text) {

        WebElement element = wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByVisibleText(text);
    }
}