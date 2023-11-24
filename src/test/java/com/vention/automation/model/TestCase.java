package com.vention.automation.model;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TestCase {
    @EqualsAndHashCode.Include private String title;
    @EqualsAndHashCode.Include private String status = "Actual";
    private String description = "";
    private String suite = "Test cases without suite";
    @EqualsAndHashCode.Include private String severity = "Normal";
    @EqualsAndHashCode.Include private String priority = "Not set";
    @EqualsAndHashCode.Include private String type = "Other";
    @EqualsAndHashCode.Include private String layer = "Not set";
    @EqualsAndHashCode.Include private boolean isFlaky = false;
    private String milestone = "Not set";
    @EqualsAndHashCode.Include private String behaviour = "Not set";
    @EqualsAndHashCode.Include private String automationStatus = "Not automated";
    private String preConditions = "";
    private String postConditions = "";
    private String tag = "";
    private TestCaseStep[] steps;

    public TestCase(String title) {
        this.title = title;
    }

    public TestCase(String title, String description, String preConditions) {
        this.title = title;
        this.description = description;
        this.preConditions = preConditions;
    }
}
