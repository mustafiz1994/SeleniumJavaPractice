package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class PracticePage extends BasePage {

    // =========================
    // Radio Buttons
    // =========================

    private final By bmwRadio =
            By.id("bmwradio");

    private final By benzRadio =
            By.id("benzradio");

    private final By hondaRadio =
            By.id("hondaradio");


    // =========================
    // Checkboxes
    // =========================

    private final By bmwCheckbox =
            By.id("bmwcheck");

    private final By benzCheckbox =
            By.id("benzcheck");

    private final By hondaCheckbox =
            By.id("hondacheck");


    // =========================
    // Dropdown
    // =========================

    private final By carDropdown =
            By.id("carselect");


    // =========================
    // Window
    // =========================

    private final By openWindowButton =
            By.id("openwindow");


    // =========================
    // Constructor
    // =========================

    public PracticePage(WebDriver driver) {

        super(driver);

        logger.debug("PracticePage initialized");
    }


    // =========================
    // Radio Button Actions
    // =========================

    public void selectRadioButton(String car) {

        logger.info("Selecting radio button: {}", car);

        switch (car.toLowerCase()) {

            case "bmw":
                click(bmwRadio);
                break;

            case "benz":
                click(benzRadio);
                break;

            case "honda":
                click(hondaRadio);
                break;

            default:

                logger.error(
                        "Unsupported radio button option: {}",
                        car
                );

                throw new IllegalArgumentException(
                        "Unsupported car: " + car);
        }

        logger.debug(
                "Radio button selected successfully: {}",
                car
        );
    }


    public boolean isRadioButtonSelected(String car) {

        logger.debug(
                "Checking radio button selection: {}",
                car
        );

        switch (car.toLowerCase()) {

            case "bmw":
                return isSelected(bmwRadio);

            case "benz":
                return isSelected(benzRadio);

            case "honda":
                return isSelected(hondaRadio);

            default:

                logger.error(
                        "Unsupported radio button option: {}",
                        car
                );

                throw new IllegalArgumentException(
                        "Unsupported car: " + car);
        }
    }


    // =========================
    // Checkbox Actions
    // =========================

    public void selectBMWCheckbox() {

        logger.info("Selecting BMW checkbox");

        selectCheckbox(bmwCheckbox);
    }


    public void selectBenzCheckbox() {

        logger.info("Selecting Benz checkbox");

        selectCheckbox(benzCheckbox);
    }


    public void selectHondaCheckbox() {

        logger.info("Selecting Honda checkbox");

        selectCheckbox(hondaCheckbox);
    }


    public boolean isBMWCheckboxSelected() {

        logger.debug("Checking BMW checkbox selection");

        return isSelected(bmwCheckbox);
    }


    public boolean isBenzCheckboxSelected() {

        logger.debug("Checking Benz checkbox selection");

        return isSelected(benzCheckbox);
    }


    public boolean isHondaCheckboxSelected() {

        logger.debug("Checking Honda checkbox selection");

        return isSelected(hondaCheckbox);
    }


    // =========================
    // Dropdown Actions
    // =========================

    public void selectCarByVisibleText(String car) {

        logger.info(
                "Selecting car from dropdown by visible text: {}",
                car
        );

        selectByVisibleText(carDropdown, car);
    }


    public void selectCarByValue(String value) {

        logger.info(
                "Selecting car from dropdown by value: {}",
                value
        );

        selectByValue(carDropdown, value);
    }


    public void selectCarByIndex(int index) {

        logger.info(
                "Selecting car from dropdown by index: {}",
                index
        );

        selectByIndex(carDropdown, index);
    }


    public String getSelectedCar() {

        logger.debug("Getting selected car from dropdown");

        return getSelectedOption(carDropdown);
    }


    // =========================
    // Window Actions
    // =========================
    private final By openTabButton =
            By.cssSelector("#opentab");

    public void clickOpenWindow() {

        logger.info("Clicking Open Window button");

        click(openWindowButton);
    }

    public void clickOpenTab() {

        logger.info("Clicking Open Tab button");

        click(openTabButton);
    }
    // =========================
// Window / Tab Actions
// =========================

    public String getCurrentWindowHandle() {

        return super.getCurrentWindowHandle();
    }

    public Set<String> getAllWindowHandles() {

        return super.getAllWindowHandles();
    }

    public void switchToWindow(String windowHandle) {

        super.switchToWindow(windowHandle);
    }

    public void switchToNewWindow(String parentWindow) {

        super.switchToNewWindow(parentWindow);
    }

    public void closeCurrentWindow() {

        super.closeCurrentWindow();
    }
}