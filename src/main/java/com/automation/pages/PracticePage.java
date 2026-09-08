package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage extends BasePage {

    // Radio Buttons
    private final By bmwRadio =
            By.id("bmwradio");

    private final By benzRadio =
            By.id("benzradio");

    private final By hondaRadio =
            By.id("hondaradio");

    // Checkboxes
    private final By bmwCheckbox =
            By.id("bmwcheck");

    private final By benzCheckbox =
            By.id("benzcheck");

    private final By hondaCheckbox =
            By.id("hondacheck");

    public PracticePage(WebDriver driver) {

        super(driver);
    }

    public void selectBMWRadioButton() {

        click(bmwRadio);
    }

    public void selectBenzRadioButton() {

        click(benzRadio);
    }

    public void selectHondaRadioButton() {

        click(hondaRadio);
    }

    public void selectBMWCheckbox() {

        click(bmwCheckbox);
    }

    public void selectBenzCheckbox() {

        click(benzCheckbox);
    }

    public void selectHondaCheckbox() {

        click(hondaCheckbox);
    }

    public boolean isBMWRadioSelected() {

        return driver.findElement(bmwRadio).isSelected();
    }

    public boolean isBenzRadioSelected() {

        return driver.findElement(benzRadio).isSelected();
    }

    public boolean isHondaRadioSelected() {

        return driver.findElement(hondaRadio).isSelected();
    }

    public boolean isBMWCheckboxSelected() {

        return driver.findElement(bmwCheckbox).isSelected();
    }

    public boolean isBenzCheckboxSelected() {

        return driver.findElement(benzCheckbox).isSelected();
    }

    public boolean isHondaCheckboxSelected() {

        return driver.findElement(hondaCheckbox).isSelected();
    }
}