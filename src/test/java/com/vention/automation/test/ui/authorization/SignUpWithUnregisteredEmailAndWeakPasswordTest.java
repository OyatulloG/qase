package com.vention.automation.test.ui.authorization;

import com.vention.automation.model.User;
import com.vention.automation.page.SignupPage;
import com.vention.automation.service.UserBuilder;
import com.vention.automation.test.CommonConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUpWithUnregisteredEmailAndWeakPasswordTest extends CommonConditions {
    private SignupPage signupPage;

    @BeforeClass
    public void init() {
        signupPage = new SignupPage(driver);
    }

    @Test
    public void signUpWithUnregisteredEmailAndWeakPassword() {
        User user = new User(UserBuilder.getUnregisteredEmail(), UserBuilder.getWeakPassword());
        signupPage.openPage();
        signupPage.enterEmail(user.getEmail());
        signupPage.enterPassword(user.getPassword());
        signupPage.enterPasswordConfirmation(user.getPassword());
        signupPage.clickSignUpButton();
        assertThat("Password Requirement is not displayed", signupPage.isPasswordRequirementTextBoxExist(), is(true));
    }
}
