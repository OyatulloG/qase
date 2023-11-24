package com.vention.automation.test.ui.projects;

import com.vention.automation.model.Project;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateProjectTest extends ProjectCommonConditions {
    @Test(description = "Create a new project")
    public void createProject() {
        projectStep.clickCreateNewProjectButton();
        projectStep.createProject(expectedProject);
        Project actualProject = projectStep.getCreatedProject();
        assertThat("Created Project is not equal to Expected Project.", actualProject, is(expectedProject));
    }
}
