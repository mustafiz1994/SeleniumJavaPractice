package com.automation.driver;

import com.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private DriverFactory() {
        // Prevent object creation
    }

    public static void initializeDriver() {

        String browser = ConfigReader
                .getProperty("browser")
                .trim()
                .toLowerCase();

        boolean headless = Boolean.parseBoolean(
                ConfigReader.getProperty("headless"));

        logger.info("Initializing browser: {}", browser);
        logger.info("Headless mode: {}", headless);

        switch (browser) {

            case "chrome":

                ChromeOptions chromeOptions =
                        new ChromeOptions();

                if (headless) {

                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");

                    logger.info(
                            "Chrome configured for headless execution"
                    );
                }

                driver = new ChromeDriver(chromeOptions);

                logger.info("ChromeDriver initialized successfully");

                break;

            case "edge":

                driver = new EdgeDriver();

                logger.info("EdgeDriver initialized successfully");

                break;

            case "firefox":

                driver = new FirefoxDriver();

                logger.info("FirefoxDriver initialized successfully");

                break;

            default:

                logger.error(
                        "Unsupported browser configured: {}",
                        browser
                );

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                                + ". Supported browsers: chrome, edge, firefox"
                );
        }

        driver.manage().window().maximize();

        logger.info(
                "Browser window maximized successfully"
        );
    }

    public static WebDriver getDriver() {

        if (driver == null) {

            logger.error(
                    "WebDriver is not initialized"
            );

            throw new IllegalStateException(
                    "WebDriver is not initialized."
            );
        }

        logger.debug(
                "Returning WebDriver instance"
        );

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            logger.info("Closing browser");

            driver.quit();

            driver = null;

            logger.info(
                    "Browser closed and WebDriver reference cleared"
            );

        } else {

            logger.warn(
                    "Quit requested but WebDriver is already null"
            );
        }
    }
}