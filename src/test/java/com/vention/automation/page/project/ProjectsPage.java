package com.vention.automation.page.project;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectsPage extends AbstractPage {
    private final String createNewProjectButtonName = "//*[@id='createButton']";
    private final String removeButtonName = "//*[contains(text(), 'Remove')]";

    @FindBy(xpath = createNewProjectButtonName)
    private WebElement createNewProjectButton;
    @FindBy(xpath = removeButtonName)
    private WebElement removeButton;

    public ProjectsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickCreateNewProjectButton() {
        createNewProjectButton.click();
    }

    public boolean isProjectsPageOpen() {
        return !driver.findElements(By.xpath(createNewProjectButtonName)).isEmpty();
    }

    public boolean isProjectExist(String projectName) {
        return !driver.findElements(By.xpath("//*[contains(text(), '" + projectName + "')]")).isEmpty();
    }

    public void clickThreeDotsIcon(String projectName) {
        driver.findElement(By.xpath("//*[contains(text(), '" + projectName + "')]/ancestor::td/following-sibling::td[5]//button")).click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public boolean isProjectDeleted(String projectName) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), '" + projectName + "')]")));
    }
}
