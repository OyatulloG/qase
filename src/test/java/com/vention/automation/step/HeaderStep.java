package com.vention.automation.step;

import com.vention.automation.page.HeaderPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HeaderStep {
    private final Logger logger;
    private final HeaderPage headerPage;

    public HeaderStep(WebDriver driver, Logger logger) {
        headerPage = new HeaderPage(driver);
        this.logger = logger;
    }

    @Step("Projects Page is opened")
    public void goToProjectsPage() {
        headerPage.clickProjectsPageButton();
        logger.info("Projects Page button is clicked.");
        Allure.addAttachment("Logger Info", "Projects Page button is clicked.");
    }
}
