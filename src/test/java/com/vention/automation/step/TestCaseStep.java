package com.vention.automation.step;

import com.vention.automation.model.TestCase;
import com.vention.automation.page.TestCasePage;
import com.vention.automation.service.TestCaseBuilder;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestCaseStep {
    private final Logger logger = LogManager.getLogger();
    private final TestCasePage testCasePage;

    public TestCaseStep(WebDriver driver) {
        testCasePage = new TestCasePage(driver);
    }

    public void createTestCaseWithRequiredFields() {
        TestCase testCase = new TestCase(TestCaseBuilder.getTitle());
        testCasePage.enterTitle(testCase.getTitle());
        testCasePage.clickSaveCaseButton();
        logger.info("Test Case with Required Fields is created.");
        Allure.addAttachment("Logger Info", "Test Case with Required Fields is created.");
    }

    public void createTestCaseWithOptionalFields() {
        TestCase testCase = new TestCase(TestCaseBuilder.getTitle(), TestCaseBuilder.getDescription(), TestCaseBuilder.getPreConditions());
        testCasePage.enterTitle(testCase.getTitle());
        testCasePage.enterDescription(testCase.getDescription());
        testCasePage.enterPreconditions(testCase.getPreConditions());
        testCasePage.clickSaveCaseButton();
        logger.info("Test Case with Optional Fields is created.");
        Allure.addAttachment("Logger Info", "Test Case with Optional Fields is created.");
    }
}
