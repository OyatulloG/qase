package com.vention.automation.test;

import com.vention.automation.driver.DriverSingleton;
import com.vention.automation.service.ConfigReader;
import com.vention.automation.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;

public class CommonConditions {
    private final String LOG_PATTERN_LAYOUT = ConfigReader.getData("log.pattern.layout");
    private final String LOG_FOLDER = ConfigReader.getData("log.folder");
    private String testClassName;
    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        testClassName = StringUtil.getTestClassName(this.getClass().getName());
    }

    @BeforeMethod
    public void setUpLog(ITestResult result) {
        logger = (Logger) LogManager.getLogger(result.getMethod().getMethodName());
        PatternLayout layout = PatternLayout.newBuilder().withPattern(LOG_PATTERN_LAYOUT).build();
        Appender fileAppender = FileAppender.newBuilder().setName(result.getMethod().getMethodName()).withFileName(LOG_FOLDER + testClassName + "\\" + result.getMethod().getMethodName() + ".log").setLayout(layout).build();
        logger.addAppender(fileAppender);
    }
    
    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
