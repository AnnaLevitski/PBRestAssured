package com.core.exceptions;

public class TokenNotReceivedException extends Exception{
    public TokenNotReceivedException(){
        super("Token not received \n" +
                "The API is probably dead \n" );
    }
}
