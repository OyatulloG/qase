package com.vention.automation.test.ui.defect;

import com.vention.automation.model.Defect;
import com.vention.automation.model.Project;
import com.vention.automation.page.defect.DefectsPage;
import com.vention.automation.service.ProjectBuilder;
import com.vention.automation.step.DefectStep;
import com.vention.automation.step.LoginStep;
import com.vention.automation.step.ProjectStep;
import com.vention.automation.test.CommonConditions;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DeleteDefectTest extends CommonConditions {
    private Logger logger;
    private Project project;
    private Defect defect;
    private DefectStep defectStep;
    private LoginStep loginStep;
    private ProjectStep projectStep;
    private DefectsPage defectsPage;

    @BeforeClass
    public void init() {
        project = Project.builder()
                .name(ProjectBuilder.getProjectName())
                .code(ProjectBuilder.getProjectCode())
                .build();
        defectStep = new DefectStep(driver);
        loginStep = new LoginStep(driver, logger);
        projectStep = new ProjectStep(driver, logger);
        defectsPage = new DefectsPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        loginStep.login();
        projectStep.clickCreateNewProjectButton();
        projectStep.createProject(project);
        projectStep.clickDefectsButton();
        defectStep.clickCreateDefectButton();
        defect = defectStep.createDefect();
    }

    @Test
    public void deleteDefect() {
        defectStep.deleteDefect(defect);
        assertThat("Defect is not deleted", defectsPage.isDefectDeleted(), is(true));
    }
}
