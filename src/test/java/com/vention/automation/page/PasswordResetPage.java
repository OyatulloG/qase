package com.vention.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordResetPage extends AbstractPage {
    private final String resetPasswordTextBoxName = "//*[contains(text(), 'Reset your password')]";

    public PasswordResetPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPasswordResetPageOpen() {
        return !driver.findElements(By.xpath(resetPasswordTextBoxName)).isEmpty();
    }
}
