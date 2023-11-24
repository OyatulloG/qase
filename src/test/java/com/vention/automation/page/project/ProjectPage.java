package com.vention.automation.page.project;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectPage extends AbstractPage {
    private final String createSuiteButtonName = "//*[@id='create-suite-button']";
    private final String createCaseButtonName = "//*[@id='create-case-button']";
    private final String suiteCreatedAlertTextBox = "//*[contains(text(), 'Suite was successfully created')]";
    private final String suiteDeletedAlertTextBox = "//*[contains(text(), 'Suite was successfully deleted')]";
    private final String testCaseCreatedAlertTextBox = "//*[contains(text(), 'Test case was created successfully')]";
    private final String projectNameTextBoxName = "//*[@class='LALnEw']";
    private final String projectCodeTextBoxName = "//*[@class='fGDnu0']";
    private final String defectsButtonName = "//*[contains(text(), 'Defects')]";

    @FindBy(xpath = createSuiteButtonName)
    private WebElement createSuiteButton;
    @FindBy(xpath = createCaseButtonName)
    private WebElement createCaseButton;
    @FindBy(xpath = defectsButtonName)
    private WebElement defectsButton;
    @FindBy(xpath = projectNameTextBoxName)
    private WebElement projectNameTextBox;
    @FindBy(xpath = projectCodeTextBoxName)
    private WebElement projectCodeTextBox;

    public ProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickCreateSuiteButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createSuiteButton)).click();
    }

    public void clickCreateCaseButton() {
        createCaseButton.click();
    }

    public void clickSuiteTrashIcon(String suiteName) {
        driver.findElement(By.xpath("//span[contains(text(), '" + suiteName + "')]/following-sibling::div/button[4]")).click();
    }

    public void clickDefectsButton() {
        defectsButton.click();;
    }

    public String getProjectName() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(projectNameTextBox)).getText();
    }

    public String getProjectCode() {
        return projectCodeTextBox.getText();
    }

    public boolean isSuiteCreated() {
        return !driver.findElements(By.xpath(suiteCreatedAlertTextBox)).isEmpty();
    }

    public boolean isSuiteDeleted() {
        return !driver.findElements(By.xpath(suiteDeletedAlertTextBox)).isEmpty();
    }

    public boolean isTestCaseCreated() {
        return !driver.findElements(By.xpath(testCaseCreatedAlertTextBox)).isEmpty();
    }
}
