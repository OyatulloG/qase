package com.vention.automation.test.ui.testcase;

import com.vention.automation.model.Project;
import com.vention.automation.page.project.ProjectPage;
import com.vention.automation.service.ProjectBuilder;
import com.vention.automation.step.LoginStep;
import com.vention.automation.step.ProjectStep;
import com.vention.automation.step.TestCaseStep;
import com.vention.automation.test.CommonConditions;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CreateTestCaseWithOptionalFieldsTest extends CommonConditions {
    private Logger logger;
    private Project project;
    private LoginStep loginStep;
    private ProjectStep projectStep;
    private TestCaseStep testCaseStep;
    private ProjectPage projectPage;

    @BeforeClass
    public void init() {
        project = Project.builder()
                .name(ProjectBuilder.getProjectName())
                .code(ProjectBuilder.getProjectCode())
                .build();
        loginStep = new LoginStep(driver, logger);
        projectStep = new ProjectStep(driver, logger);
        testCaseStep = new TestCaseStep(driver);
        projectPage = new ProjectPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        loginStep.login();
        projectStep.clickCreateNewProjectButton();
        projectStep.createProject(project);
    }

    @Test
    public void createTestCaseWithOptionalFields() {
        projectStep.clickCreateCaseButton();
        testCaseStep.createTestCaseWithOptionalFields();
        assertThat("Test Case is not created", projectPage.isTestCaseCreated(), is(true));
    }
}
