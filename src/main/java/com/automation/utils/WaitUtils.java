package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriverWait wait;

    private static final Logger logger =
            LogManager.getLogger(WaitUtils.class);

    public WaitUtils(WebDriver driver) {

        int timeout = Integer.parseInt(
                ConfigReader.getProperty("explicit.wait"));

        logger.debug(
                "Initializing WaitUtils with timeout: {} seconds",
                timeout
        );

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout));
    }

    // =========================
    // Element Waits
    // =========================

    public WebElement waitForPresence(By locator) {

        logger.debug(
                "Waiting for element presence: {}",
                locator
        );

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForVisibility(By locator) {

        logger.debug(
                "Waiting for element visibility: {}",
                locator
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {

        logger.debug(
                "Waiting for element to be clickable: {}",
                locator
        );

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForInvisibility(By locator) {

        logger.debug(
                "Waiting for element invisibility: {}",
                locator
        );

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // =========================
    // Page Waits
    // =========================

    public void waitForTitle(String title) {

        logger.debug(
                "Waiting for page title containing: {}",
                title
        );

        wait.until(
                ExpectedConditions.titleContains(title));
    }

    public void waitForUrl(String url) {

        logger.debug(
                "Waiting for URL containing: {}",
                url
        );

        wait.until(
                ExpectedConditions.urlContains(url));
    }
}