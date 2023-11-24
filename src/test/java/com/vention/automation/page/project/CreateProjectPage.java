package com.vention.automation.page.project;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectPage extends AbstractPage {
    private final String projectNameField = "//*[@id='project-name']";
    private final String projectCodeField = "//*[@id='project-code']";
    private final String createProjectButtonName = "//*[contains(text(), 'Create project')]";

    @FindBy(xpath = projectNameField)
    private WebElement projectNameInputBox;
    @FindBy(xpath = projectCodeField)
    private WebElement projectCodeInputBox;
    @FindBy(xpath = createProjectButtonName)
    private WebElement createProjectButton;

    public CreateProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void enterProjectName(String projectName) {
        projectNameInputBox.sendKeys(projectName);
    }

    public void enterProjectCode(String projectCode) {
        projectCodeInputBox.clear();
        projectCodeInputBox.sendKeys(projectCode);
    }

    public void clickCreateProjectButton() {
        createProjectButton.click();
    }

}
