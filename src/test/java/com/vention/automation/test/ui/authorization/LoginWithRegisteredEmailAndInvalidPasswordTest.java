package com.vention.automation.test.ui.authorization;

import com.vention.automation.model.User;
import com.vention.automation.page.LoginPage;
import com.vention.automation.service.UserBuilder;
import com.vention.automation.test.CommonConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginWithRegisteredEmailAndInvalidPasswordTest extends CommonConditions {
    private LoginPage loginPage;

    @BeforeClass
    public void init() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithRegisteredEmailAndInvalidPassword() {
        User user = new User(UserBuilder.getRegisteredEmail(), UserBuilder.getInvalidPassword());
        loginPage.openPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickSignInButton();
        assertThat("Unmatched Credentials Alert is not displayed", loginPage.isUnmatchedCredentialsAlertTextBoxExist(), is(true));
    }
}
