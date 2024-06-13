package com.core.exceptions;

public class WrongScreenSizeException extends Exception{
    public WrongScreenSizeException(){
        super("Wrong screen size! \n" +
                "Choose one of: DESKTOP_L, DESKTOP_S, MOBILE_S \n" +
                "src/main/java/com/core/models/enums/ScreenSize.java");
    }
}
