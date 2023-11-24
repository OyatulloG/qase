package com.vention.automation.test.ui.suite;

import com.vention.automation.model.Project;
import com.vention.automation.service.ProjectBuilder;
import com.vention.automation.step.LoginStep;
import com.vention.automation.step.ProjectStep;
import com.vention.automation.page.project.ProjectPage;
import com.vention.automation.step.SuiteStep;
import com.vention.automation.test.CommonConditions;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateSuiteTest extends CommonConditions {
    private Logger logger;
    private Project project;
    private LoginStep loginStep;
    private ProjectStep projectStep;
    private SuiteStep suiteStep;
    private ProjectPage projectPage;

    @BeforeTest
    public void setup() {
        logger = (Logger) LogManager.getLogger();
        PatternLayout layout = PatternLayout.newBuilder().withPattern("%d{yyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n").build();
        Appender appender = FileAppender.newBuilder().setName("FileAppender").withFileName("target\\logs\\create-project").setLayout(layout).build();
        logger.addAppender(appender);
    }

    @BeforeClass
    public void init() {
        project = Project.builder().name(ProjectBuilder.getProjectName()).code(ProjectBuilder.getProjectCode()).build();
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
    }

    @Test
    public void createSuite() {
        projectStep.clickCreateSuiteButton();
        suiteStep.createSuite();
        assertThat("Suite is not created", projectPage.isSuiteCreated(), is(true));
    }
}
