package com.api;

import com.core.exceptions.TokenNotReceivedException;
import com.core.models.dto.AuthRequestDTO;

import static com.core.utils.Constants.PASSWORD;
import static com.core.utils.Constants.USER_NAME;

public class Token {
    private static String currentToken;

    private Token() {}
    public static String getCurrentToken() {
        if(currentToken==null) {
            currentToken = getToken();
        }
        return currentToken;
    }
    private static String getToken(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(PASSWORD).build();
        try {
            return AuthController.getTokenAuth(auth);
        } catch (TokenNotReceivedException e) {
            throw new RuntimeException(e);
        }

    }




}
