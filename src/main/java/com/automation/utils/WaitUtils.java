package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        int timeout = Integer.parseInt(
                ConfigReader.getProperty("explicit.wait"));

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout));
    }

    // =========================
    // Element Waits
    // =========================

    public WebElement waitForPresence(By locator) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForInvisibility(By locator) {
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // =========================
    // Page Waits
    // =========================

    public void waitForTitle(String title) {
        wait.until(
                ExpectedConditions.titleContains(title));
    }

    public void waitForUrl(String url) {
        wait.until(
                ExpectedConditions.urlContains(url));
    }
}