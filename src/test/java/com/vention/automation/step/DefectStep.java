package com.vention.automation.step;

import com.vention.automation.model.Defect;
import com.vention.automation.page.defect.CreateDefectPage;
import com.vention.automation.page.defect.DefectsPage;
import com.vention.automation.page.defect.DeleteDefectPage;
import com.vention.automation.service.DefectBuilder;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DefectStep {
    private final Logger logger = LogManager.getLogger();
    private final CreateDefectPage createDefectPage;
    private final DefectsPage defectsPage;
    private final DeleteDefectPage deleteDefectPage;

    public DefectStep(WebDriver driver) {
        createDefectPage = new CreateDefectPage(driver);
        defectsPage = new DefectsPage(driver);
        deleteDefectPage = new DeleteDefectPage(driver);
    }

    public Defect createDefect() {
        Defect defect = new Defect(DefectBuilder.getTitle(), DefectBuilder.getActualResult());
        createDefectPage.enterDefectTitle(defect.getTitle());
        createDefectPage.enterDefectActualResult(defect.getActualResult());
        createDefectPage.clickCreateDefectButton();
        logger.info("New Defect is created.");
        Allure.addAttachment("Logger Info", "New Defect is created.");
        return defect;
    }

    public void deleteDefect(Defect defect) {
        defectsPage.clickThreeDotsIcon(defect.getTitle());
        defectsPage.clickDeleteButton();
        deleteDefectPage.clickDeleteButton();
        logger.info("Defect is deleted.");
        Allure.addAttachment("Logger Info", "Defect is deleted.");
    }

    public void clickCreateDefectButton() {
        defectsPage.clickCreateDefectButton();
        logger.info("Create Defect button is clicked.");
        Allure.addAttachment("Logger Info", "Create Defect button is clicked.");
    }
}
