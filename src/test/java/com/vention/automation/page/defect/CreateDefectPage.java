package com.vention.automation.page.defect;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDefectPage extends AbstractPage {
    private final String defectTitleField = "//*[@id='title']";
    private final String defectActualResultField = "//*[@id='actual_result']";
    private final String createDefectButtonName = "//button[contains(text(), 'Create defect')]";

    @FindBy(xpath = defectTitleField)
    private WebElement defectTitleInputBox;
    @FindBy(xpath = defectActualResultField)
    private WebElement defectActualResultInputBox;
    @FindBy(xpath = createDefectButtonName)
    private WebElement createDefectButton;

    public CreateDefectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickCreateDefectButton() {
        createDefectButton.click();
    }

    public void enterDefectTitle(String defectTitle) {
        defectTitleInputBox.sendKeys(defectTitle);
    }

    public void enterDefectActualResult(String defectActualResult) {
        defectActualResultInputBox.sendKeys(defectActualResult);
    }
}
