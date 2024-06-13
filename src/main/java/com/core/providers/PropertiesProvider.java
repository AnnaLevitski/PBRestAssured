package com.core.providers;

import com.core.utils.Path;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider implements Path {
    /**
     * @param key from file .properties
     * @return value from file .properties
     */
    public static String getProperty(String key){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/com/core/utils/configuration.properties");
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
}
