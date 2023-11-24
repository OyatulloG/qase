package com.vention.automation.step;

import com.vention.automation.model.Project;
import com.vention.automation.page.project.CreateProjectPage;
import com.vention.automation.page.project.DeleteProjectPage;
import com.vention.automation.page.project.ProjectPage;
import com.vention.automation.page.project.ProjectsPage;
import com.vention.automation.service.ProjectBuilder;
import com.vention.automation.util.StringUtil;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ProjectStep {
    private final Logger logger;
    private final CreateProjectPage createProjectPage;
    private final DeleteProjectPage deleteProjectPage;
    private final ProjectPage projectPage;
    private final ProjectsPage projectsPage;

    public ProjectStep(WebDriver driver, Logger logger) {
        this.logger = logger;
        createProjectPage = new CreateProjectPage(driver);
        deleteProjectPage = new DeleteProjectPage(driver);
        projectPage = new ProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    @Step("New Project is created")
    public void createProject(Project project) {
        createProjectPage.enterProjectName(project.getName());
        createProjectPage.enterProjectCode(project.getCode());
        createProjectPage.clickCreateProjectButton();
        logger.info("New Project is created.");
        Allure.addAttachment("Logger Info", "New Project is created.");
    }

    @Step("Project is deleted")
    public void deleteProject(Project project) {
        projectsPage.clickThreeDotsIcon(project.getName());
        projectsPage.clickRemoveButton();
        deleteProjectPage.clickDeleteProjectButton();
        logger.info("Project is deleted.");
        Allure.addAttachment("Logger Info", "Project is deleted.");
    }

    @Step("Create New Project button is clicked")
    public void clickCreateNewProjectButton() {
        projectsPage.clickCreateNewProjectButton();
        logger.info("Create New Project button is clicked.");
        Allure.addAttachment("Logger Info", "Create New Project button is clicked.");
    }

    public void clickCreateSuiteButton() {
        projectPage.clickCreateSuiteButton();
        logger.info("Create Suite button is clicked.");
        Allure.addAttachment("Logger Info", "Create Suite button is clicked.");
    }

    public void clickCreateCaseButton() {
        projectPage.clickCreateCaseButton();
        logger.info("Create Case button is clicked.");
        Allure.addAttachment("Logger Info", "Create Case button is clicked.");
    }

    public void clickDefectsButton() {
        projectPage.clickDefectsButton();
        logger.info("Defects button is clicked.");
        Allure.addAttachment("Logger Info", "Defects button is clicked.");
    }

    public Project getCreatedProject() {
        return Project.builder()
                .name(projectPage.getProjectName())
                .code(StringUtil.getProjectCode(projectPage.getProjectCode()))
                .build();
    }

    public Project getDeletedProject(Project project) {
        if (projectsPage.isProjectDeleted(project.getName())) {
            return getCreatedProject();
        } else {
            return null;
        }
    }

}
