package com.vention.automation.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Defect {
    @EqualsAndHashCode.Include private String title;
    @EqualsAndHashCode.Include private String actualResult;
    private String milestone = "Not set";
    @EqualsAndHashCode.Include private String severity = "Normal";
    private String assignee = "Unassigned";
    private String tags = "";

    public Defect(String title, String actualResult) {
        this.title = title;
        this.actualResult = actualResult;
    }
}
