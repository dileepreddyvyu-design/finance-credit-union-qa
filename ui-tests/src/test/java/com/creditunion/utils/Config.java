package com.creditunion.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties props;
    static {
        props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }
    public static String get(String key){ return props.getProperty(key); }
}
