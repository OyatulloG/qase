package com.vention.automation.step;

import com.vention.automation.model.Suite;
import com.vention.automation.page.project.ProjectPage;
import com.vention.automation.page.suite.DeleteSuitePage;
import com.vention.automation.page.suite.SuitePage;
import com.vention.automation.service.SuiteBuilder;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SuiteStep {
    private final Logger logger = LogManager.getLogger();
    private final DeleteSuitePage deleteSuitePage;
    private final ProjectPage projectPage;
    private final SuitePage suitePage;

    public SuiteStep(WebDriver driver) {
        deleteSuitePage = new DeleteSuitePage(driver);
        projectPage = new ProjectPage(driver);
        suitePage = new SuitePage(driver);
    }

    public Suite createSuite() {
        Suite suite = new Suite(SuiteBuilder.getSuiteName());
        suitePage.enterSuiteName(suite.getName());
        suitePage.clickCreateButton();
        logger.info("New Suite is created.");
        Allure.addAttachment("Logger Info", "New Suite is created.");
        return suite;
    }

    public void deleteSuite(Suite suite) {
        projectPage.clickSuiteTrashIcon(suite.getName());
        deleteSuitePage.clickDeleteSuiteButton();
        logger.info("Suite is deleted.");
        Allure.addAttachment("Logger Info", "Suite is deleted.");
    }
}
