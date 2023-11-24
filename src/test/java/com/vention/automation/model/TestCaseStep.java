package com.vention.automation.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TestCaseStep {
    @EqualsAndHashCode.Include private String action;
    private String data;
    private String expectedResult;

    public TestCaseStep() {}

    public TestCaseStep(String action, String data, String expectedResult) {
        this.action = action;
        this.data = data;
        this.expectedResult = expectedResult;
    }
}
