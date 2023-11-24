package com.vention.automation.page;

import com.vention.automation.service.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AbstractPage {
    private final String IMPLICIT_WAIT = ConfigReader.getData("implicit.wait.seconds");
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(IMPLICIT_WAIT)));
    }
}
