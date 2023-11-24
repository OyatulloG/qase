package com.vention.automation.page.project;

import com.vention.automation.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProjectPage extends AbstractPage {
    private final String deleteProjectButtonName = "//*[contains(text(), 'Delete project')]";

    @FindBy(xpath = deleteProjectButtonName)
    private WebElement deleteProjectButton;

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickDeleteProjectButton() {
        deleteProjectButton.click();
    }
}
