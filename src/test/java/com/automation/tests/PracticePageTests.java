package com.automation.tests;

import com.automation.pages.PracticePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticePageTests extends BaseTest {

    private PracticePage practicePage;

    @BeforeMethod
    public void initializePage() {

        practicePage = new PracticePage(driver);
    }

    @Test
    public void verifyBMWRadioButtonSelection() {

        practicePage.selectBMWRadioButton();

        Assert.assertTrue(
                practicePage.isBMWRadioSelected(),
                "BMW radio button should be selected");
    }

    @Test
    public void verifyBenzRadioButtonSelection() {

        practicePage.selectBenzRadioButton();

        Assert.assertTrue(
                practicePage.isBenzRadioSelected(),
                "Benz radio button should be selected");
    }

    @Test
    public void verifyHondaRadioButtonSelection() {

        practicePage.selectHondaRadioButton();

        Assert.assertTrue(
                practicePage.isHondaRadioSelected(),
                "Honda radio button should be selected");
    }

    @Test
    public void verifyBMWCheckBox() {

        practicePage.selectBMWCheckbox();

        Assert.assertTrue(
                practicePage.isBMWCheckboxSelected(),
                "BMW Check Box should be selected");
    }

    @Test
    public void verifyBenzCheckBox() {

        practicePage.selectBenzCheckbox();

        Assert.assertTrue(
                practicePage.isBenzCheckboxSelected(),
                "Benz Check Box should be selected");
    }
    @Test
    public void verifyHondaCheckBox() {

        practicePage.selectHondaCheckbox();

        Assert.assertTrue(
                practicePage.isHondaCheckboxSelected(),
                "Benz Check Box should be selected");
    }
}