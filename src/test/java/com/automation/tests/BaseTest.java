package com.automation.tests;

import com.automation.driver.DriverFactory;
import com.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    protected final Logger logger =
            LogManager.getLogger(getClass());

    @BeforeMethod
    public void setUp() {

        logger.info("========== Test Setup Started ==========");

        DriverFactory.initializeDriver();

        driver = DriverFactory.getDriver();

        String baseUrl =
                ConfigReader.getProperty("base.url");

        logger.info("Navigating to URL: {}", baseUrl);

        driver.get(baseUrl);

        logger.info("Test setup completed successfully");
    }

    @AfterMethod
    public void tearDown() {

        logger.info("========== Test Teardown Started ==========");

        if (driver != null) {

            DriverFactory.quitDriver();

            logger.info("Browser closed successfully");

        } else {

            logger.warn(
                    "WebDriver is null. Browser was not initialized."
            );
        }

        logger.info(
                "========== Test Teardown Completed =========="
        );
    }
}