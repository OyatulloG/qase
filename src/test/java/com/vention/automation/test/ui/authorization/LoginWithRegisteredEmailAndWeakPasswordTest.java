package com.vention.automation.test.ui.authorization;

import com.vention.automation.model.User;
import com.vention.automation.page.LoginPage;
import com.vention.automation.page.PasswordResetPage;
import com.vention.automation.service.UserBuilder;
import com.vention.automation.test.CommonConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginWithRegisteredEmailAndWeakPasswordTest extends CommonConditions {
    private LoginPage loginPage;
    private PasswordResetPage passwordResetPage;

    @BeforeClass
    public void init() {
        loginPage = new LoginPage(driver);
        passwordResetPage = new PasswordResetPage(driver);
    }

    @Test
    public void loginWithRegisteredEmailAndWeakPassword() {
        User user = new User(UserBuilder.getRegisteredEmail(), UserBuilder.getWeakPassword());
        loginPage.openPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickSignInButton();
        assertThat("Password Reset Page is not opened", passwordResetPage.isPasswordResetPageOpen(), is(true));
    }
}
