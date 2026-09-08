package com.automation.driver;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
        // Prevent object creation
    }

    public static void initializeDriver() {

        String browser = ConfigReader
                .getProperty("browser")
                .trim()
                .toLowerCase();

        switch (browser) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                                + ". Supported browsers: chrome, edge, firefox"
                );
        }

        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized."
            );
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}