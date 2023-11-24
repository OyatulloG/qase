package com.vention.automation.util;

public class StringUtil {
    public static String getProjectCode(String textWithCode) {
        return textWithCode.split(" ")[0];
    }

    public static String getTestClassName(String textWithTestClassName) {
        String[] words = textWithTestClassName.split("\\.");
        return words[words.length - 1];
    }
}
