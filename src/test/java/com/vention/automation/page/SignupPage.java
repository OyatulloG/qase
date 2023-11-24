package com.vention.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends AbstractPage {
    private final String URL = "https://app.qase.io/signup";
    private final String emailFieldName = "//*[@name='email']";
    private final String passwordFieldName = "//*[@name='password']";
    private final String passwordConfirmationFieldName = "//*[@name='passwordConfirmation']";
    private final String signUpButtonName = "//*[contains(text(), 'Sign up with email')]";
    private final String passwordRequirementTextBoxName = "//*[contains(text(), 'Password must has at least 12 characters')]";

    @FindBy(xpath = emailFieldName)
    private WebElement emailInputBox;
    @FindBy(xpath = passwordFieldName)
    private WebElement passwordInputBox;
    @FindBy(xpath = passwordConfirmationFieldName)
    private WebElement passwordConfirmationInputBox;
    @FindBy(xpath = signUpButtonName)
    private WebElement signUpButton;

    public SignupPage(WebDriver driver) {
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

    public void enterPasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationInputBox.sendKeys(passwordConfirmation);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public boolean isPasswordRequirementTextBoxExist() {
        return !driver.findElements(By.xpath(passwordRequirementTextBoxName)).isEmpty();
    }
}
