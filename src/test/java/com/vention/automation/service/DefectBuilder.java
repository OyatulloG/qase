package com.vention.automation.service;

import com.github.javafaker.Faker;

public class DefectBuilder {
    private final static Faker faker = new Faker();

    public static String getTitle() {
        return faker.lorem().sentence(0);
    }

    public static String getActualResult() {
        return faker.lorem().sentence(3, 7);
    }
}
