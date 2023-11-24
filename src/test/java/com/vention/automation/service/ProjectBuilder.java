package com.vention.automation.service;

import com.github.javafaker.Faker;

public class ProjectBuilder {
    private final static Faker faker = new Faker();
    private final static String PROJECT_ACCESS_TYPES = "project.accessTypes";
    private final static String PROJECT_MEMBER_ACCESSES = "project.memberAccesses";
    private final static String PROJECT_CODE_MIN = "project.code.minLength";
    private final static String PROJECT_CODE_MAX = "project.code.maxLength";

    public static String getProjectName() {
        return faker.lorem().sentence(0);
    }

    public static String getProjectCode() {
        return faker.lorem().characters(Integer.parseInt(TestDataReader.getTestData(PROJECT_CODE_MIN)),
                Integer.parseInt(TestDataReader.getTestData(PROJECT_CODE_MAX))).toUpperCase();
    }

    public static String getProjectDescription() {
        return faker.lorem().sentence(7, 23);
    }

    public static String getProjectAccessType() {
        return faker.options().nextElement(TestDataReader.getTestData(PROJECT_ACCESS_TYPES).split(","));
    }

    public static String getProjectMemberAccess() {
        return faker.options().nextElement(TestDataReader.getTestData(PROJECT_MEMBER_ACCESSES).split(","));
    }
}
