package com.api;

import com.core.listeners.RetryAnalyzer;
import com.core.models.dto.AuthRequestDTO;
import com.core.providers.PropertiesProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.core.providers.TestDataGenerator.*;
import static com.core.utils.Constants.PASSWORD;
import static com.core.utils.Constants.USER_NAME;

public class RegistrationTests extends AuthController {
    /**
     * The free API does not provide the ability to delete users,
     * makes impossible to restore test environments to their original state following tests,
     * thus I excluded successful registration tests.
     */
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void registration_negativeDuplicateUser(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(PASSWORD).build();
        Assert.assertEquals(statusCodeAuth(auth, urlReg), 409);
        Assert.assertEquals(messageErrorAuth(auth,urlReg), "User already exists");
    }
    @Test
    public void registration_negativeWrongPassword(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(randomEmail()).password(randomPasswordWrong()).build();
        Assert.assertEquals(statusCodeAuth(auth, urlReg), 400);
    }
    @Test(invocationCount = 5, retryAnalyzer = RetryAnalyzer.class)
    public void registration_negativeWrongEmail(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(randomEmailWrong()).password(randomPassword()).build();
        System.out.println(auth);
        Assert.assertTrue(statusCodeAuth(auth, urlReg) >= 400);
    }

}
