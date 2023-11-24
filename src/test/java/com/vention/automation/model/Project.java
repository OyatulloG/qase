package com.vention.automation.model;

import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Project {
    @EqualsAndHashCode.Include private String name;
    @EqualsAndHashCode.Include private String code;
    private String description = "";
    private String accessType = "Private";
    private String memberAccess = "Add all members to this project";

//    public Project(String name, String code) {
//        this.name = name;
//        this.code = code;
//    }
//
//    public Project(String name, String code, String description, String accessType, String memberAccess) {
//        this.name = name;
//        this.code = code;
//        this.description = description;
//        this.accessType = accessType;
//        this.memberAccess = memberAccess;
//    }
}
