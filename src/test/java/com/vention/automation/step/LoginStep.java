package com.vention.automation.step;

import com.vention.automation.model.User;
import com.vention.automation.page.LoginPage;
import com.vention.automation.service.UserBuilder;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.Logger;

public class LoginStep {
    private final Logger logger;
    private final LoginPage loginPage;

    public LoginStep(WebDriver driver, Logger logger) {
        loginPage = new LoginPage(driver);
        this.logger = logger;
    }

    @Step("User logged in")
    public void login() {
        User user = new User(UserBuilder.getRegisteredEmail(), UserBuilder.getValidPassword());
        loginPage.openPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickSignInButton();
        logger.info("User is logged in.");
        Allure.addAttachment("Logger Info", "User is logged in.");
    }
}
