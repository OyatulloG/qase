package com.vention.automation.service;

import com.github.javafaker.Faker;

public class UserBuilder {
    private final static Faker faker = new Faker();
    private final static String USER_REGISTERED_EMAIL = "user.registered.email";
    private final static String USER_VALID_PASSWORD = "user.valid.password";

    public static String getRegisteredEmail() {
        return TestDataReader.getTestData(USER_REGISTERED_EMAIL);
    }

    public static String getValidPassword() {
        return TestDataReader.getTestData(USER_VALID_PASSWORD);
    }

    public static String getUnregisteredEmail() {
        return faker.internet().emailAddress();
    }

    public static String getInvalidPassword() {
        return faker.internet().password(12, 20, true, true, true);
    }

    public static String getWeakPassword() {
        return faker.internet().password(3, 6, false, false, false);
    }
}
