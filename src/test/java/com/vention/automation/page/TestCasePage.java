package com.vention.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage extends AbstractPage {
    private final String titleField = "//*[@id='title']";
    private final String saveCaseButtonName = "//*[@id='save-case']";
    private final String descriptionField = "//*[@id='0-description']";
    private final String suiteField = "//*[@id='suite']";
    private final String preconditionsField = "//*[@id='0-preconditions']";

    @FindBy(xpath = titleField)
    private WebElement titleInputBox;
    @FindBy(xpath = saveCaseButtonName)
    private WebElement saveCaseButton;
    @FindBy(xpath = descriptionField)
    private WebElement descriptionInputBox;
    @FindBy(xpath = suiteField)
    private WebElement suiteInputBox;
    @FindBy(xpath = preconditionsField)
    private WebElement preconditionsInputBox;

    public TestCasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickSaveCaseButton() {
        saveCaseButton.click();
    }

    public void enterTitle(String title) {
        titleInputBox.sendKeys(title);
    }

    public void enterDescription(String description) {
        descriptionInputBox.sendKeys(description);
    }

    public void enterPreconditions(String preconditions) {
        preconditionsInputBox.sendKeys(preconditions);
    }
}
