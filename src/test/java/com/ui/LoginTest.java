package com.ui;

import com.core.models.dto.AuthRequestDTO;
import com.core.models.dto.ContactDTO;
import com.ui.pages.LoginPage;
import org.testng.annotations.Test;

import static com.core.providers.TestDataGenerator.*;
import static com.core.providers.TestDataGenerator.randomText;
import static com.core.utils.Constants.PASSWORD;
import static com.core.utils.Constants.USER_NAME;

public class LoginTest extends TestBase{
    @Test
    public void login(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(PASSWORD).build();
        new LoginPage(driver).navigateToLoginPage().logIn(auth).assertContactPage();
    }
}
