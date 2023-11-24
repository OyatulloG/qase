package com.vention.automation.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Suite {
    @EqualsAndHashCode.Include private String name;
    private String parentSuite = "Project root";
    private String description = "";
    private String preconditions = "";

    public Suite(String name) {
        this.name = name;
    }

    public Suite(String name, String parentSuite, String description, String preconditions) {
        this.name = name;
        this.parentSuite = parentSuite;
        this.description = description;
        this.preconditions = preconditions;
    }
}
