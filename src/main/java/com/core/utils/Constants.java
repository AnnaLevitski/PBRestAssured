package com.core.utils;

import com.core.providers.PropertiesProvider;

public class Constants {
    public static String USER_NAME = PropertiesProvider.getProperty("userName");
    public static String PASSWORD = PropertiesProvider.getProperty("password");
    public static final String SCREEN = System.getProperty("screen", "DESKTOP_S");
    public static final String URL_UI = PropertiesProvider.getProperty("url_ui");

    public static String URL_API = PropertiesProvider.getProperty("url_api");
}
