package com.vention.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private final String URL = "https://app.qase.io/login";
    private final String emailField  = "//*[@name='email']";
    private final String passwordField = "//*[@name='password']";
    private final String signInButtonName = "//*[contains(text(), 'Sign in')]";
    private final String unmatchedCredentialsAlertTextBoxName = "//*[contains(text(), 'These credentials do not match our records')]";

    @FindBy(xpath = emailField)
    private WebElement emailInputBox;
    @FindBy(xpath = passwordField)
    private WebElement passwordInputBox;
    @FindBy(xpath = signInButtonName)
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void enterEmail(String email) {
        emailInputBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInputBox.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isUnmatchedCredentialsAlertTextBoxExist() {
        return !driver.findElements(By.xpath(unmatchedCredentialsAlertTextBoxName)).isEmpty();
    }
}
