package com.vention.automation.service;

import com.github.javafaker.Faker;

public class TestCaseBuilder {
    private final static Faker faker = new Faker();

    public static String getTitle() {
        return faker.lorem().sentence(0);
    }

    public static String getDescription() {
        return faker.lorem().sentence(7, 23);
    }

    public static String getPreConditions() {
        return faker.lorem().sentence(7, 10);
    }
}
