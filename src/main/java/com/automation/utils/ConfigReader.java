package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (InputStream inputStream =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config/config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties file not found");
            }

            properties.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Property not found: " + key);
        }

        return value;
    }
}