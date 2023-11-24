package com.vention.automation.test.ui.authorization;

import com.vention.automation.model.User;
import com.vention.automation.page.LoginPage;
import com.vention.automation.page.project.ProjectsPage;
import com.vention.automation.service.UserBuilder;
import com.vention.automation.test.CommonConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginWithRegisteredEmailAndValidPasswordTest extends CommonConditions {
    private LoginPage loginPage;
    private ProjectsPage projectsPage;

    @BeforeClass
    public void init() {
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    @Test
    public void loginWithRegisteredEmailAndValidPassword() {
        User user = new User(UserBuilder.getRegisteredEmail(), UserBuilder.getValidPassword());
        loginPage.openPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickSignInButton();
        assertThat("Projects Page is not opened", projectsPage.isProjectsPageOpen(), is(true));
    }
}
