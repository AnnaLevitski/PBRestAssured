package com.api;

import com.core.models.dto.AuthRequestDTO;
import com.core.models.dto.AuthResponceDTO;
import com.core.models.dto.ErrorDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthController extends  BaseApi{
    public static String urlLogin = "v1/user/login/usernamepassword";
    public static String urlReg = "v1/user/registration/usernamepassword";
    public static Response auth(AuthRequestDTO authRequestDTO, String url){
        return given()
                .body(authRequestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(baseURL+url)
                .thenReturn();
    }
    public int statusCodeAuth(AuthRequestDTO authRequestDTO, String url){
        return auth(authRequestDTO,url).statusCode();
    }
    public String messageErrorAuth(AuthRequestDTO authRequestDTO, String url){
        return (String) auth(authRequestDTO,url).getBody().as(ErrorDto.class).getMessage();
    }
    public String getTokenAuth(AuthRequestDTO authRequestDTO, String url){
        return (String) auth(authRequestDTO,url).getBody().as(AuthResponceDTO.class).getToken();
    }
}
