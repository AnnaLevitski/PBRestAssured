package com.api;

import com.core.models.dto.AuthRequestDTO;
import com.core.models.dto.AuthResponceDTO;

import java.util.Random;

public class BaseApi {
    public BaseApi() {}



    static String baseURL = "https://contactapp-telran-backend.herokuapp.com/";

    String userName = "";
    String password = "";

    public int randomInt(){
        return new Random().nextInt(1000);
    }
    public static String getTokenAuth(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("dototo1223456@gmail.com").password("Mmar123456$").build();
        return (String) AuthController.auth(auth, AuthController.urlLogin).getBody().as(AuthResponceDTO.class).getToken();
    }
}
