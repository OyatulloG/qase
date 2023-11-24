package com.vention.automation.page.suite;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteSuitePage extends AbstractPage {
    private final String deleteSuiteButtonName = "//*[contains(text(), 'Delete')]";

    @FindBy(xpath = deleteSuiteButtonName)
    private WebElement deleteSuiteButton;

    public DeleteSuitePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickDeleteSuiteButton() {
        deleteSuiteButton.click();
    }
}
