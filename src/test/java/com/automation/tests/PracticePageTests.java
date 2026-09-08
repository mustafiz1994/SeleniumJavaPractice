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
    }

   /* @Test
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
    */
   @DataProvider(name = "carRadioButtons")
   public Object[][] carRadioButtons() {

       return new Object[][]{
               {"BMW"},
               {"Benz"},
               {"Honda"}
       };
   }

    @Test(
            dataProvider = "carRadioButtons",
            groups = {"smoke", "regression"}
    )
    public void verifyRadioButtonSelection(String car) {

        practicePage.selectRadioButton(car);

        boolean isSelected = practicePage.isRadioButtonSelected(car);

        Assert.assertTrue(
                isSelected,
                "Expected [" + car + "] radio button to be selected, " +
                        "but it was not selected."
        );
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyBMWCheckboxSelection() {

        practicePage.selectBMWCheckbox();

        boolean isSelected = practicePage.isBMWCheckboxSelected();

        Assert.assertTrue(
                isSelected,
                "Expected [BMW] checkbox to be selected, " +
                        "but it was not selected."
        );
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyBenzCheckboxSelection() {

        practicePage.selectBenzCheckbox();

        boolean isSelected = practicePage.isBenzCheckboxSelected();

        Assert.assertTrue(
                isSelected,
                "Expected [Benz] checkbox to be selected, " +
                        "but it was not selected."
        );
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyHondaCheckboxSelection() {

        practicePage.selectHondaCheckbox();

        boolean isSelected = practicePage.isHondaCheckboxSelected();

        Assert.assertTrue(
                isSelected,
                "Expected [Honda] checkbox to be selected, " +
                        "but it was not selected."
        );
    }
}