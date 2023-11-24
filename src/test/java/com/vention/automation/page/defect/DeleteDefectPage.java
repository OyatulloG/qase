package com.vention.automation.page.defect;

import com.vention.automation.page.AbstractPage;
import com.vention.automation.test.CommonConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteDefectPage extends AbstractPage {
    private final String deleteButtonName = "//*[contains(text(), 'Delete')]";

    @FindBy(xpath = deleteButtonName)
    private WebElement deleteButton;

    public DeleteDefectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }
}
