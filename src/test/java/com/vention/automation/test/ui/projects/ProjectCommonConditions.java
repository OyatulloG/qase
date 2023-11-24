package com.vention.automation.test.ui.projects;

import com.vention.automation.model.Project;
import com.vention.automation.service.ProjectBuilder;
import com.vention.automation.step.LoginStep;
import com.vention.automation.step.ProjectStep;
import com.vention.automation.test.CommonConditions;
import org.testng.annotations.BeforeMethod;

public class ProjectCommonConditions extends CommonConditions {
    protected Project expectedProject;
    protected LoginStep loginStep;
    protected ProjectStep projectStep;

    @BeforeMethod
    public void init() {
        expectedProject = Project.builder().name(ProjectBuilder.getProjectName()).code(ProjectBuilder.getProjectCode()).build();
        loginStep = new LoginStep(driver, logger);
        projectStep = new ProjectStep(driver, logger);
    }

    @BeforeMethod
    public void precondition() {
        loginStep.login();
    }
}
