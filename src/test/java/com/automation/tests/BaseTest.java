package com.automation.tests;

import com.automation.driver.DriverFactory;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        DriverFactory.initializeDriver();

        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}