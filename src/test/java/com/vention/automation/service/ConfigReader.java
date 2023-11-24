package com.vention.automation.service;

import java.util.ResourceBundle;

public class ConfigReader {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(System.getProperty("config"));

    public static String getData(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
