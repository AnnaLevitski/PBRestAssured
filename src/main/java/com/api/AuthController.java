package com.api;

import com.core.models.dto.AuthRequestDTO;
import com.core.models.dto.AuthResponceDTO;
import com.core.models.dto.ErrorDto;
import com.core.providers.PropertiesProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.core.exceptions.TokenNotReceivedException;
import static com.core.providers.TestDataGenerator.randomEmail;
import static com.core.providers.TestDataGenerator.randomPassword;
import static com.core.utils.Constants.*;
import static io.restassured.RestAssured.given;

public class AuthController {
    public static String urlLogin = "v1/user/login/usernamepassword";
    public static String urlReg = "v1/user/registration/usernamepassword";
    private static Response auth(AuthRequestDTO authRequestDTO, String url){
        return given()
                .body(authRequestDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(URL_API+url)
                .thenReturn();
    }
    public int statusCodeAuth(AuthRequestDTO authRequestDTO, String url){
        return auth(authRequestDTO,url).statusCode();
    }
    public String messageErrorAuth(AuthRequestDTO authRequestDTO, String url){
        return (String) auth(authRequestDTO,url).getBody().as(ErrorDto.class).getMessage();
    }

    /**
     * @param authRequestDTO
     * @return String token || new TokenNotReceivedException()
     * if not possible receive token using an existing email and password,
     * a new registration is created to ensure higher level fault tolerance.
     */
    public static String getTokenAuth(AuthRequestDTO authRequestDTO) throws TokenNotReceivedException {
        Response response = auth(authRequestDTO, urlLogin);
        if (response.statusCode() < 300)
            return response.getBody().as(AuthResponceDTO.class).getToken();
        AuthRequestDTO auth = AuthRequestDTO.builder().username(randomEmail()).password(randomPassword()).build();
        Response responseReg = auth(auth, urlReg);
        if(responseReg.statusCode()>300)
            throw new TokenNotReceivedException();
        USER_NAME = auth.getUsername();
        PASSWORD = auth.getPassword();
        PropertiesProvider.setProperty("userName", USER_NAME);
        PropertiesProvider.setProperty("password", PASSWORD);
        return responseReg.as(AuthResponceDTO.class).getToken();
    }
}
