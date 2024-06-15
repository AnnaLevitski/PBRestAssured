package com.api;

import com.core.listeners.RetryAnalyzer;
import com.core.models.dto.AuthRequestDTO;
import com.core.models.dto.AuthResponceDTO;
import com.core.models.dto.ErrorDto;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.core.providers.TestDataGenerator.*;
import static com.core.utils.Constants.PASSWORD;
import static com.core.utils.Constants.USER_NAME;
import static io.restassured.RestAssured.given;


public class LoginTests extends AuthController {

    @Test(invocationCount = 3, retryAnalyzer = RetryAnalyzer.class)
    public void login_success(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(PASSWORD).build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 200);
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login_negativePassvordWrong(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(randomPasswordWrong()).build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 401);
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login_negativePassvord(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(randomPassword()).build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 401);
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login_negativeEmail(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(randomEmail()).password(PASSWORD).build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 401);
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login_negativeEmailWrong(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(randomEmailWrong()).password(PASSWORD).build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 401);
    }

}
