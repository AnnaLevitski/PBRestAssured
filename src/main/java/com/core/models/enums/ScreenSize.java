package com.core.models.enums;

import lombok.Getter;

public enum ScreenSize {
    DESKTOP_L(1920, 1080),
    DESKTOP_M(1536, 864),
    DESKTOP_S(1280, 720),
    MOBILE_M(414, 896),
    MOBILE_S(360, 800),
    TABLET(768, 1024);


    @Getter
    private final int width;
    @Getter
    private final int height;

    ScreenSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}