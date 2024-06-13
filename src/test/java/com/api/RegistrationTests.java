package com.api;

import com.core.models.dto.AuthRequestDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends AuthController {
    @Test
    public void registration_success(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("lok"+randomInt()+"@gmail.com").password("Lok123"+randomInt()+"$").build();
        Assert.assertEquals(statusCodeAuth(auth, urlReg), 200);
    }
    @Test
    public void registration_negativeDuplicateUser(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("mara@gmail.com").password("Mmar123456$").build();
        Assert.assertEquals(statusCodeAuth(auth, urlReg), 409);
        Assert.assertEquals(messageErrorAuth(auth,urlReg), "User already exists");
    }

}
