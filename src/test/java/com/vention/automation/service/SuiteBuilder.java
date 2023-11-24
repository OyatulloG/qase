package com.vention.automation.service;

import com.github.javafaker.Faker;

public class SuiteBuilder {
    private final static Faker faker = new Faker();
    private final static String SUITE_PARENT_SUITES = "suite.parentSuites";

    public static String getSuiteName() {
        return faker.lorem().sentence(0);
    }

    public static String getSuiteParentSuite() {
        return faker.options().nextElement(TestDataReader.getTestData(SUITE_PARENT_SUITES).split(","));
    }

    public static String getSuiteDescription() {
        return faker.lorem().sentence(7, 23);
    }

    public static String getSuitePreconditions() {
        return faker.lorem().sentence(7, 23);
    }
}
