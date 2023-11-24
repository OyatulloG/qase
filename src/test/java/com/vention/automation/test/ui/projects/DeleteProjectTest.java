package com.vention.automation.test.ui.projects;

import com.vention.automation.step.HeaderStep;
import com.vention.automation.page.project.ProjectsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteProjectTest extends ProjectCommonConditions {
    private HeaderStep headerStep;
    private ProjectsPage projectsPage;

    @BeforeMethod
    public void init() {
        super.init();
        headerStep = new HeaderStep(driver, logger);
        projectsPage = new ProjectsPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        super.precondition();
        projectStep.clickCreateNewProjectButton();
        projectStep.createProject(expectedProject);
        headerStep.goToProjectsPage();
    }

    @Test(description = "Delete the project")
    public void deleteProject() {
        projectStep.deleteProject(expectedProject);
        //Project deletedProject = projectStep.getDeletedProject(expectedProject);
        assertThat("Project is not deleted", projectsPage.isProjectDeleted(expectedProject.getName()), is(true));
        //assertThat("Deleted Project is not equal to Expected Project", deletedProject, is(expectedProject));
    }

    @Test(description = "Open the project test")
    public void openProject() {
        projectStep.clickCreateNewProjectButton();
    }
}
