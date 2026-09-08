package com.automation.tests;

import com.automation.pages.PracticePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticePageTests extends BaseTest {

    private PracticePage practicePage;

    @BeforeMethod
    public void initializePage() {

        practicePage = new PracticePage(driver);

        logger.debug("PracticePage object initialized");
    }


    // =========================
    // Radio Button Tests
    // =========================

    @DataProvider(name = "carData")
    public Object[][] carData() {

        return new Object[][]{
                {"BMW"},
                {"Benz"},
                {"Honda"}
        };
    }

    @Test(
            priority = 1,
            groups = {"smoke", "regression"},
            dataProvider = "carData"
    )
    public void verifyRadioButtonSelection(String car) {

        logger.info(
                "Starting radio button verification for: {}",
                car
        );

        practicePage.selectRadioButton(car);

        boolean selected =
                practicePage.isRadioButtonSelected(car);

        Assert.assertTrue(
                selected,
                car + " radio button should be selected"
        );

        logger.info(
                "Radio button verification passed for: {}",
                car
        );
    }


    // =========================
    // Checkbox Tests
    // =========================

    @Test(
            priority = 2,
            groups = {"smoke", "regression"}
    )
    public void verifyBMWCheckboxSelection() {

        logger.info("Starting BMW checkbox verification");

        practicePage.selectBMWCheckbox();

        Assert.assertTrue(
                practicePage.isBMWCheckboxSelected(),
                "BMW checkbox should be selected"
        );

        logger.info(
                "BMW checkbox verification passed"
        );
    }


    // =========================
    // Dropdown Tests
    // =========================

    @Test(
            priority = 3,
            groups = {"smoke", "regression"}
    )
    public void verifyCarDropdownSelectionByVisibleText() {

        logger.info(
                "Starting car dropdown verification"
        );

        practicePage.selectCarByVisibleText("BMW");

        String actualCar =
                practicePage.getSelectedCar();

        Assert.assertEquals(
                actualCar,
                "BMW",
                "Expected selected car to be [BMW], " +
                        "but actual selected car was [" +
                        actualCar + "]"
        );

        logger.info(
                "Car dropdown verification passed. Selected car: {}",
                actualCar
        );
    }


    // =========================
    // Switch Window Test
    // =========================

    @Test(
            priority = 4,
            groups = {"smoke", "regression"}
    )
    public void verifySwitchWindow() {

        logger.info(
                "Starting Switch Window verification"
        );

        String parentWindow =
                practicePage.getCurrentWindowHandle();

        logger.debug(
                "Parent window handle: {}",
                parentWindow
        );

        practicePage.clickOpenWindow();

        var allWindows =
                practicePage.getAllWindowHandles();

        logger.debug(
                "Total browser windows after click: {}",
                allWindows.size()
        );

        Assert.assertEquals(
                allWindows.size(),
                2,
                "Expected 2 browser windows, but found "
                        + allWindows.size()
        );

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                practicePage.switchToWindow(window);

                logger.info(
                        "Switched successfully to child window"
                );

                break;
            }
        }

        Assert.assertNotEquals(
                practicePage.getCurrentWindowHandle(),
                parentWindow,
                "Driver should be switched to the new window."
        );

        practicePage.closeCurrentWindow();

        logger.info(
                "Child window closed successfully"
        );

        practicePage.switchToWindow(parentWindow);

        Assert.assertEquals(
                practicePage.getCurrentWindowHandle(),
                parentWindow,
                "Driver should be switched back to the parent window."
        );

        logger.info(
                "Switched successfully back to parent window"
        );

        logger.info(
                "Switch Window verification passed"
        );
    }
}