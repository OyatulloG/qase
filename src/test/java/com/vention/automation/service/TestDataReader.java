package com.vention.automation.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(System.getProperty("testData"));

    public static String getTestData(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
