package com.vention.automation.page.defect;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectsPage extends AbstractPage {
    private final String createDefectButtonName = "//*[contains(text(), 'Create new defect')]";
    private final String defectCreatedAlertTextBox = "//*[contains(text(), 'Defect was created successfully!')]";
    private final String deleteButtonName = "//*[contains(text(), 'Delete')]";
    private final String defectDeletedAlertTextBox = "//*[contains(text(), 'successfully deleted')]";

    @FindBy(xpath = createDefectButtonName)
    private WebElement createDefectButton;
    @FindBy(xpath = deleteButtonName)
    private WebElement deleteButton;

    public DefectsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickCreateDefectButton() {
        createDefectButton.click();
    }

    public void clickThreeDotsIcon(String defectTitle) {
        driver.findElement(By.xpath("//*[contains(text(), '" + defectTitle + "')]//ancestor::td//following-sibling::td[6]//button")).click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public boolean isDefectCreated() {
        return !driver.findElements(By.xpath(defectCreatedAlertTextBox)).isEmpty();
    }

    public boolean isDefectDeleted() {
        return !driver.findElements(By.xpath(defectDeletedAlertTextBox)).isEmpty();
    }
}
