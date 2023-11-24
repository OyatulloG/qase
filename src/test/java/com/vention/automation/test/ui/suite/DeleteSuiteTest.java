package com.vention.automation.test.ui.suite;

import com.vention.automation.model.Project;
import com.vention.automation.service.ProjectBuilder;
import com.vention.automation.step.LoginStep;
import com.vention.automation.step.ProjectStep;
import com.vention.automation.model.Suite;
import com.vention.automation.page.project.ProjectPage;
import com.vention.automation.step.SuiteStep;
import com.vention.automation.test.CommonConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteSuiteTest extends CommonConditions {
    private Logger logger;
    private Project project;
    private LoginStep loginStep;
    private ProjectStep projectStep;
    private SuiteStep suiteStep;
    private Suite suite;
    private ProjectPage projectPage;

    @BeforeClass
    public void init() {
        project = Project.builder()
                .name(ProjectBuilder.getProjectName())
                .code(ProjectBuilder.getProjectCode())
                .build();
        loginStep = new LoginStep(driver, logger);
        projectStep = new ProjectStep(driver, logger);
        suiteStep = new SuiteStep(driver);
        projectPage = new ProjectPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        loginStep.login();
        projectStep.clickCreateNewProjectButton();
        projectStep.createProject(project);
        projectStep.clickCreateSuiteButton();
        suite = suiteStep.createSuite();
    }

    @Test
    public void deleteSuite() {
        suiteStep.deleteSuite(suite);
        assertThat("Suite is not deleted", projectPage.isSuiteDeleted(), is(true));
    }
}
