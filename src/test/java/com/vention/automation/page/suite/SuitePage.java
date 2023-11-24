package com.vention.automation.page.suite;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuitePage extends AbstractPage {
    private final String suiteName = "//*[@id='title']";
    private final String createButtonName = "//button[@type='submit']";

    @FindBy(xpath = suiteName)
    private WebElement suiteNameInputBox;
    @FindBy(xpath = createButtonName)
    private WebElement createButton;

    public SuitePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void enterSuiteName(String suiteName) {
        suiteNameInputBox.sendKeys(suiteName);
    }

    public void clickCreateButton() {
        createButton.click();
    }
}
