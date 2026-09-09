package com.automation.base;

import com.automation.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    protected final Logger logger =
            LogManager.getLogger(getClass());

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);

        logger.debug(
                "Initialized page object: {}",
                getClass().getSimpleName()
        );
    }


    // =========================
    // Browser Actions
    // =========================

    protected void navigateTo(String url) {

        logger.info("Navigating to URL: {}", url);

        driver.get(url);
    }

    protected String getPageTitle() {

        String title = driver.getTitle();

        logger.debug("Current page title: {}", title);

        return title;
    }

    protected String getCurrentUrl() {

        String url = driver.getCurrentUrl();

        logger.debug("Current URL: {}", url);

        return url;
    }

    protected void navigateBack() {

        logger.info("Navigating back");

        driver.navigate().back();
    }

    protected void navigateForward() {

        logger.info("Navigating forward");

        driver.navigate().forward();
    }

    protected void refreshPage() {

        logger.info("Refreshing page");

        driver.navigate().refresh();
    }


    // =========================
    // Element Actions
    // =========================

    protected void click(By locator) {

        logger.info(
                "Clicking element: {}",
                locator
        );

        wait.waitForClickable(locator).click();
    }

    protected void enterText(
            By locator,
            String text) {

        logger.info(
                "Entering text into element: {}",
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected void clearText(By locator) {

        logger.info(
                "Clearing text from element: {}",
                locator
        );

        wait.waitForVisibility(locator).clear();
    }

    protected String getText(By locator) {

        logger.debug(
                "Getting text from element: {}",
                locator
        );

        return wait.waitForVisibility(locator).getText();
    }

    protected String getAttribute(
            By locator,
            String attribute) {

        logger.debug(
                "Getting attribute '{}' from element: {}",
                attribute,
                locator
        );

        return wait.waitForVisibility(locator)
                .getAttribute(attribute);
    }


    // =========================
    // Element State
    // =========================

    protected boolean isDisplayed(By locator) {

        logger.debug(
                "Checking if element is displayed: {}",
                locator
        );

        return wait.waitForVisibility(locator)
                .isDisplayed();
    }

    protected boolean isEnabled(By locator) {

        logger.debug(
                "Checking if element is enabled: {}",
                locator
        );

        return wait.waitForVisibility(locator)
                .isEnabled();
    }

    protected boolean isSelected(By locator) {

        logger.debug(
                "Checking if element is selected: {}",
                locator
        );

        return wait.waitForVisibility(locator)
                .isSelected();
    }


    // =========================
    // Dropdown Actions
    // =========================

    protected void selectByVisibleText(
            By locator,
            String text) {

        logger.info(
                "Selecting '{}' from dropdown: {}",
                text,
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByVisibleText(text);
    }

    protected void selectByValue(
            By locator,
            String value) {

        logger.info(
                "Selecting value '{}' from dropdown: {}",
                value,
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByValue(value);
    }

    protected void selectByIndex(
            By locator,
            int index) {

        logger.info(
                "Selecting index '{}' from dropdown: {}",
                index,
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        select.selectByIndex(index);
    }

    protected String getSelectedOption(By locator) {

        logger.debug(
                "Getting selected option from dropdown: {}",
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        String selectedOption =
                select.getFirstSelectedOption().getText();

        logger.debug(
                "Selected option: {}",
                selectedOption
        );

        return selectedOption;
    }

    protected List<WebElement> getAllOptions(By locator) {

        logger.debug(
                "Getting all options from dropdown: {}",
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        Select select = new Select(element);

        return select.getOptions();
    }


    // =========================
    // Checkbox / Radio Actions
    // =========================

    protected void selectCheckbox(By locator) {

        logger.info(
                "Selecting checkbox/radio button: {}",
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        if (!element.isSelected()) {

            element.click();

            logger.debug(
                    "Element selected successfully: {}",
                    locator
            );

        } else {

            logger.debug(
                    "Element already selected: {}",
                    locator
            );
        }
    }

    protected void unselectCheckbox(By locator) {

        logger.info(
                "Unselecting checkbox: {}",
                locator
        );

        WebElement element =
                wait.waitForVisibility(locator);

        if (element.isSelected()) {

            element.click();

            logger.debug(
                    "Checkbox unselected successfully: {}",
                    locator
            );

        } else {

            logger.debug(
                    "Checkbox already unselected: {}",
                    locator
            );
        }
    }


    // =========================
    // Window / Tab Handling
    // =========================

    protected String getCurrentWindowHandle() {

        String windowHandle =
                driver.getWindowHandle();

        logger.debug(
                "Current window handle: {}",
                windowHandle
        );

        return windowHandle;
    }

    protected Set<String> getAllWindowHandles() {

        Set<String> windowHandles =
                driver.getWindowHandles();

        logger.debug(
                "Total browser windows/tabs: {}",
                windowHandles.size()
        );

        return windowHandles;
    }

    protected void switchToWindow(
            String windowHandle) {

        logger.info(
                "Switching to window/tab: {}",
                windowHandle
        );

        driver.switchTo().window(windowHandle);
    }

    protected void switchToNewWindow(
            String parentWindow) {

        logger.info(
                "Looking for newly opened window/tab"
        );

        Set<String> allWindows =
                driver.getWindowHandles();

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                logger.info(
                        "Switching to newly opened window/tab: {}",
                        window
                );

                driver.switchTo().window(window);

                return;
            }
        }

        logger.error(
                "No new window/tab found. Parent window: {}",
                parentWindow
        );

        throw new IllegalStateException(
                "No new window/tab found."
        );
    }

    protected void closeCurrentWindow() {

        logger.info(
                "Closing current window/tab"
        );

        driver.close();
    }


    // =========================
    // Element Count
    // =========================

    protected int getElementCount(By locator) {

        int count =
                driver.findElements(locator).size();

        logger.debug(
                "Element count for {}: {}",
                locator,
                count
        );

        return count;
    }
}